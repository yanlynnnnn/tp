package seedu.address.storage.appointment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.TimeOfDay;
import seedu.address.model.client.Client;
import seedu.address.model.client.Email;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.service.Service;
import seedu.address.model.service.ServiceCode;
import seedu.address.model.util.attributes.Date;
import seedu.address.storage.JsonAdaptedClient;
import seedu.address.storage.service.JsonAdaptedService;

public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final String date;
    private final String timeOfDay;
    private final String phone;
    private final String serviceCode;
    private final boolean status;
    private final JsonAdaptedClient client;
    private final JsonAdaptedService service;

    /**
     * Constructs a {@code JsonAdaptedClient} with the given Appointment details.
     */
    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("date") String date,
                                  @JsonProperty("timeOfDay") String timeOfDay,
                                  @JsonProperty("phone") String phone,
                                  @JsonProperty("serviceCode") String serviceCode,
                                  @JsonProperty("status") boolean status,
                                  @JsonProperty("client") JsonAdaptedClient client,
                                  @JsonProperty("service") JsonAdaptedService service) {
        this.date = date;
        this.phone = phone;
        this.timeOfDay = timeOfDay;
        this.serviceCode = serviceCode;
        this.status = status;
        this.client = client;
        this.service = service;
    }

    /**
     * Converts a given {@code Appointment} into this class for Jackson use.
     */
    public JsonAdaptedAppointment(Appointment source) {
        date = source.getAppointmentDate().toString();
        timeOfDay = source.getAppointmentTime().toString();
        phone = source.getPhone().value;
        serviceCode = source.getServiceCode().value;
        status = source.getStatus().isDone();
        client = new JsonAdaptedClient(source.getClient());
        service = new JsonAdaptedService((source.getService()));
    }

    /**
     * Converts this Jackson-friendly adapted appointment object into the model's {@code Appointment} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted appointment.
     */
    public Appointment toModelType() throws IllegalValueException {

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        if (!Date.isValidDate(date)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }

        final Date modelDate = new Date(date);
        if (timeOfDay == null) {
            throw new IllegalValueException(String
                    .format(MISSING_FIELD_MESSAGE_FORMAT, TimeOfDay.class.getSimpleName()));
        }
        if (!TimeOfDay.isValidTime(timeOfDay)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final TimeOfDay modelTimeOfDay = new TimeOfDay(timeOfDay);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (serviceCode == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, ServiceCode.class.getSimpleName()));
        }
        if (!ServiceCode.isValidServiceCode(serviceCode)) {
            throw new IllegalValueException(ServiceCode.MESSAGE_CONSTRAINTS);
        }
        final ServiceCode modelServiceCode = new ServiceCode(serviceCode);
        final Client modelClient = client.toModelType();
        final Service modelService = service.toModelType();
        Appointment result = new Appointment(modelDate, modelTimeOfDay, modelPhone, modelServiceCode);
        if (status) {
            result.markDone();
        }
        result.setClient(modelClient);
        result.setService(modelService);
        return result;
    }
}
