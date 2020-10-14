package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_MONTH_OF_YEAR;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ProfitCommand extends Command {

    public static final String COMMAND_WORD = "profit";

    public static final String MESSAGE_SUCCESS = "The profit for this month is ";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays the profit for the month specified "
            + "Parameters: "
            + PREFIX_MONTH_OF_YEAR + "MONTH "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_MONTH_OF_YEAR + "mar";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
