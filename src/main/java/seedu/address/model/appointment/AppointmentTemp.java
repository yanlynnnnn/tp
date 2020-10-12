package seedu.address.model.appointment;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.client.Phone;
import seedu.address.model.service.ServiceCode;
import seedu.address.model.util.attributes.Date;

/**
 * Temporary Appointment Object that contains the user-input phone number and Service Code.
 * Appointment object will be created using this object when appointment commands are executed.
 */
public class AppointmentTemp {
    private final Date appointmentDate;
    private final TimeOfDay timeOfDay;
    private final ServiceCode serviceCode;
    private final Phone phone;
    private final Status status;

    /**
     * Constructor for an Temporary Appointment object to be parsed in Appointment parsers.
     */
    public AppointmentTemp(Date appointmentDate, TimeOfDay timeOfDay, Phone phone, ServiceCode serviceCode) {
        requireAllNonNull(phone, serviceCode, appointmentDate, timeOfDay);
        this.appointmentDate = appointmentDate;
        this.timeOfDay = timeOfDay;
        this.phone = phone;
        this.serviceCode = serviceCode;
        this.status = new Status("n");
    }

    public Phone getPhone() {
        return phone;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public TimeOfDay getAppointmentTime() {
        return timeOfDay;
    }
}
