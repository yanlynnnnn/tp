package seedu.address.model.appointment;

import java.util.function.Predicate;

import seedu.address.model.util.attributes.Date;

public class AppointmentDatePredicate implements Predicate<Appointment> {

    private final Date dateOfAppointment;

    public AppointmentDatePredicate(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    @Override
    public boolean test(Appointment appointment) {
        return dateOfAppointment.equals(appointment.getAppointmentDate());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof AppointmentDatePredicate // instanceof handles nulls
            && dateOfAppointment.equals(((AppointmentDatePredicate) other).dateOfAppointment)); // state check
    }
}
