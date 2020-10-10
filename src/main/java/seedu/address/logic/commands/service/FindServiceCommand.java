package seedu.address.logic.commands.service;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.FindCommand;
import seedu.address.model.Model;
import seedu.address.model.client.NameContainsKeywordsPredicate;

/**
 * Finds and lists all services in Homerce whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindServiceCommand extends Command {
    public static final String COMMAND_WORD = "findsvc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all services whose names contain any of "
        + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
        + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
        + "Example: " + COMMAND_WORD + " Lash";

    private final ServiceContainKeywordPredicate predicate;

    public FindServiceCommand(NameContainsKeywordsPredicate predicate) {
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
            || (other instanceof FindCommand // instanceof handles nulls
            && predicate.equals(((FindCommand) other).predicate)); // state check
    }
}
