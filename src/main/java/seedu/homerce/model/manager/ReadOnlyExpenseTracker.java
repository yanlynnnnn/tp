package seedu.homerce.model.manager;

import javafx.collections.ObservableList;
import seedu.homerce.model.expense.Expense;

public interface ReadOnlyExpenseTracker {
    /**
     * Returns an unmodifiable view of the expenses list.
     */
    ObservableList<Expense> getExpenseList();
}
