package seedu.address.model.service;

import java.util.Objects;

import seedu.address.model.client.Client;
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
     * @param serviceCode The unique identification code for the service object.
     */
    public Service(Title title, Duration duration, Price price, ServiceCode serviceCode) {
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.serviceCode = serviceCode;
    }

    public Title getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public Duration getDuration() {
        return duration;
    }

    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * Returns true if both services have the same identity and data fields.
     * This defines a stronger notion of equality between two services.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Client)) {
            return false;
        }

        Client otherClient = (Client) other;
        return otherClient.getName().equals(getTitle())
                && otherClient.getPhone().equals(getDuration())
                && otherClient.getEmail().equals(getServiceCode())
                && otherClient.getTags().equals(getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration, price, serviceCode);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Duration: ")
                .append(getDuration())
                .append(" Price: ")
                .append(getPrice())
                .append(" Service Code: ")
                .append(getServiceCode());
        return builder.toString();
    }
}
