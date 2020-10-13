package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.client.Client;
import seedu.address.model.client.exceptions.DuplicateClientException;
import seedu.address.model.expense.Expense;
import seedu.address.model.manager.ClientManager;
import seedu.address.model.manager.ReadOnlyClientManager;
import seedu.address.testutil.ClientBuilder;

public class ClientManagerTest {

    private final ClientManager clientManager = new ClientManager();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), clientManager.getClientList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> clientManager.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        ClientManager newData = getTypicalAddressBook();
        clientManager.resetData(newData);
        assertEquals(newData, clientManager);
    }

    @Test
    public void resetData_withDuplicateClients_throwsDuplicateClientException() {
        // Two clients with the same identity fields
        Client editedAlice = new ClientBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Client> newClients = Arrays.asList(ALICE, editedAlice);
        ClientManagerStub newData = new ClientManagerStub(newClients, FXCollections.observableArrayList());

        assertThrows(DuplicateClientException.class, () -> clientManager.resetData(newData));
    }

    //    @Test
    //    public void hasClient_nullClient_throwsNullPointerException() {
    //        assertThrows(NullPointerException.class, () -> addressBook.hasClient(null));
    //    }

    @Test
    public void hasClient_clientNotInAddressBook_returnsFalse() {
        assertFalse(clientManager.hasClient(ALICE));
    }

    @Test
    public void hasClient_clientInAddressBook_returnsTrue() {
        clientManager.addClient(ALICE);
        assertTrue(clientManager.hasClient(ALICE));
    }

    @Test
    public void hasClient_clientWithSameIdentityFieldsInAddressBook_returnsTrue() {
        clientManager.addClient(ALICE);
        Client editedAlice = new ClientBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(clientManager.hasClient(editedAlice));
    }

    @Test
    public void getClientList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> clientManager.getClientList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose clients list can violate interface constraints.
     */
    private static class ClientManagerStub implements ReadOnlyClientManager {
        private final ObservableList<Client> clients = FXCollections.observableArrayList();
        private final ObservableList<Expense> expenses = FXCollections.observableArrayList();

        ClientManagerStub(Collection<Client> clients, Collection<Expense> expenses) {
            this.clients.setAll(clients);
            this.expenses.setAll(expenses);
        }

        @Override
        public ObservableList<Client> getClientList() {
            return clients;
        }
    }
}


