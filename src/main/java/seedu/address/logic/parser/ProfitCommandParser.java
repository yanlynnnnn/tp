package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MONTH_OF_YEAR;

import java.util.stream.Stream;
import seedu.address.logic.commands.ProfitCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ProfitCommand object
 */
public class ProfitCommandParser implements Parser<ProfitCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ProfitCommand
     * and returns a ProfitCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public ProfitCommand parse(String args) throws ParseException {
        ArgumentMultimap argumentMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MONTH_OF_YEAR);

        if (!isPrefixPresent(argumentMultimap, PREFIX_MONTH_OF_YEAR)
            || !argumentMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ProfitCommand.MESSAGE_USAGE));
        }

        return new ProfitCommand("month");
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean isPrefixPresent(ArgumentMultimap argumentMultimap, Prefix prefix) {
        return argumentMultimap.getValue(prefix).isPresent();
    }
}
