package seedu.address.logic.commands.client;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.HistoryManager;
import seedu.address.model.Model;
import seedu.address.model.client.Client;

/**
 * Finds and lists all clients in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindClientCommand extends Command {

    public static final String COMMAND_WORD = "findcli";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all clients by either their name or phone "
         + "(case-sensitive) and displays them as a list with index numbers.\n"
             + "Parameters: "
             + PREFIX_NAME + "NAME or "
        + PREFIX_PHONE + "PHONE "
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_NAME + "John";

    private final Predicate<Client> predicate;

    public FindClientCommand(Predicate<Client> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) {
        requireNonNull(model);
        model.updateFilteredClientList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_CLIENTS_LISTED_OVERVIEW, model.getFilteredClientList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindClientCommand // instanceof handles nulls
                && predicate.equals(((FindClientCommand) other).predicate)); // state check
    }
}
