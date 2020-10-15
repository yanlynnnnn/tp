package seedu.homerce.model.revenue.predicate;

import java.time.Year;
import java.util.function.Predicate;
import seedu.homerce.model.revenue.Revenue;

/**
 * Tests that a {@code Expense}'s {@code Date} matches the given date.
 */
public class RevenueYearPredicate implements Predicate<Revenue> {
    private final Year year;

    public RevenueYearPredicate(Year year) {
        this.year = year;
    }

    @Override
    public boolean test(Revenue revenue) {
        int revenueYear = revenue.getDate().getYear();
        return year.getValue() == revenueYear;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Revenue // instanceof handles nulls
                && year.equals(((RevenueYearPredicate) other).year)); // state check
    }
}
