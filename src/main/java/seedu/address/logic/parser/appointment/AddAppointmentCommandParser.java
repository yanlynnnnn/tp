package seedu.address.logic.parser.appointment;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_SERVICE_CODE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME_OF_DAY;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.appointment.AddAppointmentCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.AppointmentTemp;
import seedu.address.model.appointment.TimeOfDay;
import seedu.address.model.client.Phone;
import seedu.address.model.service.ServiceCode;
import seedu.address.model.util.attributes.Date;

/**
 * Parses input arguments and creates a new AddAppointmentCommand object
 */
public class AddAppointmentCommandParser implements Parser<AddAppointmentCommand> {
    @Override
    public AddAppointmentCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(
                    userInput, PREFIX_DATE, PREFIX_PHONE,
                    PREFIX_TIME_OF_DAY, PREFIX_SERVICE_SERVICE_CODE);

        if (!arePrefixesPresent(argMultimap, PREFIX_DATE, PREFIX_PHONE, PREFIX_TIME_OF_DAY, PREFIX_SERVICE_SERVICE_CODE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddAppointmentCommand.MESSAGE_USAGE));
        }

        Date date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        TimeOfDay time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME_OF_DAY).get());

        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        ServiceCode serviceCode = ParserUtil.parseServiceCode(argMultimap.getValue(PREFIX_SERVICE_SERVICE_CODE).get());

        AppointmentTemp appointmentTemp = new AppointmentTemp(date, time, phone, serviceCode);

        return new AddAppointmentCommand(appointmentTemp);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
