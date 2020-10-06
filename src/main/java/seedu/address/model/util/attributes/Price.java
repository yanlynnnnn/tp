package seedu.address.model.util.attributes;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Predicate;

import seedu.address.commons.util.AppUtil;

/**
 * The price of a service provided by SuperSalon.
 */
public class Price {
    public static final String MESSAGE_CONSTRAINTS = "Price (in dollars and cents - eg: 15.00) "
            + "must be a valid double greater than 0";

    private static final double MIN_VALUE = 0.0;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    public static final Predicate<Double> VALIDATION_PREDICATE = i -> i > MIN_VALUE && i <= MAX_VALUE;


    /** Representing money in Singapore Dollars */
    public final BigDecimal value;

    public Price(double price) {
        requireNonNull(price);
        AppUtil.checkArgument(isValidPrice(price), MESSAGE_CONSTRAINTS);
        value = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Returns true if a given string is a valid duration.
     */
    public static boolean isValidPrice(Double test) {
        return VALIDATION_PREDICATE.test(test);
    }

    /**
     * Gives a string representation of the price, in Singapore Dollars.
     *
     * @return a string representing the amount of Singapore Dollars the price is.
     */
    @Override
    public String toString() {
        return value.setScale(2, RoundingMode.HALF_UP).toString(); // Two decimal places
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Price// instanceof handles nulls
                && value.equals(((Price) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
