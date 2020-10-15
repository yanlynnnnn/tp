package seedu.homerce.model.client;

import java.util.function.Predicate;

public class ClientNamePredicate implements Predicate<Client> {
    private final Name clientName;

    public ClientNamePredicate(Name clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean test(Client client) {
        // As long as part of the client's name matches, it is a match.
        return client.getName().fullName.toLowerCase()
            .contains(clientName.fullName.toLowerCase());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ClientNamePredicate// instanceof handles nulls
            && clientName.equals(((ClientNamePredicate) other).clientName)); // state check
    }
}
