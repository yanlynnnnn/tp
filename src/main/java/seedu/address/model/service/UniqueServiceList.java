package seedu.address.model.service;

import static java.util.Objects.requireNonNull;

import seedu.address.model.util.uniquelist.UniqueList;

public class UniqueServiceList extends UniqueList<Service> {

    /**
     * Returns true if the list contains an equivalent item as the given argument.
     */
    public boolean contains(ServiceCode toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(x -> x.getServiceCode().equals(toCheck));
    }

}
