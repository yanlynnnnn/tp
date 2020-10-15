package seedu.homerce.model.appointment;

import static seedu.homerce.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.homerce.model.client.Client;
import seedu.homerce.model.service.Service;
import seedu.homerce.model.util.attributes.Date;
import seedu.homerce.model.util.uniquelist.UniqueListItem;

/**
 * Represents an Appointment in the homerce book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment implements UniqueListItem {

    private final Date appointmentDate;
    private final TimeOfDay timeOfDay;
    private final Client client;
    private final Service service;
    private final Status status;

    /**
     * Constructor for an Appointment.
     */
    public Appointment(Date appointmentDate, TimeOfDay timeOfDay, Client client, Service service) {
        requireAllNonNull(client, service, appointmentDate, timeOfDay);
        this.appointmentDate = appointmentDate;
        this.timeOfDay = timeOfDay;
        this.client = client;
        this.service = service;
        this.status = new Status("n");
    }


    public Client getClient() {
        return client;
    }

    public Service getService() {
        return service;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public TimeOfDay getAppointmentTime() {
        return timeOfDay;
    }

    public Status getStatus() {
        return status;
    }

    public void markDone() {
        status.markDone();
    }

    public void markUnDone() {
        status.markUnDone();
    }


    /**
     * Returns true if both appointments have the same identity and data fields.
     * This defines a stronger notion of equality between two clients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Client)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        return otherAppointment.getClient().equals(getClient())
                && otherAppointment.getService().equals(getService())
                && otherAppointment.getAppointmentDate().equals(getAppointmentDate())
                && otherAppointment.getAppointmentTime().equals(getAppointmentTime());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(client, service, appointmentDate, timeOfDay, status);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getAppointmentDate())
                .append(" ")
                .append(getAppointmentTime())
                .append(" Client: ")
                .append(getClient())
                .append(" Service ")
                .append(getService())
                .append(" Done? ")
                .append(getStatus());
        return builder.toString();
    }

    @Override
    public boolean isSame(UniqueListItem other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        return client.equals(otherAppointment.getClient())
                && service.equals(otherAppointment.getService())
                && appointmentDate.equals(otherAppointment.appointmentDate)
                && timeOfDay.equals(otherAppointment.timeOfDay);
    }
}
