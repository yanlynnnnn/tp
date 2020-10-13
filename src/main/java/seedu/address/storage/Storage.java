package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.manager.ReadOnlyClientManager;
import seedu.address.storage.appointment.AppointmentStorage;
import seedu.address.storage.client.ClientStorage;
import seedu.address.storage.expense.ExpenseStorage;
import seedu.address.storage.revenue.RevenueStorage;
import seedu.address.storage.service.ServiceStorage;

/**
 * API of the Storage component
 */
public interface Storage extends ClientStorage, UserPrefsStorage, ServiceStorage, RevenueStorage, ExpenseStorage,
    AppointmentStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getClientManagerFilePath();

    @Override
    Optional<ReadOnlyClientManager> readClientManager() throws DataConversionException, IOException;

    @Override
    void saveClientManager(ReadOnlyClientManager clientManager) throws IOException;

}
