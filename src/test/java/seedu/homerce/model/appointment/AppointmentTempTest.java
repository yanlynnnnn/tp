package seedu.homerce.model.appointment;

import static seedu.homerce.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AppointmentTempTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
            new AppointmentTemp(null, null, null, null)
        );
    }
}
