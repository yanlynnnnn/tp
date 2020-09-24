package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's Duration in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDuration(double)}
 */
public class Duration {

    public static final String MESSAGE_CONSTRAINTS = "Duration "
            + "should be in hours and should not exceed 24 hours";
    public static final double MAX_DURATION = 24;
    public final double value;

    /**
     * Constructs a {@code Duration}.
     *
     * @param duration A valid duration.
     */
    public Duration(double duration) {
        requireNonNull(duration);
        checkArgument(isValidDuration(duration), MESSAGE_CONSTRAINTS);
        value = duration;
    }

    /**
     * Returns true if a given double is a valid duration.
     * @param test Duration to be checked for validity.
     */
    public static boolean isValidDuration(double test) {
        return (test <= MAX_DURATION);
    }

    @Override
    public String toString() {
        return String.valueOf(value) + ((value == 1) ? " hours" : " hours");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Duration // instanceof handles nulls
                && (value == ((Duration) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return Double.valueOf(value).hashCode();
    }
}
