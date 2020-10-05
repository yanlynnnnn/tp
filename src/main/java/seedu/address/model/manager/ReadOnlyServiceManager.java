package seedu.address.model.manager;

import javafx.collections.ObservableList;
import seedu.address.model.service.Service;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyServiceManager {
    /**
     * Returns an unmodifiable view of the services list.
     * This list will not contain any duplicate services.
     */
    ObservableList<Service> getServiceList();
}
