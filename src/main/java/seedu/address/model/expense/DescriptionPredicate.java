package seedu.address.model.expense;

import java.util.function.Predicate;

import seedu.address.model.util.attributes.Description;

/**
 * Tests that a {@code Expense}'s {@code Description} matches the given description.
 */
public class DescriptionPredicate implements Predicate<Expense> {
    private final Description description;

    public DescriptionPredicate(Description description) {
        this.description = description;
    }

    @Override
    public boolean test(Expense expense) {
        return description.equals(expense.getDescription());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DescriptionPredicate // instanceof handles nulls
                && description.equals(((DescriptionPredicate) other).description)); // state check
    }
}
