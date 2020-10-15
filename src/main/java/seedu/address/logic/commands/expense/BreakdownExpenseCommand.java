package seedu.address.logic.commands.expense;

import static java.util.Objects.requireNonNull;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import seedu.homerce.logic.commands.Command;
import seedu.homerce.logic.commands.CommandResult;
import seedu.homerce.model.Model;
import seedu.homerce.model.expense.Expense;

public class BreakdownExpenseCommand extends Command {

    public static final String COMMAND_WORD = "breakdownexp";
    public static final String MESSAGE_SUCCESS = "Expenses broken down: ";
    public static final String MESSAGE_USAGE = ": Displays the breakdown of expenses for the month specified "
            + "Parameters: "
            + PREFIX_MONTH_OF_YEAR + "MONTH "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_MONTH_OF_YEAR + "12";

    private final Month month;

    public BreakdownExpenseCommand(Month month) {
        this.month = month;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        Predicate<Expense> expensePredicate = new ExpenseMonthPredicate(month);
        List<Expense> filteredExpenseList = model.filterExpensesByMonth(expensePredicate);
        Map<String, Double> expenseMap = breakdownExpenses(filteredExpenseList);
        double totalExpenseAmount = 0;
        for (String tagName : expenseMap.keySet()) {
            totalExpenseAmount += expenseMap.get(tagName);
        }
        String expenseBreakdownString = "";
        for (String tagName : expenseMap.keySet()) {
            double tagPercentage = (expenseMap.get(tagName) / totalExpenseAmount) * 100;
            expenseBreakdownString += "[" + tagName + ": " + expenseMap.get(tagName) + ", "
                    + String.valueOf(tagPercentage) + "]";
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, expenseBreakdownString));
    }

    private Map<String, Double> breakdownExpenses(List<Expense> expenseList) {
        Map<String, Double> expenseMap = new HashMap<>();
        int listSize = expenseList.size();
        for (int i = 0; i < listSize; i++) {
            Expense expense = expenseList.get(i);
            String tagName = expense.getTag().tagName;
            Double amount = expense.getValue().value.doubleValue();
            if (expenseMap.containsKey(tagName)) {
                expenseMap.put(tagName, amount);
            } else {
                Double originalAmount = expenseMap.get(tagName);
                Double newAmount = originalAmount + amount;
                expenseMap.replace(tagName, originalAmount + newAmount);
            }
        }
        return expenseMap;

    }

}
