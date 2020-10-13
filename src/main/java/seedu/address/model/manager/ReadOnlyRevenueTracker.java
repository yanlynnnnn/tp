package seedu.address.model.manager;

import javafx.collections.ObservableList;
import seedu.address.model.revenue.Revenue;

/**
 * Unmodifiable view of a revenue list
 */
public interface ReadOnlyRevenueTracker {

    /**
     * Returns an unmodifiable view of the revenue list.
     */
    ObservableList<Revenue> getRevenueList();
}
