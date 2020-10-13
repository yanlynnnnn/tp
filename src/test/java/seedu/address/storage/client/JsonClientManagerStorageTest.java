package seedu.address.storage.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.HOON;
import static seedu.address.testutil.TypicalClients.IDA;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.manager.ClientManager;
import seedu.address.model.manager.ReadOnlyClientManager;

public class JsonClientManagerStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonClientStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readAddressBook(null));
    }

    private java.util.Optional<ReadOnlyClientManager> readAddressBook(String filePath) throws Exception {
        return new JsonClientStorage(Paths.get(filePath)).readClientManager(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readAddressBook("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readAddressBook("notJsonFormatClient.json"));
    }

    @Test
    public void readAddressBook_invalidClientAddressBook_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readAddressBook("invalidClientManager.json"));
    }

    @Test
    public void readAddressBook_invalidAndValidClientAddressBook_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readAddressBook("invalidAndValidClientManager.json"));
    }

    @Test
    public void readAndSaveAddressBook_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempAddressBook.json");
        ClientManager original = getTypicalAddressBook();
        JsonClientStorage jsonAddressBookStorage = new JsonClientStorage(filePath);

        // Save in new file and read back
        jsonAddressBookStorage.saveClientManager(original, filePath);
        ReadOnlyClientManager readBack = jsonAddressBookStorage.readClientManager(filePath).get();
        assertEquals(original, new ClientManager(readBack));

        // Modify data, overwrite exiting file, and read back
        original.addClient(HOON);
        original.removeClient(ALICE);
        jsonAddressBookStorage.saveClientManager(original, filePath);
        readBack = jsonAddressBookStorage.readClientManager(filePath).get();
        assertEquals(original, new ClientManager(readBack));

        // Save and read without specifying file path
        original.addClient(IDA);
        jsonAddressBookStorage.saveClientManager(original); // file path not specified
        readBack = jsonAddressBookStorage.readClientManager().get(); // file path not specified
        assertEquals(original, new ClientManager(readBack));

    }

    @Test
    public void saveAddressBook_nullAddressBook_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveAddressBook(null, "SomeFile.json"));
    }

    /**
     * Saves {@code addressBook} at the specified {@code filePath}.
     */
    private void saveAddressBook(ReadOnlyClientManager addressBook, String filePath) {
        try {
            new JsonClientStorage(Paths.get(filePath))
                    .saveClientManager(addressBook, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveAddressBook(new ClientManager(), null));
    }
}
