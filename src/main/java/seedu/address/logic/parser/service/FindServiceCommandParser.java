package seedu.address.logic.parser.service;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.service.FindServiceCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.service.ServiceContainKeywordPredicate;

/**
 * Parses input arguments and creates a new FindServiceCommand object
 */
public class FindServiceCommandParser implements Parser<FindServiceCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindServiceCommand
     * and returns a FindServiceCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindServiceCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindServiceCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindServiceCommand(new ServiceContainKeywordPredicate(Arrays.asList(nameKeywords)));
    }
}
