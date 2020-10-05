package seedu.address.model.service;

import java.util.function.Predicate;

import seedu.address.model.service.exceptions.MaximumServiceException;

/**
 * A unique identification code for each Service object.
 */
public class ServiceCode {
    /** String representing a unique identification number for each Service object */
    public final String value;
    public static final String leadingZerosRegex = "^0+(?!$)";
    public static final Predicate<ServiceCode> VALIDATION_PREDICATE = i -> i.value.substring(0,2).equals("SC") &&
            i.value.length() == 5 && getIntFromServiceCode(i) < 1000 && getIntFromServiceCode(i) >= 0;

    /** Tracks the unused unique identification number for the service code */
    public static int count = 0;

    public ServiceCode(String value) {
        this.value = value;
    }

    /**
     * Creates a new unique identification code for a Service to use.
     *
     * @return a unique identification code for a Service object.
     */
    public static ServiceCode generateNewServiceCode() {
        int length = String.valueOf(count).length();
        if (length >= 4) {
            throw new MaximumServiceException("You have reached the maximum number of services that you can add"
                    + "for SuperSalon");
        }

        StringBuilder builder = new StringBuilder("SC");
        builder.append("0".repeat(3 - length)).append(String.valueOf(count));
        count++;
        return new ServiceCode(builder.toString());
    }

    public static boolean isValidServiceCode(ServiceCode test) {
        return VALIDATION_PREDICATE.test(test);
    }

    /**
     * Extracts the integer value of the identification code from ServiceCode.
     *
     * @param serviceCode is the ServiceCode object storing the unique identification code of a Service object.
     * @return an integer representing the unique identification number.
     */
    private static int getIntFromServiceCode(ServiceCode serviceCode) {
        return Integer.valueOf(serviceCode.value.substring(2).replaceFirst(leadingZerosRegex, ""));
    }
}
