package seedu.homerce.model.client.predicate;

import java.util.function.Predicate;

import seedu.homerce.model.client.Client;
import seedu.homerce.model.client.Name;

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
