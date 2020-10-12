package seedu.address.logic.commands.service;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_SERVICE_CODE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_TITLE;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.service.Service;
import seedu.address.model.service.ServiceContainKeywordPredicate;

/**
 * Finds and lists all services in Homerce whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindServiceCommand extends Command {
    public static final String COMMAND_WORD = "findsvc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all services by either their "
        + "title or service code (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: "
        + PREFIX_SERVICE_TITLE + "TITLE "
        + PREFIX_SERVICE_SERVICE_CODE + "SERVICE_CODE "
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_SERVICE_TITLE + "Lash Lift";

    private final Predicate<Service> predicate;

    public FindServiceCommand(Predicate<Service> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredServiceList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_SERVICES_LISTED_OVERVIEW, model.getFilteredServiceList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof FindServiceCommand// instanceof handles nulls
            && predicate.equals(((FindServiceCommand) other).predicate)); // state check
    }
}
