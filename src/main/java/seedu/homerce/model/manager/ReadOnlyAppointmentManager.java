package seedu.homerce.model.manager;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.homerce.model.appointment.Appointment;

/**
 * Unmodifiable view of am appointment book
 */
public interface ReadOnlyAppointmentManager {
    /**
     * Returns a view of the appointment list.
     * This list will not contain any duplicate appointments.
     */
    ObservableList<Appointment> getAppointmentList();

    /**
     * Returns a view of the appointment list containing
     * appointments only from a particular week. The week is determined
     * by the date stored in the appointment manager.
     */
    ObservableList<Appointment> getAppointmentListCopy();
}
