package seedu.homerce.model.appointment.predicate;

import java.util.function.Predicate;

import seedu.homerce.model.appointment.Appointment;
import seedu.homerce.model.client.Name;

public class AppointmentNamePredicate implements Predicate<Appointment> {
    private final Name clientName;

    public AppointmentNamePredicate(Name clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean test(Appointment appointment) {
        // As long as part of the client's name matches, it is a match.
        return appointment.getClient().getName().fullName.toLowerCase()
            .contains(clientName.fullName.toLowerCase());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof AppointmentNamePredicate// instanceof handles nulls
            && clientName.equals(((AppointmentNamePredicate) other).clientName)); // state check
    }
}
