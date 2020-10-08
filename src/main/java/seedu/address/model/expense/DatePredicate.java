package seedu.address.model.expense;

import java.util.function.Predicate;

import seedu.address.model.util.attributes.Date;

/**
 * Tests that a {@code Expense}'s {@code Date} matches the given date.
 */
public class DatePredicate implements Predicate<Expense> {
    private final Date date;

    public DatePredicate(Date date) {
        this.date = date;
    }

    @Override
    public boolean test(Expense expense) {
        return date.equals(expense.getDate());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DatePredicate // instanceof handles nulls
                && date.equals(((DatePredicate) other).date)); // state check
    }
}
