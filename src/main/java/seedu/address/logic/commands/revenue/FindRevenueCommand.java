package seedu.address.logic.commands.revenue;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_SERVICE_CODE;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.revenue.Revenue;

/**
 * Finds and lists all revenue in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindRevenueCommand extends Command {

    public static final String COMMAND_WORD = "findrev";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all revenue by either their"
        + " date or service code, and displays them as a list with index numbers.\n"
        + "Parameters: "
        + PREFIX_SERVICE_SERVICE_CODE + "SERVICE_CODE "
        + "Example: " + COMMAND_WORD + " "
        + PREFIX_SERVICE_SERVICE_CODE + "SC000 ";

    private final Predicate<Revenue> predicate;

    public FindRevenueCommand(Predicate<Revenue> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredRevenueList(predicate);
        return new CommandResult(
            String.format(Messages.MESSAGE_REVENUE_LISTED_OVERVIEW, model.getFilteredRevenueList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof FindRevenueCommand // instanceof handles nulls
            && predicate.equals(((FindRevenueCommand) other).predicate)); // state check
    }
}
