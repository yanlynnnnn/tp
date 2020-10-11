package seedu.address.logic.commands.service;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.service.Service;

/**
 * Deletes a service identified using it's displayed index from SuperSalon's service list.
 */
public class DeleteServiceCommand extends Command {

    public static final String COMMAND_WORD = "deletesvc";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Deletes the service identified by the index number used in the displayed service list.\n"
        + "Parameters: INDEX (must be a positive integer)\n"
        + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_SERVICE_SUCCESS = "Deleted Service: %1$s";

    private final Index targetIndex;

    public DeleteServiceCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Service> lastShownList = model.getFilteredServiceList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_SERVICES_INVALID_SERVICE_DISPLAYED_INDEX);
        }

        Service serviceToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteService(serviceToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_SERVICE_SUCCESS, serviceToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof DeleteServiceCommand // instanceof handles nulls
            && targetIndex.equals(((DeleteServiceCommand) other).targetIndex)); // state check
    }
}
