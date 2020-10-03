package seedu.address.model.revenue;

import java.util.Objects;

import seedu.address.model.service.Service;
import seedu.address.model.util.attributes.Amount;
import seedu.address.model.util.attributes.Date;

public class Revenue {

    //Identity field
    private Service service;
    private Date date;

    //Data field
    private Amount value;

    /**
     * Every field must be present and not null.
     */
    public Revenue(Service service, Date date, Amount value) {
        this.service = service;
        this.date = date;
        this.value = value;
    }

    public Service getService() {
        return service;
    }

    public Date getDate() {
        return date;
    }

    public Amount getValue() {
        return value;
    }

    /**
     * Returns true if both revenues have the same identity fields.
     * This defines a weaker notion of equality between two revenues.
     */
    public boolean isSameRevenue(Revenue otherRevenue) {
        if (otherRevenue == this) {
            return true;
        }

        return otherRevenue != null
                && otherRevenue.getService().equals(getService())
                && (otherRevenue.getDate().equals(getDate()));
    }

    /**
     * Returns true if both revenues have the same identity and data fields.
     * This defines a stronger notion of equality between two revenues.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Revenue)) {
            return false;
        }

        Revenue otherRevenue = (Revenue) other;
        return otherRevenue.getService().equals(getService())
                && otherRevenue.getDate().equals(getDate())
                && otherRevenue.getValue().equals(getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(service, date, value);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Service: ")
                .append(getService())
                .append(" Date: ")
                .append(getDate())
                .append(" Value: ")
                .append(getValue());
        return builder.toString();
    }
}
