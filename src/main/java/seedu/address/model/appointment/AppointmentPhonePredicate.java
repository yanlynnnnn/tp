package seedu.address.model.appointment;

import java.util.function.Predicate;

import seedu.address.model.client.Phone;

public class AppointmentPhonePredicate implements Predicate<Appointment> {
    private final Phone phoneOfAppointment;

    public AppointmentPhonePredicate(Phone phone) {
        this.phoneOfAppointment = phone;
    }

    @Override
    public boolean test(Appointment appointment) {
        return phoneOfAppointment.equals(appointment.getClient().getPhone());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof AppointmentPhonePredicate // instanceof handles nulls
            && phoneOfAppointment.equals(((AppointmentPhonePredicate) other).phoneOfAppointment)); // state check
    }
}