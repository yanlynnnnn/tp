package seedu.address.model.appointment;

import java.util.function.Predicate;

import seedu.address.model.util.attributes.Date;

public class DateAppointmentPredicate implements Predicate<Appointment> {

    private final Date dateOfAppointment;

    public DateAppointmentPredicate(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    @Override
    public boolean test(Appointment appointment) {
        return dateOfAppointment.equals(appointment.getAppointmentDate());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof DateAppointmentPredicate // instanceof handles nulls
            && dateOfAppointment.equals(((DateAppointmentPredicate) other).dateOfAppointment)); // state check
    }
}
