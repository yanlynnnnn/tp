package seedu.address.model.manager;

import javafx.collections.ObservableList;
import seedu.address.model.appointment.Appointment;

/**
 * Unmodifiable view of am appointment book
 */
public interface ReadOnlyAppointmentManager {
    /**
     * Returns an unmodifiable view of the appointment list.
     * This list will not contain any duplicate appointments.
     */
    ObservableList<Appointment> getAppointmentList();

}
