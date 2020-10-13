package seedu.address.storage.appointment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.TimeOfDay;
import seedu.address.model.client.Client;
import seedu.address.model.client.Name;
import seedu.address.model.service.Service;
import seedu.address.model.util.attributes.Date;
import seedu.address.storage.client.JsonAdaptedClient;
import seedu.address.storage.service.JsonAdaptedService;

public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final String date;
    private final String timeOfDay;
    private final boolean status;
    private final JsonAdaptedClient client;
    private final JsonAdaptedService service;

    /**
     * Constructs a {@code JsonAdaptedClient} with the given Appointment details.
     */
    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("date") String date,
                                  @JsonProperty("timeOfDay") String timeOfDay,
                                  @JsonProperty("status") boolean status,
                                  @JsonProperty("client") JsonAdaptedClient client,
                                  @JsonProperty("service") JsonAdaptedService service) {
        this.date = date;
        this.timeOfDay = timeOfDay;
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
            throw new IllegalValueException(TimeOfDay.MESSAGE_CONSTRAINTS);
        }
        final TimeOfDay modelTimeOfDay = new TimeOfDay(timeOfDay);
        final Client modelClient = client.toModelType();
        final Service modelService = service.toModelType();
        Appointment result = new Appointment(modelDate, modelTimeOfDay, modelClient, modelService);
        if (status) {
            result.markDone();
        }
        return result;
    }
}
