package seedu.address.logic.parser.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ISFIXED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.expense.FindExpenseCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.expense.DatePredicate;
import seedu.address.model.expense.DescriptionPredicate;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.IsFixedPredicate;
import seedu.address.model.expense.TagPredicate;

/**
 * Parses input arguments and creates a new FindExpenseCommand object
 */
public class FindExpenseCommandParser implements Parser<FindExpenseCommand> {

    public static final String MULTIPLE_PARAMETERS = "Please only input one parameter.";
    public static final int NUM_ALLOWED_PARAMETERS = 1;

    /**
     * Parses the given {@code String} of arguments in the context of the FindExpenseCommand
     * and returns a FindExpenseCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindExpenseCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DESCRIPTION, PREFIX_ISFIXED, PREFIX_DATE, PREFIX_TAG);

        if (args.isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindExpenseCommand.MESSAGE_USAGE));
        }

        if (((!isPrefixPresent(argMultimap, PREFIX_DESCRIPTION)
                && !isPrefixPresent(argMultimap, PREFIX_DATE)
                && !isPrefixPresent(argMultimap, PREFIX_AMOUNT)
                && !isPrefixPresent(argMultimap, PREFIX_ISFIXED))
                && !isPrefixPresent(argMultimap, PREFIX_TAG))
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    FindExpenseCommand.MESSAGE_USAGE));
        }

        if (areMultipleParametersPresent(argMultimap, PREFIX_DESCRIPTION, PREFIX_ISFIXED, PREFIX_DATE, PREFIX_TAG)) {
            throw new ParseException(MULTIPLE_PARAMETERS);
        }

        Predicate<Expense> predicate = null;
        if (argMultimap.getValue(PREFIX_DESCRIPTION).isPresent()) {
            predicate = new DescriptionPredicate(ParserUtil.parseDescription(
                    argMultimap.getValue(PREFIX_DESCRIPTION).get()));
        }
        if (argMultimap.getValue(PREFIX_ISFIXED).isPresent()) {
            predicate = new IsFixedPredicate(ParserUtil.parseIsFixed(argMultimap.getValue(PREFIX_ISFIXED)
                    .get()));
        }
        if (argMultimap.getValue(PREFIX_DATE).isPresent()) {
            predicate = new DatePredicate(ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get()));
        }
        if (argMultimap.getValue(PREFIX_TAG).isPresent()) {
            predicate = new TagPredicate(ParserUtil.parseTag(argMultimap.getValue(PREFIX_TAG).get()));
        }
        return new FindExpenseCommand(predicate);
    }

    /**
     * Returns true if there is more than one input parameters.
     */
    private static boolean areMultipleParametersPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).filter(prefix -> argumentMultimap.getValue(prefix).isPresent()).count()
            > NUM_ALLOWED_PARAMETERS;
    }

    /**
     * Returns true if the prefix is present in the user's command.
     */
    private static boolean isPrefixPresent(ArgumentMultimap argumentMultimap, Prefix prefix) {
        return argumentMultimap.getValue(prefix).isPresent();
    }
}
