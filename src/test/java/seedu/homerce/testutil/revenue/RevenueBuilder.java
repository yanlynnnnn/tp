package seedu.homerce.testutil.revenue;

import seedu.homerce.model.revenue.Revenue;
import seedu.homerce.model.service.Duration;
import seedu.homerce.model.service.Service;
import seedu.homerce.model.util.attributes.Amount;
import seedu.homerce.model.util.attributes.Date;
import seedu.homerce.model.util.attributes.Title;

/**
 * A utility class to help with building Revenue objects.
 */
public class RevenueBuilder {

    public static final Service DEFAULT_SERVICE = new Service(new Title("Hair Wash"), new Duration(5.0),
        new Amount(5.00));

    private Service service;
    private Date date;
    private String serviceCode = "SC996";

    /**
     * Creates a {@code RevenueBuilder} with the default details.
     */
    public RevenueBuilder() {
        service = DEFAULT_SERVICE;
        service.addServiceCode(serviceCode);
        date = new Date("25-10-2020");
    }

    /**
     * Initializes the RevenueBuilder with the data of {@code revenueToCopy}.
     */
    public RevenueBuilder(Revenue revenueToCopy) {
        service = revenueToCopy.getService();
        date = revenueToCopy.getDate();
    }

    /**
     * Sets the {@code Service} of the {@code Revenue} that we are building.
     */
    public RevenueBuilder withService(Service service, String serviceCode) {
        service.addServiceCode(serviceCode);
        this.service = service;
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Revenue} that we are building.
     */
    public RevenueBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    public Revenue build() {
        return new Revenue(service, date);
    }

}
