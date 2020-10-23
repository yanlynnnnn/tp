package seedu.homerce.model.revenue;

import java.util.Comparator;

public class RevenueComparator implements Comparator<Revenue> {

    @Override
    public int compare(Revenue revenue1, Revenue revenue2) {
        return revenue1.getValue().value.compareTo(revenue2.getValue().value);
    }
}
