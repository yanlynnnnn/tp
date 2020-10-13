package seedu.address.logic.commands.revenue;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.revenue.Revenue;

public class DeleteRevenueCommand extends Command {

    public static final String MESSAGE_DELETE_REVENUE_SUCCESS = "Deleted Revenue: %1$s";
    private final Revenue targetRevenue;

    public DeleteRevenueCommand(Revenue targetRevenue) {
        this.targetRevenue = targetRevenue;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.deleteRevenue(targetRevenue);
        return new CommandResult(String.format(MESSAGE_DELETE_REVENUE_SUCCESS, targetRevenue));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof DeleteRevenueCommand // instanceof handles nulls
            && targetRevenue.equals(((DeleteRevenueCommand) other).targetRevenue)); // state check
    }
}
