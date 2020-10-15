package seedu.homerce.logic.parser.client;

import static seedu.homerce.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.homerce.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.homerce.logic.commands.client.FindClientCommand;

public class FindClientCommandParserTest {

    private FindClientCommandParser parser = new FindClientCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindClientCommand.MESSAGE_USAGE));
    }

    // Update find command parser test with new implementation
    //    @Test
    //    public void parse_validArgs_returnsFindCommand() {
    //        // no leading and trailing whitespaces
    //        FindClientCommand expectedFindClientCommand =
    //                new FindClientCommand(new NameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob")));
    //        assertParseSuccess(parser, "Alice Bob", expectedFindClientCommand);
    //
    //        // multiple whitespaces between keywords
    //        assertParseSuccess(parser, " \n Alice \n \t Bob  \t", expectedFindClientCommand);
    //    }

}
