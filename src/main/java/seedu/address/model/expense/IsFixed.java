package seedu.address.model.expense;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.AppUtil;

public class IsFixed {
    public static final String MESSAGE_CONSTRAINTS = "IsFixed must be in 't' or 'f' format.";

    public final boolean value;

    /**
     * Represents whether the expense is fixed.
     * @param isFixed
     */
    public IsFixed(String isFixed) {
        requireNonNull(isFixed);
        AppUtil.checkArgument(isValidIsFixed(isFixed), MESSAGE_CONSTRAINTS);
        value = (isFixed.equals("t")) ? true : false;
    }

    public static boolean isValidIsFixed(String test) {
        return (test.equals("t") || test.equals("f"));
    }

    @Override
    public String toString() {
        return value ? "True" : "False";
    }
}
