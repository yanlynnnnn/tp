package seedu.address.model.appointment;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.client.Client;
import seedu.address.model.service.Service;
import seedu.address.model.util.attributes.Date;

/**
 * Represents an Appointment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment {
    private final Client client;
    private final Service service;
    private final Date appointmentDate;
    private final TimeOfDay timeOfDay;
    private Status status;

    /**
     * Constructor for an Appointment.
     */
    public Appointment(Client client, Service service, Date appointmentDate, TimeOfDay timeOfDay) {
        requireAllNonNull(client, service, appointmentDate, timeOfDay);
        this.client = client;
        this.service = service;
        this.appointmentDate = appointmentDate;
        this.timeOfDay = timeOfDay;
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

    /**
     * Returns true if both appointments of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two clients.
     */
    public boolean isSameAppointment(Appointment otherAppointment) {
        if (otherAppointment == this) {
            return true;
        }

        return otherAppointment != null
                && otherAppointment.getClient().equals(getClient())
                && otherAppointment.getService().equals(getService())
                && otherAppointment.getAppointmentDate().equals(getAppointmentDate())
                && otherAppointment.getAppointmentTime().equals(getAppointmentTime())
                && (otherAppointment.getStatus() == getStatus());
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
                && otherAppointment.getAppointmentTime().equals(getAppointmentTime())
                && (otherAppointment.getStatus() == getStatus());
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

}
