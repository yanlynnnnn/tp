package seedu.address.model.appointment;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Optional;

import seedu.address.model.client.Client;
import seedu.address.model.client.Phone;
import seedu.address.model.service.Service;
import seedu.address.model.service.ServiceCode;
import seedu.address.model.util.attributes.Date;
import seedu.address.model.util.uniquelist.UniqueListItem;

/**
 * Represents an Appointment in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment implements UniqueListItem {

    private final Date appointmentDate;
    private final TimeOfDay timeOfDay;
    private final ServiceCode serviceCode;
    private final Phone phone;

    private Optional<Client> client;
    private Optional<Service> service;
    private Status status;

    /**
     * Constructor for an Appointment.
     */
    public Appointment(Date appointmentDate, TimeOfDay timeOfDay, Phone phone, ServiceCode serviceCode) {
        requireAllNonNull(client, service, appointmentDate, timeOfDay);
        this.appointmentDate = appointmentDate;
        this.timeOfDay = timeOfDay;
        this.phone = phone;
        this.serviceCode = serviceCode;
        this.client = Optional.empty();
        this.service = Optional.empty();
        this.status = new Status("n");
    }

    public Phone getPhone() {
        return phone;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    public Client getClient() {
        return client.get();
    }

    public Service getService() {
        return service.get();
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
        return otherAppointment.getPhone().equals(getPhone())
                && otherAppointment.getServiceCode().equals(getServiceCode())
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
        return phone.equals(otherAppointment.phone)
                && serviceCode.equals(otherAppointment.serviceCode)
                && appointmentDate.equals(otherAppointment.appointmentDate)
                && timeOfDay.equals(otherAppointment.timeOfDay);
    }
}
