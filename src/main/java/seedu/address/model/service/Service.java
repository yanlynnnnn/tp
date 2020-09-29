package seedu.address.model.service;

import seedu.address.model.util.attributes.Amount;
import seedu.address.model.util.attributes.Description;

public class Service {
    /** What type of Service it is */
    private Description description;

    /** Amount of money in dollars that this Service brings in */
    private Amount price;

    /** Unique identification number for each Service */
    private ServiceCode serviceCode;

    /** How long the service takes */
    private Duration duration;

    Service(Description description, Amount price, Duration duration) {
        this.description = description;
        this.price = price;
        this.duration = duration;
    }
}
