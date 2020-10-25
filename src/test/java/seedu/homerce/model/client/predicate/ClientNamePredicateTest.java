package seedu.homerce.model.client.predicate;

import org.junit.jupiter.api.Test;
import seedu.homerce.model.client.Name;
import seedu.homerce.testutil.ClientBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientNamePredicateTest {

    @Test
    public void equals() {
        Name firstName = new Name("Alice");
        Name secondName = new Name("Bob");

        ClientNamePredicate firstPredicate = new ClientNamePredicate(firstName);
        ClientNamePredicate secondPredicate = new ClientNamePredicate(secondName);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ClientNamePredicate firstPredicateCopy = new ClientNamePredicate(firstName);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different client -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_clientContainsName_returnsTrue() {
        Name Name = new Name("Alice");

        ClientNamePredicate predicate = new ClientNamePredicate(Name);
        assertTrue(predicate.test(new ClientBuilder().withName("Alice").build()));
        assertTrue(predicate.test(new ClientBuilder().withName("Alice Lim").build()));

    }

    @Test
    public void test_clientContainsName_returnsFalse() {
        Name Name = new Name("Alice");

        ClientNamePredicate predicate = new ClientNamePredicate(Name);
        assertFalse(predicate.test(new ClientBuilder().withName("Bob").build()));

    }
}
