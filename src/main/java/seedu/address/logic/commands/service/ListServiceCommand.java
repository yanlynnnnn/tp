package seedu.address.logic.commands.service;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_SERVICES;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

/**
 * Lists all the services in Homerce to the user.
 */
public class ListServiceCommand extends Command {

    public static final String COMMAND_WORD = "listsvc";

    public static final String MESSAGE_SUCCESS = "Listed all services";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredServiceList(PREDICATE_SHOW_ALL_SERVICES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
