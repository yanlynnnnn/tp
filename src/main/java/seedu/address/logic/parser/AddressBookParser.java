package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.client.AddClientCommand;
import seedu.address.logic.commands.client.ClearClientCommand;
import seedu.address.logic.commands.client.DeleteClientCommand;
import seedu.address.logic.commands.client.EditClientCommand;
import seedu.address.logic.commands.client.FindClientCommand;
import seedu.address.logic.commands.client.ListClientCommand;
import seedu.address.logic.commands.expense.AddExpenseCommand;
import seedu.address.logic.commands.expense.ClearExpenseCommand;
import seedu.address.logic.commands.expense.DeleteExpenseCommand;
import seedu.address.logic.commands.expense.EditExpenseCommand;
import seedu.address.logic.commands.expense.FindExpenseCommand;
import seedu.address.logic.commands.expense.ListExpenseCommand;
import seedu.address.logic.commands.service.AddServiceCommand;
import seedu.address.logic.commands.service.ClearServiceCommand;
import seedu.address.logic.commands.service.DeleteServiceCommand;
import seedu.address.logic.commands.service.EditServiceCommand;
import seedu.address.logic.commands.service.FindServiceCommand;
import seedu.address.logic.commands.service.ListServiceCommand;
import seedu.address.logic.parser.client.AddCommandParser;
import seedu.address.logic.parser.client.DeleteCommandParser;
import seedu.address.logic.parser.client.EditCommandParser;
import seedu.address.logic.parser.client.FindCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.expense.AddExpenseCommandParser;
import seedu.address.logic.parser.expense.DeleteExpenseCommandParser;
import seedu.address.logic.parser.expense.EditExpenseCommandParser;
import seedu.address.logic.parser.expense.FindExpenseCommandParser;
import seedu.address.logic.parser.service.AddServiceCommandParser;
import seedu.address.logic.parser.service.DeleteServiceCommandParser;
import seedu.address.logic.parser.service.EditServiceCommandParser;
import seedu.address.logic.parser.service.FindServiceCommandParser;


/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddClientCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditClientCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteClientCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearClientCommand.COMMAND_WORD:
            return new ClearClientCommand();

        case FindClientCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListClientCommand.COMMAND_WORD:
            return new ListClientCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case AddExpenseCommand.COMMAND_WORD:
            return new AddExpenseCommandParser().parse(arguments);

        case EditExpenseCommand.COMMAND_WORD:
            return new EditExpenseCommandParser().parse(arguments);

        case FindExpenseCommand.COMMAND_WORD:
            return new FindExpenseCommandParser().parse(arguments);

        case DeleteExpenseCommand.COMMAND_WORD:
            return new DeleteExpenseCommandParser().parse(arguments);

        case ListExpenseCommand.COMMAND_WORD:
            return new ListExpenseCommand();

        case ClearExpenseCommand.COMMAND_WORD:
            return new ClearExpenseCommand();

        case AddServiceCommand.COMMAND_WORD:
            return new AddServiceCommandParser().parse(arguments);

        case FindServiceCommand.COMMAND_WORD:
            return new FindServiceCommandParser().parse(arguments);

        case ClearServiceCommand.COMMAND_WORD:
            return new ClearServiceCommand();

        case ListServiceCommand.COMMAND_WORD:
            return new ListServiceCommand();

        case DeleteServiceCommand.COMMAND_WORD:
            return new DeleteServiceCommandParser().parse(arguments);

        case EditServiceCommand.COMMAND_WORD:
            return new EditServiceCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
