package seedu.address.model.service;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import seedu.address.model.client.Client;
import seedu.address.model.service.exceptions.ServiceNotFoundException;
import seedu.address.model.util.uniquelist.UniqueList;

public class UniqueServiceList extends UniqueList<Service> {

    /**
     * Returns true if the list contains an equivalent item as the given argument.
     */
    public boolean contains(ServiceCode toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(x -> x.getServiceCode().equals(toCheck));
    }

    /**
     * Find the service based on service code. If service code does not match a service, exception is thrown.
     */
    public Service getServiceByServiceCode(ServiceCode serviceCode) {
        requireAllNonNull(serviceCode);
        for (Service service : internalList) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service;
            }
        }
        throw new ServiceNotFoundException();
    }

    public List<Service> deepCopy() {
        Iterator<Service> iterator = this.iterator();
        List<Service> servicesCopy = new ArrayList<>();
        while (iterator.hasNext()) {
            servicesCopy.add(iterator.next());
        }
        return servicesCopy;
    }
}
