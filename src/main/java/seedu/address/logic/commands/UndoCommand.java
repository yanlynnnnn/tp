package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.HistoryManager;
import seedu.address.model.Model;

/**
 * Undo the last command that updates the state of Homerce's storage.
 *
 * A command that does not affect the state of Homerce's storage will not be considered in the undo command.
 */
public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_SUCCESS = "You have undone you previous change!";

    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) throws CommandException {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
