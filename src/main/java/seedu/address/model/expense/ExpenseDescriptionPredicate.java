package seedu.address.model.expense;

import java.util.function.Predicate;

import seedu.address.model.util.attributes.Description;

/**
 * Tests that a {@code Expense}'s {@code Description} matches the given description.
 */
public class ExpenseDescriptionPredicate implements Predicate<Expense> {
    private final Description description;

    public ExpenseDescriptionPredicate(Description description) {
        this.description = description;
    }

    @Override
    public boolean test(Expense expense) {
        return description.equals(expense.getDescription());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ExpenseDescriptionPredicate // instanceof handles nulls
                && description.equals(((ExpenseDescriptionPredicate) other).description)); // state check
    }
}
