package seedu.homerce.model.revenue.predicate;

import java.time.Month;
import java.util.function.Predicate;

import seedu.homerce.model.revenue.Revenue;

/**
 * Tests that a {@code Expense}'s {@code Date} matches the given date.
 */
public class RevenueMonthPredicate implements Predicate<Revenue> {
    private final Month month;

    public RevenueMonthPredicate(Month month) {
        this.month = month;
    }

    @Override
    public boolean test(Revenue revenue) {
        Month revenueMonth = revenue.getDate().getMonth();
        return month.equals(revenueMonth);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Revenue // instanceof handles nulls
                && month.equals(((RevenueMonthPredicate) other).month)); // state check
    }
}
