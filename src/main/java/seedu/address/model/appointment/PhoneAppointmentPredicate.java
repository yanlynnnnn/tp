package seedu.address.model.appointment;

import java.util.function.Predicate;

import seedu.address.model.client.Phone;

public class PhoneAppointmentPredicate implements Predicate<Appointment> {
    private final Phone phoneOfAppointment;

    public PhoneAppointmentPredicate(Phone phone) {
        this.phoneOfAppointment = phone;
    }

    @Override
    public boolean test(Appointment appointment) {
        return phoneOfAppointment.equals(appointment.getClient().getPhone());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof PhoneAppointmentPredicate // instanceof handles nulls
            && phoneOfAppointment.equals(((PhoneAppointmentPredicate) other).phoneOfAppointment)); // state check
    }
}
