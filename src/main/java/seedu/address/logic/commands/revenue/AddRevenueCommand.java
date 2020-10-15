package seedu.address.logic.commands.revenue;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.HistoryManager;
import seedu.address.model.Model;
import seedu.address.model.revenue.Revenue;

public class AddRevenueCommand extends Command {

    private static final String MESSAGE_ADD_REVENUE_SUCCESS = "New Revenue added: %1$s";
    private final Revenue toAdd;

    /**
     * Adds a Revenue object as an attribute for the AddRevenueCommand object.
     *
     * @param toAdd is the Revenue to be added.
     */
    public AddRevenueCommand(Revenue toAdd) {
        requireNonNull(toAdd);
        this.toAdd = toAdd;
    }

    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) {
        requireNonNull(model);
        model.addRevenue(toAdd);
        return new CommandResult(String.format(MESSAGE_ADD_REVENUE_SUCCESS, toAdd));
    }
}
