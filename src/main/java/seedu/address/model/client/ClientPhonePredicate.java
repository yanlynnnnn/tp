package seedu.address.model.client;

import java.util.function.Predicate;


public class ClientPhonePredicate implements Predicate<Client> {
    private final Phone phoneOfClient;

    public ClientPhonePredicate(Phone phone) {
        this.phoneOfClient = phone;
    }

    @Override
    public boolean test(Client client) {
        return phoneOfClient.equals(client.getPhone());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ClientPhonePredicate // instanceof handles nulls
            && phoneOfClient.equals(((ClientPhonePredicate) other).phoneOfClient)); // state check
    }
}
