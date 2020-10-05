package seedu.address.logic.parser.service;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_PRICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_TITLE;

import java.util.stream.Stream;

import seedu.address.logic.commands.service.AddServiceCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new AddServiceCommand object.
 */
public class AddServiceCommandParser implements Parser<AddServiceCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of AddServiceCommand
     * and returns an AddServiceCommand object.
     *
     * @param args is the user input.
     * @return an AddServiceCommand for execution.
     * @throws ParseException if the user input does not abide by the expected format.
     */
    @Override
    public AddServiceCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_SERVICE_TITLE, PREFIX_SERVICE_DURATION, PREFIX_SERVICE_PRICE);

        if (!arePrefixesPresent(argMultimap, PREFIX_SERVICE_TITLE, PREFIX_SERVICE_DURATION, PREFIX_SERVICE_PRICE)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddServiceCommand.MESSAGE_USAGE));
        }


    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
