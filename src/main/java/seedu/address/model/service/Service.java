package seedu.address.model.service;

import seedu.address.model.util.attributes.Amount;
import seedu.address.model.util.attributes.Description;
import seedu.address.model.util.attributes.Price;
import seedu.address.model.util.attributes.Title;

public class Service {
    /** The name of the service */
    private Title title;

    /** Amount of money in dollars that this Service brings in */
    private Price price;

    /** Unique identification number for each Service */
    private final ServiceCode serviceCode;

    /** How long the service takes */
    private Duration duration;

    /**
     * Constructor for Service.
     * @param title The title of the service.
     * @param duration The duration of the service.
     * @param price The price of the service.
     */
    public Service(Title title, Duration duration, Price price) {
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.serviceCode = ServiceCode.generateServiceCode();
    }
}
