package seedu.address.testutil;

import seedu.address.model.client.Client;
import seedu.address.model.manager.ClientManager;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withClient("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private ClientManager clientManager;

    public AddressBookBuilder() {
        clientManager = new ClientManager();
    }

    public AddressBookBuilder(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    /**
     * Adds a new {@code Client} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withClient(Client client) {
        clientManager.addClient(client);
        return this;
    }

    public ClientManager build() {
        return clientManager;
    }
}
