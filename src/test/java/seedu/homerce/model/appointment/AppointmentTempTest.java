package seedu.homerce.model.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.homerce.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.homerce.model.client.Phone;
import seedu.homerce.model.service.ServiceCode;
import seedu.homerce.model.util.attributes.Date;

public class AppointmentTempTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
            new AppointmentTemp(null, null, null, null)
        );
    }

    @Test
    public void getterMethods_returnsNonNull_attributes() {
        Date date = new Date("25-10-2020");
        TimeOfDay timeOfDay = new TimeOfDay("1300");
        Phone phone = new Phone("98887777");
        ServiceCode serviceCode = new ServiceCode("SC001");
        AppointmentTemp appointmentTemp = new AppointmentTemp(
            date, timeOfDay, phone, serviceCode
        );
        assertEquals(appointmentTemp.getAppointmentDate(), date);
        assertEquals(appointmentTemp.getAppointmentStartTime(), timeOfDay);
        assertEquals(appointmentTemp.getPhone(), phone);
        assertEquals(appointmentTemp.getServiceCode(), serviceCode);
    }
}
