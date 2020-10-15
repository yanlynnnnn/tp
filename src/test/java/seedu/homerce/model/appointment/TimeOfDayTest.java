package seedu.homerce.model.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.homerce.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TimeOfDayTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TimeOfDay(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidTime = "";
        assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(invalidTime));
    }

    @Test
    public void isValidTime() {
        // null date
        assertThrows(NullPointerException.class, () -> TimeOfDay.isValidTime(null));

        // invalid times of the day
        assertFalse(TimeOfDay.isValidTime("")); // empty string
        assertFalse(TimeOfDay.isValidTime(" ")); // spaces only
        assertFalse(TimeOfDay.isValidTime("2515")); // invalid hour
        assertFalse(TimeOfDay.isValidTime("1270")); // invalid minutes
        assertFalse(TimeOfDay.isValidTime("13")); // input must have 4 digits
        assertFalse(TimeOfDay.isValidTime("915")); // input must have 4 digits
        assertFalse(TimeOfDay.isValidTime("12:34")); // invalid format

        // valid times of the day
        assertTrue(TimeOfDay.isValidTime("0000"));
        assertTrue(TimeOfDay.isValidTime("0910"));
        assertTrue(TimeOfDay.isValidTime("1200"));
        assertTrue(TimeOfDay.isValidTime("2359"));
    }

    @Test
    public void toStringTest() {
        TimeOfDay time1 = new TimeOfDay("1745");
        TimeOfDay time2 = new TimeOfDay("1030");
        assertEquals("1745", time1.toString());
        assertEquals("1030", time2.toString());
    }
}
