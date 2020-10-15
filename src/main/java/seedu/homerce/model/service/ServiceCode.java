package seedu.homerce.model.service;

import java.util.function.Predicate;

/**
 * A unique identification code for each Service object.
 */
public class ServiceCode {

    public static final String MESSAGE_CONSTRAINTS = "ServiceCode needs to be in the range of SC000-SC999";
    public static final String LEADING_ZEROES_REGEX = "^0+(?!$)";
    public static final Predicate<ServiceCode> VALIDATION_PREDICATE = i -> i.value.substring(0, 2).equals("SC")
        && i.value.length() == 5 && getIntFromServiceCode(i) < 1000 && getIntFromServiceCode(i) >= 0;

    /**
     * String representing a unique identification number for each Service object
     */
    public final String value;

    public ServiceCode(String value) {
        this.value = value;
    }

    public static boolean isValidServiceCode(String test) {
        return VALIDATION_PREDICATE.test(new ServiceCode(test));
    }

    /**
     * Extracts the integer value of the identification code from ServiceCode.
     *
     * @param serviceCode is the ServiceCode object storing the unique identification code of a Service object.
     * @return an integer representing the unique identification number.
     */
    private static int getIntFromServiceCode(ServiceCode serviceCode) {
        return Integer.valueOf(serviceCode.value.substring(2).replaceFirst(LEADING_ZEROES_REGEX, ""));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ServiceCode// instanceof handles nulls
            && value.equals(((ServiceCode) other).value)); // state check
    }

    @Override
    public String toString() {
        return value;
    }
}
