package seedu.homerce.model.manager;

import javafx.collections.ObservableList;
import seedu.homerce.model.revenue.Revenue;

/**
 * Unmodifiable view of a revenue list
 */
public interface ReadOnlyRevenueTracker {

    /**
     * Returns an unmodifiable view of the revenue list.
     */
    ObservableList<Revenue> getRevenueList();
}
