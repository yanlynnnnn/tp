package seedu.address.logic.commands.appointment;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.HistoryManager;
import seedu.address.model.Model;

/**
 * Clears the appointment list.
 */
public class ClearAppointmentCommand extends Command {
    public static final String COMMAND_WORD = "clearapt";
    public static final String MESSAGE_SUCCESS = "Appointment list has been cleared!";

    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) {
        requireNonNull(model);
        model.setAppointment(new ArrayList<>());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
