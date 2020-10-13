package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.client.Client;
import seedu.address.model.expense.Expense;
import seedu.address.model.manager.ReadOnlyClientManager;
import seedu.address.model.revenue.Revenue;
import seedu.address.model.service.Service;

/**
 * API of the Logic component
 */
public interface Logic {

    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the ClientManager.
     *
     * @see seedu.address.model.Model#getClientManager()
     */
    ReadOnlyClientManager getClientManager();

    /**
     * Returns an unmodifiable view of the filtered list of clients
     */
    ObservableList<Client> getFilteredClientList();

    /**
     * Returns an unmodifiable view of the filtered list of expenses
     */
    ObservableList<Expense> getFilteredExpenseList();

    /**
     * Returns an unmodifiable view of the filtered list of services
     */
    ObservableList<Service> getFilteredServiceList();

    /** Returns an unmodifiable view of the filtered list of appointments */
    ObservableList<Appointment> getFilteredAppointmentList();

    /**
     * Returns an unmodifiable view of the filtered list of revenues
     */
    ObservableList<Revenue> getFilteredRevenueList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getClientManagerFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

}
