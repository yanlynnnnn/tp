package seedu.address.storage.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.client.Client;
import seedu.address.model.client.Email;
import seedu.address.model.client.Name;
import seedu.address.model.client.Phone;
import seedu.address.model.service.Service;
import seedu.address.model.util.attributes.Tag;

/**
 * Jackson-friendly version of {@link Service}.
 */
public class JsonAdaptedService {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Service's %s field is missing!";

    private final String title;
    private final Double price;
    private final Double duration;

    /**
     * Constructs a {@code JsonAdaptedService} with the given Service details.
     */
    @JsonCreator
    public JsonAdaptedService(@JsonProperty("title") String title, @JsonProperty("price") Double price,
                             @JsonProperty("duration") Double duration) {
        this.title = title;
        this.price = price;
        this.duration = duration;
    }

    /**
     * Converts a given {@code Service} into this class for Jackson use.
     */
    public JsonAdaptedService(Service source) {
        title = source.getTitle().value;
        price = source.getPrice().value;
        duration = source.getDuration().value;

    }

    /**
     * Converts this Jackson-friendly adapted client object into the model's {@code Client} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted client.
     */
    public Client toModelType() throws IllegalValueException {
        final List<Tag> clientTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            clientTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        final Set<Tag> modelTags = new HashSet<>(clientTags);
        return new Client(modelName, modelPhone, modelEmail, modelTags);
    }
}
