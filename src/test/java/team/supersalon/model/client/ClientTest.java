package team.supersalon.model.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static team.supersalon.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static team.supersalon.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static team.supersalon.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static team.supersalon.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static team.supersalon.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import team.supersalon.testutil.ClientBuilder;
import team.supersalon.testutil.Assert;
import team.supersalon.testutil.TypicalClients;

public class ClientTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Client client = new ClientBuilder().build();
        Assert.assertThrows(UnsupportedOperationException.class, () -> client.getTags().remove(0));
    }

    @Test
    public void isSameClient() {
        // same object -> returns true
        assertTrue(TypicalClients.ALICE.isSameClient(TypicalClients.ALICE));

        // null -> returns false
        assertFalse(TypicalClients.ALICE.isSameClient(null));

        // different phone and email -> returns false
        Client editedAlice = new ClientBuilder(TypicalClients.ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(TypicalClients.ALICE.isSameClient(editedAlice));

        // different name -> returns false
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(TypicalClients.ALICE.isSameClient(editedAlice));

        // same name, same phone, different attributes -> returns true
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withEmail(VALID_EMAIL_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(TypicalClients.ALICE.isSameClient(editedAlice));

        // same name, same email, different attributes -> returns true
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withPhone(VALID_PHONE_BOB)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(TypicalClients.ALICE.isSameClient(editedAlice));

        // same name, same phone, same email, different attributes -> returns true
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(TypicalClients.ALICE.isSameClient(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Client aliceCopy = new ClientBuilder(TypicalClients.ALICE).build();
        assertTrue(TypicalClients.ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(TypicalClients.ALICE.equals(TypicalClients.ALICE));

        // null -> returns false
        assertFalse(TypicalClients.ALICE.equals(null));

        // different type -> returns false
        assertFalse(TypicalClients.ALICE.equals(5));

        // different client -> returns false
        assertFalse(TypicalClients.ALICE.equals(TypicalClients.BOB));

        // different name -> returns false
        Client editedAlice = new ClientBuilder(TypicalClients.ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(TypicalClients.ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(TypicalClients.ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(TypicalClients.ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new ClientBuilder(TypicalClients.ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(TypicalClients.ALICE.equals(editedAlice));
    }
}
