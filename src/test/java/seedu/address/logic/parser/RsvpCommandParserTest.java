package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERSON;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RSVP_STATUS;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RsvpCommand;


public class RsvpCommandParserTest {

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, RsvpCommand.MESSAGE_USAGE);

    private RsvpCommandParser parser = new RsvpCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // missing fields specified
        assertParseFailure(parser, RsvpCommand.COMMAND_WORD + " "
                + PREFIX_EVENT_ID + "1", MESSAGE_INVALID_FORMAT);
        assertParseFailure(parser, RsvpCommand.COMMAND_WORD + " "
                + PREFIX_PERSON + "1", MESSAGE_INVALID_FORMAT);
        assertParseFailure(parser, RsvpCommand.COMMAND_WORD + " "
                + PREFIX_RSVP_STATUS + "CC", MESSAGE_INVALID_FORMAT);
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }
}
