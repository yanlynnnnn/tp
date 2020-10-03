package seedu.address.model.appointment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Time {

    public static final String MESSAGE_CONSTRAINTS = "Time entered must be in the format of <HH:mm>,"
            + " where HH is the 24-hour clock timing.";

    // TODO Need to test if these formatters are correct.
    private static final DateTimeFormatter FORMAT_INPUT = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter FORMAT_OUTPUT = DateTimeFormatter.ofPattern("hh:mm a");

    protected final LocalTime time;

    /**
     * Represents the date stored for any model object.
     * @param timeString The input time by the user.
     */
    public Time(String timeString) {
        requireNonNull(timeString);
        checkArgument(isValidTime(timeString), MESSAGE_CONSTRAINTS);
        this.time = LocalTime.parse(timeString, FORMAT_INPUT);
    }

    /**
     * Returns true if a given string is a valid Date format.
     */
    public static boolean isValidTime(String test) {
        try {
            LocalTime.parse(test, FORMAT_INPUT);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Time // instanceof handles nulls
                && time.equals(((Time) other).time)); // state check
    }

    @Override
    public int hashCode() {
        return time.hashCode();
    }

    @Override
    public String toString() {
        return time.format(FORMAT_OUTPUT);
    }
}
