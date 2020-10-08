package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TimeTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Time(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new Time(invalidTime));
    }

    @Test
    public void isValidTime() {
        // null date
        assertThrows(NullPointerException.class, () -> Time.isValidTime(null));

        // invalid times of the day
        assertFalse(Time.isValidTime("")); // empty string
        assertFalse(Time.isValidTime(" ")); // spaces only
        assertFalse(Time.isValidTime("2515")); // invalid hour
        assertFalse(Time.isValidTime("1270")); // invalid minutes
        assertFalse(Time.isValidTime("13")); // input must have 4 digits
        assertFalse(Time.isValidTime("915")); // input must have 4 digits
        assertFalse(Time.isValidTime("12:34")); // invalid format

        // valid times of the day
        assertTrue(Time.isValidTime("0000"));
        assertTrue(Time.isValidTime("0910"));
        assertTrue(Time.isValidTime("1200"));
        assertTrue(Time.isValidTime("2359"));
    }

    @Test
    public void toStringTest() {
        Time time1 = new Time("1745");
        Time time2 = new Time("1030");
        assertEquals("5:45 PM", time1.toString());
        assertEquals("10:30 AM", time2.toString());
    }
}
