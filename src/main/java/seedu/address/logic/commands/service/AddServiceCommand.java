package seedu.address.logic.commands.service;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_PRICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_TITLE;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.service.Service;

/**
 * Adds a service to SuperSalon.
 */
public class AddServiceCommand extends Command {

    public static final String COMMAND_WORD = "addsvc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a service to the list of services"
            + "Parameters: "
            + PREFIX_SERVICE_TITLE + "TITLE "
            + PREFIX_SERVICE_DURATION + "DURATION "
            + PREFIX_SERVICE_PRICE + "PRICE "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_SERVICE_TITLE + "Lash Lift"
            + PREFIX_SERVICE_DURATION + "0.5 "
            + PREFIX_SERVICE_PRICE + "38 ";

    private static final String MESSAGE_SUCCESS = "New Service added: %1$s";
    private final Service toAdd;

    public AddServiceCommand(Service toAdd) {
        requireNonNull(toAdd);
        this.toAdd = toAdd;

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addService(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }
}
