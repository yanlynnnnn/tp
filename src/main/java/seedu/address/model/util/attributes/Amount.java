package seedu.address.model.util.attributes;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.AppUtil;

public class Amount {
    public static final String MESSAGE_CONSTRAINTS = "Amount must be a valid number less than 1000 with "
            + "2 decimal places";

    // Allows value less than 1000, and at most 2 decimal places.
    public static final String VALIDATION_REGEX = "^([\\d]{1,3})(\\.[\\d]{2})?$";
    public final String value;

    /**
     * Represents the monetary amount for any model object.
     * @param amount
     */
    public Amount(String amount) {
        requireNonNull(amount);
        AppUtil.checkArgument(isValidAmount(amount), MESSAGE_CONSTRAINTS);
        value = String.format("%.2f", Double.parseDouble(amount));
    }

    /**
     * Returns true if a given string is a valid amount.
     */
    public static boolean isValidAmount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%.2f", Double.parseDouble(value));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Amount // instanceof handles nulls
                && value.equals(((Amount) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
