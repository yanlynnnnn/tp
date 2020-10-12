package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path addressBookFilePath = Paths.get("data", "addressbook.json");

    private Path serviceStorageFilePath = Paths.get("data", "services.json");
    private Path expenseStorageFilePath = Paths.get("data", "expenses.json");
    private Path revenueStorageFilePath = Paths.get("data", "revenue.json");

    private Path appointmentStorageFilePath = Paths.get("data", "appointments.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {
    }

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setAddressBookFilePath(newUserPrefs.getAddressBookFilePath());
        setServiceStorageFilePath(newUserPrefs.getServiceStorageFilePath());
        setAppointmentStorageFilePath(newUserPrefs.getAppointmentStorageFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        this.addressBookFilePath = addressBookFilePath;
    }

    public void setServiceStorageFilePath(Path serviceStorageFilePath) {
        requireNonNull(serviceStorageFilePath);
        this.serviceStorageFilePath = serviceStorageFilePath;
    }

    public Path getAppointmentStorageFilePath() {
        return appointmentStorageFilePath;
    }

    public void setAppointmentStorageFilePath(Path appointmentStorageFilePath) {
        requireNonNull(appointmentStorageFilePath);
        this.appointmentStorageFilePath = appointmentStorageFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && addressBookFilePath.equals(o.addressBookFilePath)
                && serviceStorageFilePath.equals(o.serviceStorageFilePath)
                && appointmentStorageFilePath.equals(o.appointmentStorageFilePath);
    }

    public Path getServiceStorageFilePath() {
        return serviceStorageFilePath;
    }

    public Path getRevenueStorageFilePath() {
        return revenueStorageFilePath;
    }

    public Path getExpenseStorageFilePath() {
        return expenseStorageFilePath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + addressBookFilePath);
        return sb.toString();
    }

}
