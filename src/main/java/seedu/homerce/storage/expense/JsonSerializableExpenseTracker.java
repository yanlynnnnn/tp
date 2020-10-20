package seedu.homerce.storage.expense;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.homerce.commons.exceptions.IllegalValueException;
import seedu.homerce.model.expense.Expense;
import seedu.homerce.model.expense.IsFixed;
import seedu.homerce.model.manager.ExpenseTracker;
import seedu.homerce.model.manager.ReadOnlyExpenseTracker;
import seedu.homerce.model.util.attributes.Amount;
import seedu.homerce.model.util.attributes.Date;
import seedu.homerce.model.util.attributes.Description;
import seedu.homerce.model.util.attributes.Tag;

/**
 * An Immutable expenseTracker that is serializable to JSON format.
 */
@JsonRootName(value = "expenseTracker")
public class JsonSerializableExpenseTracker {

    private final List<JsonAdaptedExpense> expenses = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableExpenseTracker } with the given expenses.
     */
    @JsonCreator
    public JsonSerializableExpenseTracker(@JsonProperty("expenses") List<JsonAdaptedExpense> expenses) {
        this.expenses.addAll(expenses);
    }

    /**
     * Converts a given {@code ReadOnlyExpenseTracker} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableExpenseTracker}.
     */
    public JsonSerializableExpenseTracker(ReadOnlyExpenseTracker source) {
        expenses.addAll(source.getExpenseList().stream().map(JsonAdaptedExpense::new).collect(Collectors.toList()));
    }

    /**
     * Converts this expenseTracker into the model's {@code ExpenseTracker} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ExpenseTracker toModelType() throws IllegalValueException {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        LocalDate date = LocalDate.now();
        for (JsonAdaptedExpense jsonAdaptedExpense : expenses) {
            Expense expense = jsonAdaptedExpense.toModelType();
            boolean isRecurringExpense = checkRecurringExpense(expense, date);
            if (isRecurringExpense) {
                Expense duplicateExpense = createDuplicateExpense(expense, date);
                expenseTracker.addExpense(duplicateExpense);
            }
            expenseTracker.addExpense(expense);
        }
        return expenseTracker;
    }

    /**
     * Checks if the given expense is recurring and if it should be duplicated for the month.
     * If expense is recurring, return true and mark the expense's willRecur as done.
     */
    private boolean checkRecurringExpense(Expense expense, LocalDate date) {
        boolean expenseIsRecurring = expense.getIsFixed().value && expense.getIsFixed().getIsRecurring();
        if (!expenseIsRecurring) {
            return false;
        }
        Month expenseMonth = expense.getDate().getMonth();
        int expenseDayOfMonth = expense.getDate().getDayOfMonth();
        if (expenseMonth.equals(date.getMonth())) {
            return false;
        }
        if (expenseDayOfMonth == date.getDayOfMonth()) {
            expense.getIsFixed().markAsRecurred();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates a duplicate expense of the original fixed recurring expense, changing date to reflect current date.
     */
    private Expense createDuplicateExpense(Expense expense, LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Description duplicateDescription = new Description(expense.getDescription().value);
        IsFixed duplicateIsFixed = new IsFixed("y");
        Amount duplicateValue = new Amount(expense.getValue().value.doubleValue());
        Date duplicateDate = new Date(date.format(formatter));
        Tag duplicateTag = new Tag(expense.getTag().tagName);

        return new Expense(duplicateDescription, duplicateIsFixed, duplicateValue, duplicateDate, duplicateTag);
    }
}

