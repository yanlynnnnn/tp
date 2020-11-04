package seedu.homerce.logic.commands.client;

import static java.util.Objects.requireNonNull;
import static seedu.homerce.model.Model.PREDICATE_SHOW_ALL_APPOINTMENTS;
import static seedu.homerce.model.Model.PREDICATE_SHOW_ALL_CLIENTS;

import java.util.List;

import seedu.homerce.logic.commands.Command;
import seedu.homerce.logic.commands.CommandResult;
import seedu.homerce.logic.commands.exceptions.CommandException;
import seedu.homerce.model.Model;
import seedu.homerce.model.appointment.Appointment;
import seedu.homerce.model.client.Client;
import seedu.homerce.model.manager.ClientManager;
import seedu.homerce.model.manager.HistoryManager;



/**
 * Clears the homerce.
 */
public class ClearClientCommand extends Command {

    public static final String COMMAND_WORD = "clearcli";
    public static final String MESSAGE_SUCCESS = "All clients have been cleared!";


    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) throws CommandException {
        requireNonNull(model);

        model.updateFilteredClientList(PREDICATE_SHOW_ALL_CLIENTS);
        model.updateFilteredAppointmentList(PREDICATE_SHOW_ALL_APPOINTMENTS);

        List<Client> allClients = model.getFilteredClientList();
        List<Appointment> allAppointments = model.getFilteredAppointmentList();

        boolean isAnyClientScheduled = allClients.stream()
                .anyMatch(client -> !DeleteClientCommand.isValidDeletion(client, allAppointments));

        if (isAnyClientScheduled) {
            throw new CommandException("Cannot clear clients that are already scheduled in upcoming appointments."
            + "\n Please remove these appointments before clearing your clients.");
        }

        model.setClientManager(new ClientManager());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
