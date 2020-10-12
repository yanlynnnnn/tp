package seedu.address.model.service;

import java.util.function.Predicate;

import seedu.address.model.util.attributes.Title;

public class ServiceTitlePredicate implements Predicate<Service> {
    private final Title title;

    public ServiceTitlePredicate(Title title) {
        this.title = title;
    }

    @Override
    public boolean test(Service service) {
        return title.equals(service.getTitle());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ServiceTitlePredicate // instanceof handles nulls
            && title.equals(((ServiceTitlePredicate) other).title)); // state check
    }
}
