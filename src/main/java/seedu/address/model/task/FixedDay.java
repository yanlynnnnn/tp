package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.Days;

public class FixedDay {
    public static final String MESSAGE_CONSTRAINTS = "Day should be valid";

    public final Days day;

    /**
     * Constructs a {@code FixedDay}.
     *
     * @param day A valid day of the week.
     */
    public FixedDay(Days day) {
        requireNonNull(day);
        checkArgument(isValidDay(day), MESSAGE_CONSTRAINTS);
        this.day = day;
    }

    /**
     * Returns true if a given day is valid.
     */
    public static boolean isValidDay(Days day) {
        return (day instanceof Days);
    }

    @Override
    public String toString() {
        return day.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Days // instanceof handles nulls
                && day.equals(other)); // state check
    }

}
