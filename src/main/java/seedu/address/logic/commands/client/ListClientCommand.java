package seedu.address.logic.commands.client;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLIENTS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.HistoryManager;
import seedu.address.model.Model;

/**
 * Lists all clients in the address book to the user.
 */
public class ListClientCommand extends Command {

    public static final String COMMAND_WORD = "listcli";

    public static final String MESSAGE_SUCCESS = "Listed all clients";


    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) {
        requireNonNull(model);
        model.updateFilteredClientList(PREDICATE_SHOW_ALL_CLIENTS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
