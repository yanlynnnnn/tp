package seedu.address.logic.commands.revenue;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.revenue.Revenue;

public class ClearRevenueCommand extends Command {

    public static final String COMMAND_WORD = "clearrev";
    public static final String MESSAGE_SUCCESS = "Revenue List has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setRevenues(new ArrayList<Revenue>());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
