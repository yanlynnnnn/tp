package seedu.homerce.model.expense;

import java.time.Month;
import java.util.function.Predicate;

/**
 * Tests that a {@code Expense}'s {@code Date} matches the given date.
 */
public class ExpenseMonthPredicate implements Predicate<Expense> {
    private final Month month;

    public ExpenseMonthPredicate(Month month) {
        this.month = month;
    }

    @Override
    public boolean test(Expense expense) {
        Month expenseMonth = expense.getDate().getMonth();
        return month.equals(expenseMonth);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseMonthPredicate // instanceof handles nulls
                && month.equals(((ExpenseMonthPredicate) other).month)); // state check
    }
}
