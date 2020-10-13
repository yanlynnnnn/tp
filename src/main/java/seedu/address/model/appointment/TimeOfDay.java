package seedu.address.model.appointment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeOfDay {

    public static final String MESSAGE_CONSTRAINTS = "TimeOfDay entered must be in the format of <HHmm>,"
            + " where HH is the 24-hour clock timing, mm is the minutes of the hour.";

    private static final DateTimeFormatter FORMAT_INPUT = DateTimeFormatter.ofPattern("HHmm");
    private static final DateTimeFormatter FORMAT_OUTPUT = DateTimeFormatter.ofPattern("h:mm a");

    protected final LocalTime value;

    /**
     * Represents the date stored for any model object.
     * @param timeString The input time by the user.
     */
    public TimeOfDay(String timeString) {
        requireNonNull(timeString);
        checkArgument(isValidTime(timeString), MESSAGE_CONSTRAINTS);
        this.value = LocalTime.parse(timeString, FORMAT_INPUT);
    }

    /**
     * Returns true if a given string is a valid TimeOfDay format.
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
                || (other instanceof TimeOfDay // instanceof handles nulls
                && value.equals(((TimeOfDay) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value.format(FORMAT_INPUT);
    }

    public String toUiString() {
        return value.format(FORMAT_OUTPUT);
    }
}
