package seedu.address.storage.client;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.manager.ReadOnlyClientManager;

/**
 * A class to access ClientManager data stored as a json file on the hard disk.
 */
public class JsonClientStorage implements ClientStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonClientStorage.class);

    private Path filePath;

    public JsonClientStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getClientManagerFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyClientManager> readClientManager() throws DataConversionException {
        return readClientManager(filePath);
    }

    /**
     * Similar to {@link #readClientManager()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyClientManager> readClientManager(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableClientManager> jsonAddressBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableClientManager.class);
        if (!jsonAddressBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveClientManager(ReadOnlyClientManager addressBook) throws IOException {
        saveClientManager(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveClientManager(ReadOnlyClientManager)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveClientManager(ReadOnlyClientManager addressBook, Path filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableClientManager(addressBook), filePath);
    }

}
