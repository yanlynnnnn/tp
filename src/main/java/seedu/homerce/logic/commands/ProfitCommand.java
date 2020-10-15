package seedu.homerce.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.homerce.logic.parser.CliSyntax.PREFIX_MONTH_OF_YEAR;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.function.Predicate;

import seedu.homerce.logic.commands.exceptions.CommandException;
import seedu.homerce.model.Model;
import seedu.homerce.model.expense.Expense;
import seedu.homerce.model.expense.predicate.ExpenseMonthPredicate;
import seedu.homerce.model.revenue.Revenue;
import seedu.homerce.model.revenue.predicate.RevenueMonthPredicate;

public class ProfitCommand extends Command {

    public static final String COMMAND_WORD = "profit";

    public static final String MESSAGE_SUCCESS = "The profit for this month is %1$s";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays the profit for the month specified "
            + "Parameters: "
            + PREFIX_MONTH_OF_YEAR + "MONTH "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_MONTH_OF_YEAR + "12";

    private final Month month;

    public ProfitCommand(Month month) {
        this.month = month;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Predicate<Expense> expensePredicate = new ExpenseMonthPredicate(month);
        Predicate<Revenue> revenuePredicate = new RevenueMonthPredicate(month);
        List<Revenue> filteredRevenue = model.filterRevenueByMonth(revenuePredicate);
        List<Expense> filteredExpense = model.filterExpensesByMonth(expensePredicate);

        String profit = getProfit(filteredExpense, filteredRevenue);
        return new CommandResult(String.format(MESSAGE_SUCCESS, profit));
    }

    private String getProfit(List<Expense> expenses, List<Revenue> revenues) {
        BigDecimal totalExpense = expenses.stream()
                .map(x -> x.getValue().value).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        BigDecimal totalRevenue = revenues.stream()
                .map(x -> x.getValue().value).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        BigDecimal profit = totalRevenue.subtract(totalExpense);

        return profit.toString();
    }
}
