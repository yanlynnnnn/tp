package seedu.homerce.model.appointment;

import static seedu.homerce.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AppointmentTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
            new Appointment(null, null, null, null)
        );
    }
}
