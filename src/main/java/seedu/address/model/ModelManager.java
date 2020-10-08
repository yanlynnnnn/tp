package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.client.Client;
import seedu.address.model.expense.Expense;
import seedu.address.model.manager.ReadOnlyRevenueTracker;
import seedu.address.model.manager.ReadOnlyServiceManager;
import seedu.address.model.manager.RevenueTracker;
import seedu.address.model.manager.ServiceManager;
import seedu.address.model.revenue.Revenue;
import seedu.address.model.service.Service;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {

    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final ServiceManager serviceManager;
    private final RevenueTracker revenueTracker;
    private final UserPrefs userPrefs;

    private final FilteredList<Client> filteredClients;
    private final FilteredList<Expense> filteredExpenses;
    private final FilteredList<Service> filteredServices;
    private final FilteredList<Revenue> filteredRevenue;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs,
                        ReadOnlyServiceManager serviceManager, ReadOnlyRevenueTracker revenueTracker) {
        super();
        requireAllNonNull(addressBook, userPrefs, serviceManager, revenueTracker);

        logger.fine("Initializing with SuperSalon: " + addressBook + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        this.serviceManager = new ServiceManager(serviceManager);
        this.revenueTracker = new RevenueTracker(revenueTracker);

        filteredClients = new FilteredList<>(this.addressBook.getClientList());
        filteredExpenses = new FilteredList<>(this.addressBook.getExpenseList());
        filteredServices = new FilteredList<>(this.serviceManager.getServiceList());
        filteredRevenue = new FilteredList<>(this.revenueTracker.getRevenueList());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs(), new ServiceManager(), new RevenueTracker());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasClient(Client client) {
        requireNonNull(client);
        return addressBook.hasClient(client);
    }

    @Override
    public void deleteClient(Client target) {
        addressBook.removeClient(target);
    }

    @Override
    public void addClient(Client client) {
        addressBook.addClient(client);
        updateFilteredClientList(PREDICATE_SHOW_ALL_CLIENTS);
    }

    @Override
    public void setClient(Client target, Client editedClient) {
        requireAllNonNull(target, editedClient);

        addressBook.setClient(target, editedClient);
    }

    //=========== Filtered Client List Accessors =============================================================
    @Override
    public void deleteExpense(Expense target) {
        addressBook.removeExpense(target);
    }

    @Override
    public void addExpense(Expense expense) {
        addressBook.addExpense(expense);
        updateFilteredExpenseList(PREDICATE_SHOW_ALL_EXPENSES);
    }

    @Override
    public void setExpense(Expense target, Expense editedExpense) {
        requireAllNonNull(target, editedExpense);

        addressBook.setExpense(target, editedExpense);
    }

    @Override
    public void setExpenses(List<Expense> expenses) {
        addressBook.setExpenses(expenses);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Client} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Client> getFilteredClientList() {
        return filteredClients;
    }

    @Override
    public void updateFilteredClientList(Predicate<Client> predicate) {
        requireNonNull(predicate);
        filteredClients.setPredicate(predicate);
    }

    /**
     * Returns an unmodifiable view of the list of {@code Expense} backed by the internal list of Expenses
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Expense> getFilteredExpenseList() {
        return filteredExpenses;
    }

    @Override
    public void updateFilteredExpenseList(Predicate<Expense> predicate) {
        requireNonNull(predicate);
        filteredExpenses.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredClients.equals(other.filteredClients);
    }

    //=========== ServiceManager ===============
    @Override
    public void addService(Service toAdd) {
        requireNonNull(toAdd);
        serviceManager.addService(toAdd);
        updateFilteredServiceList(PREDICATE_SHOW_ALL_SERVICES);
    }

    @Override
    public void updateFilteredServiceList(Predicate<Service> predicate) {
        requireNonNull(predicate);
        filteredServices.setPredicate(predicate);
    }

    /**
     * Returns an unmodifiable view of the list of {@code Client} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Service> getFilteredServiceList() {
        return filteredServices;
    }

    @Override
    public ReadOnlyServiceManager getServiceManager() {
        return this.serviceManager;
    }

    //=========== RevenueTracker ===============
    @Override
    public void addRevenue(Revenue toAdd) {
        requireNonNull(toAdd);
        revenueTracker.addRevenue(toAdd);
        updateFilteredRevenueList(PREDICATE_SHOW_ALL_REVENUE);
    }

    @Override
    public void deleteRevenue(Revenue target) {
        revenueTracker.removeRevenue(target);
    }

    @Override
    public void setRevenues(List<Revenue> revenues) {
        revenueTracker.setRevenues(revenues);
    }

    @Override
    public void updateFilteredRevenueList(Predicate<Revenue> predicate) {
        requireNonNull(predicate);
        filteredRevenue.setPredicate(predicate);
    }

    @Override
    public ObservableList<Revenue> getFilteredRevenueList() {
        return filteredRevenue;
    }

    @Override
    public ReadOnlyRevenueTracker getRevenueTracker() {
        return this.revenueTracker;
    }
}
