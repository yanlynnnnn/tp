package seedu.address.model.expense;

import java.util.Objects;

import seedu.address.model.util.attributes.Amount;
import seedu.address.model.util.attributes.Date;
import seedu.address.model.util.attributes.Description;
import seedu.address.model.util.attributes.Tag;

public class Expense {
    //Identity fields
    private Description description;
    private IsFixed isFixed;

    //Data fields
    private Amount value;
    private Date date;
    private Tag tag;

    /**
     * Every field must be present and not null.
     */
    public Expense(Description description, IsFixed isFixed, Amount value, Date date, Tag tag) {
        this.description = description;
        this.isFixed = isFixed;
        this.value = value;
        this.date = date;
        this.tag = tag;
    }

    public Description getDescription() {
        return description;
    }

    public IsFixed getIsFixed() {
        return isFixed;
    }

    public Amount getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public Tag getTag() {
        return tag;
    }

    /**
     * Returns true if both expenses have the same identity fields.
     * This defines a weaker notion of equality between two expenses.
     */
    public boolean isSameExpense(Expense otherExpense) {
        if (otherExpense == this) {
            return true;
        }

        return otherExpense != null
                && otherExpense.getDescription().equals(getDescription())
                && (otherExpense.getIsFixed().equals(getIsFixed()));
    }

    /**
     * Returns true if both expenses have the same identity and data fields.
     * This defines a stronger notion of equality between two expenses.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Expense)) {
            return false;
        }

        Expense otherExpense = (Expense) other;
        return otherExpense.getDescription().equals(getDescription())
                && otherExpense.getIsFixed().equals(getIsFixed())
                && otherExpense.getValue().equals(getValue())
                && otherExpense.getDate().equals(getDate())
                && otherExpense.getTag().equals(getTag());
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, isFixed, value, date, tag);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append("\n Is Fixed: ")
                .append(getIsFixed())
                .append(" Value: ")
                .append(getValue())
                .append(" Date: ")
                .append(getDate())
                .append(" Tag: ")
                .append(getTag());
        return builder.toString();
    }
}


