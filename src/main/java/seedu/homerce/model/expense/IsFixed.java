package seedu.homerce.model.expense;

import static java.util.Objects.requireNonNull;

import seedu.homerce.commons.util.AppUtil;

public class IsFixed {
    public static final String MESSAGE_CONSTRAINTS = "IsFixed must be in 'y' or 'n' format.";

    public final boolean value;
    private boolean willRecur;

    /**
     * Represents whether the expense is fixed.
     * @param isFixed
     */
    public IsFixed(String isFixed) {
        requireNonNull(isFixed);
        AppUtil.checkArgument(isValidIsFixed(isFixed), MESSAGE_CONSTRAINTS);
        boolean isExpenseFixed = isFixed.equals("y");
        value = isExpenseFixed;
        willRecur = isExpenseFixed;
    }

    /**
     * Mark IsFixed as recurred.
     */
    public void markRecurred() {
        this.willRecur = false;
    }

    public boolean getRecurred() {
        return this.willRecur;
    }

    public static boolean isValidIsFixed(String test) {
        return (test.equals("y") || test.equals("n"));
    }

    @Override
    public String toString() {
        return value ? "Yes" : "No";
    }
}
