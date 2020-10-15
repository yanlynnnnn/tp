package seedu.homerce.model.expense;

import java.time.Year;
import java.util.function.Predicate;

/**
 * Tests that a {@code Expense}'s {@code Date} matches the given date.
 */
public class ExpenseYearPredicate implements Predicate<Expense> {
    private final Year year;

    public ExpenseYearPredicate(Year year) {
        this.year = year;
    }

    @Override
    public boolean test(Expense revenue) {
        int revenueYear = revenue.getDate().getYear();
        return year.getValue() == revenueYear;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Expense // instanceof handles nulls
                && year.equals(((ExpenseYearPredicate) other).year)); // state check
    }
}
