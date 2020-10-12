package seedu.address.model.service;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Service}'s {@code Title} or {@code ServiceCode} matches any of the keywords given.
 */
public class ServiceContainKeywordPredicate implements Predicate<Service> {
    private final List<String> keywords;

    public ServiceContainKeywordPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Service service) {
        return keywords.stream()
            .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(service.getTitle().value, keyword)
                ||
                StringUtil.containsWordIgnoreCase(service.getServiceCode().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ServiceContainKeywordPredicate// instanceof handles nulls
            && keywords.equals(((ServiceContainKeywordPredicate) other).keywords)); // state check
    }
}
