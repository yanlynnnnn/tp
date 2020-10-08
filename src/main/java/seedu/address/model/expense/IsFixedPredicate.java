package seedu.address.model.expense;

import java.util.function.Predicate;

/**
 * Tests that a {@code Expense}'s {@code IsFixed} matches the given isFixed.
 */
public class IsFixedPredicate implements Predicate<Expense> {
    private final IsFixed isFixed;

    public IsFixedPredicate(IsFixed isFixed) {
        this.isFixed = isFixed;
    }

    @Override
    public boolean test(Expense expense) {
        return isFixed.equals(expense.getIsFixed());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof IsFixedPredicate // instanceof handles nulls
                && isFixed.equals(((IsFixedPredicate) other).isFixed)); // state check
    }
}
