package seedu.address.model.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.model.service.exceptions.MaximumServiceException;
import seedu.address.model.util.attributes.Amount;
import seedu.address.model.util.attributes.Title;

/**
 * Generates a unique service code for each service.
 */
public class ServiceCodeGenerator {

    /**
     * Creates a new unique identification code for a Service to use.
     *
     * @return a unique identification code for a Service object.
     */
    public static String generateNewServiceCode(List<Service> serviceList) {
        Set<Service> set = new HashSet<>(serviceList);
        String serviceCode = "";

        for (int codeNum = 0; codeNum < 1000; codeNum++) {
            String potentialServiceCode = "SC" + "0".repeat(3 - String.valueOf(codeNum).length())
                + String.valueOf(codeNum);

            // .equals for two services return true as long as value of ServiceCode is the same
            if (!set.contains(new Service(new Title("Test"), new Duration(0.5), new Amount(0.5))
                .addServiceCode(potentialServiceCode))) {

                serviceCode = potentialServiceCode;
                break;
            }
        }

        if (serviceCode.equals("")) { // No suitable service code found from codeNum 0 - 999
            throw new MaximumServiceException("You have reached the maximum number of services that you can add"
                + "for SuperSalon");
        }

        return serviceCode;
    }
}
