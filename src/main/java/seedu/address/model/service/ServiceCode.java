package seedu.address.model.service;

import seedu.address.model.service.exceptions.MaximumServiceException;

/**
 * A unique identification code for each Service object.
 */
public class ServiceCode {
    /** String representing a unique identification number for each Service object */
    private String code;

    /** Tracks the unused unique identification number for the service code */
    public static int count = 0;

    ServiceCode(String code) {
        this.code = code;
    }

    public String getServiceCode() {
        return this.code;
    }

    /**
     * Creates a new unique identification code for a Service to use.
     *
     * @return a unique identification code for a Service object.
     */
    public static ServiceCode generateServiceCode() {
        int length = String.valueOf(count).length();
        if (length >= 4) {
            throw new MaximumServiceException("You have reached the maximum number of services that you can add"
                    + "for SuperSalon");
        }

        StringBuilder serviceCode = new StringBuilder("SC");
        serviceCode.append("0".repeat(3 - length));
        serviceCode.append(String.valueOf(count));
        count++;
        return new ServiceCode(serviceCode.toString());
    }
}
