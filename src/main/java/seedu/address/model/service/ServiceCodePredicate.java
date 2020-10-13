package seedu.address.model.service;

import java.util.function.Predicate;

/**
 * Tests that a {@code Service}'s {@code ServiceCode} matches the given service code.
 */
public class ServiceCodePredicate implements Predicate<Service> {
    private final ServiceCode serviceCode;

    public ServiceCodePredicate(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public boolean test(Service service) {
        return serviceCode.equals(service.getServiceCode());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ServiceCodePredicate // instanceof handles nulls
            && serviceCode.equals(((ServiceCodePredicate) other).serviceCode)); // state check
    }
}
