package seedu.address.storage.expense;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.IsFixed;
import seedu.address.model.util.attributes.Description;
import seedu.address.model.util.attributes.Price;
import seedu.address.model.util.attributes.Date;
import seedu.address.model.util.attributes.Tag;

/**
 * Jackson-friendly version of {@link Expense}.
 */
public class JsonAdaptedExpense {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Expense's %s field is missing!";

    private final Amount value;
    private final Date date;
    private final Description description;
    private final IsFixed isFixed;
    private final Tag tag;

    /**
     * Constructs a {@code JsonAdaptedService} with the given Service details.
     */
    @JsonCreator
    public JsonAdaptedService(@JsonProperty("value") Amount value, @JsonProperty("date") Date date,
                              @JsonProperty("duration") Double duration,
                              @JsonProperty("serviceCode") String serviceCode) {
        this.title = title;
        this.price = new BigDecimal(price);
        this.duration = duration;
        this.serviceCode = serviceCode;
    }

    /**
     * Converts a given {@code Service} into this class for Jackson use.
     */
    public JsonAdaptedService(Service source) {
        title = source.getTitle().value;
        price = source.getPrice().value;
        duration = source.getDuration().value;
        serviceCode = source.getServiceCode().value;

    }

    /**
     * Converts this Jackson-friendly adapted service object into the model's {@code Service} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted service.
     */
    public Service toModelType() throws IllegalValueException {
        if (title == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName()));
        }
        if (!Title.isValidTitle(title)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Title modelTitle = new Title(title);

        if (duration == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Duration.class.getSimpleName()));
        }
        if (!Duration.isValidDuration(duration)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Duration modelDuration = new Duration(duration);

        if (price == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Price.class.getSimpleName()));
        }
        if (!Price.isValidPrice(price.doubleValue())) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Price modelPrice = new Price(price.doubleValue());

        if (serviceCode == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ServiceCode.class.getSimpleName()));
        }
        if (!ServiceCode.isValidServiceCode(serviceCode)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }

        Service service = new Service(modelTitle, modelDuration, modelPrice);
        service.addSerivceCode(serviceCode);

        return service;
    }
}
