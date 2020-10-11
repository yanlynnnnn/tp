package seedu.address.logic.parser.appointment;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SERVICE_SERVICE_CODE;

import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.appointment.AddAppointmentCommand;
import seedu.address.logic.commands.appointment.FindAppointmentCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.DateAppointmentPredicate;
import seedu.address.model.appointment.NameAppointmentPredicate;
import seedu.address.model.appointment.PhoneAppointmentPredicate;
import seedu.address.model.appointment.ServiceCodeAppointmentPredicate;

public class FindAppointmentCommandParser implements Parser<FindAppointmentCommand> {

    public static final String MULTIPLE_PARAMETERS = "Please only input one parameter.";
    public static final int NUM_ALLOWED_PARAMETERS = 1;

    @Override
    public FindAppointmentCommand parse(String userInput) throws ParseException {
        String trimmedArgs = userInput.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAppointmentCommand.MESSAGE_USAGE));
        }
        /* TODO For now findapt works with date, phone number, name and service code. Need to include
           searching by month.
         */
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(userInput, PREFIX_DATE, PREFIX_PHONE, PREFIX_SERVICE_SERVICE_CODE, PREFIX_NAME);
        if (areMultipleParametersPresent(argMultimap, PREFIX_DATE, PREFIX_PHONE, PREFIX_SERVICE_SERVICE_CODE,
            PREFIX_NAME)) {
            throw new ParseException(MULTIPLE_PARAMETERS);
        }
        if ((!arePrefixesPresent(argMultimap, PREFIX_DATE)
            && !arePrefixesPresent(argMultimap, PREFIX_PHONE)
            && !arePrefixesPresent(argMultimap, PREFIX_NAME)
            && !arePrefixesPresent(argMultimap, PREFIX_SERVICE_SERVICE_CODE))
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddAppointmentCommand.MESSAGE_USAGE));
        }

        Predicate<Appointment> predicate = null;
        if (argMultimap.getValue(PREFIX_DATE).isPresent()) {
            predicate = new DateAppointmentPredicate(ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get()));
        } else if (argMultimap.getValue(PREFIX_PHONE).isPresent()) {
            predicate = new PhoneAppointmentPredicate(ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get()));
        } else if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            predicate = new NameAppointmentPredicate(ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
            // TODO Not sure if this works if user enters name with multiple words.
        } else if (argMultimap.getValue(PREFIX_SERVICE_SERVICE_CODE).isPresent()) {
            predicate = new ServiceCodeAppointmentPredicate(ParserUtil
                .parseServiceCode(argMultimap.getValue(PREFIX_SERVICE_SERVICE_CODE).get()));
        }

        return new FindAppointmentCommand(predicate);
    }

    /**
     * Returns true if there is more than one input parameter.
     */
    private static boolean areMultipleParametersPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).filter(prefix -> argumentMultimap.getValue(prefix).isPresent()).count()
            > NUM_ALLOWED_PARAMETERS;
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
