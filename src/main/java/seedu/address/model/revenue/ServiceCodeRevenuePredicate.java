package seedu.address.model.revenue;

import java.util.function.Predicate;

import seedu.address.model.service.ServiceCode;

public class ServiceCodeRevenuePredicate implements Predicate<Revenue> {

    private final ServiceCode serviceCode;

    public ServiceCodeRevenuePredicate(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public boolean test(Revenue revenue) {
        return serviceCode.equals(revenue.getService().getServiceCode());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ServiceCodeRevenuePredicate // instanceof handles nulls
            && serviceCode.equals(((ServiceCodeRevenuePredicate) other).serviceCode)); // state check
    }
}
