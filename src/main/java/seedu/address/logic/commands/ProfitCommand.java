package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_MONTH_OF_YEAR;

import java.time.Month;
import seedu.address.commons.core.index.Index;
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

    private final Month month;
    public ProfitCommand(Month month) {
        this.month = month;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
