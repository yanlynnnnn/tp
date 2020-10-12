package seedu.address.model.appointment;

import java.util.function.Predicate;

import seedu.address.model.service.ServiceCode;

public class ServiceCodeAppointmentPredicate implements Predicate<Appointment> {
    private final ServiceCode serviceCodeOfAppointment;

    public ServiceCodeAppointmentPredicate(ServiceCode serviceCodeOfAppointment) {
        this.serviceCodeOfAppointment = serviceCodeOfAppointment;
    }

    @Override
    public boolean test(Appointment appointment) {
        return serviceCodeOfAppointment.equals(appointment.getService().getServiceCode());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ServiceCodeAppointmentPredicate // instanceof handles nulls
            && serviceCodeOfAppointment.equals(((ServiceCodeAppointmentPredicate) other)
            .serviceCodeOfAppointment)); // state check
    }
}
