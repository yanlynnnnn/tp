package seedu.address.logic.commands.revenue;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_REVENUE;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all revenues in Homerce to the user.
 */
public class ListRevenueCommand extends Command {

    public static final String COMMAND_WORD = "listrev";

    public static final String MESSAGE_SUCCESS = "Listed all revenue";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredRevenueList(PREDICATE_SHOW_ALL_REVENUE);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
