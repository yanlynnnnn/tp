package seedu.address.logic.commands.service;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.manager.ServiceManager;

/**
 * Clears the address book.
 */
public class ClearServiceCommand extends Command {

    public static final String COMMAND_WORD = "clearsvc";
    public static final String MESSAGE_SUCCESS = "All services has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setServiceManager(new ServiceManager());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
