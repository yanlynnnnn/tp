package seedu.homerce.storage.expense;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.homerce.commons.exceptions.IllegalValueException;
import seedu.homerce.model.expense.Expense;
import seedu.homerce.model.manager.ExpenseTracker;
import seedu.homerce.model.manager.ReadOnlyExpenseTracker;

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
        for (JsonAdaptedExpense jsonAdaptedExpense : expenses) {
            Expense expense = jsonAdaptedExpense.toModelType();
            expenseTracker.addExpense(expense);
        }
        return expenseTracker;
    }
}
