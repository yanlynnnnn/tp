package team.supersalon.model.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static team.supersalon.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import team.supersalon.model.client.exceptions.ClientNotFoundException;
import team.supersalon.model.client.exceptions.DuplicateClientException;
import team.supersalon.testutil.Assert;
import team.supersalon.testutil.ClientBuilder;
import team.supersalon.testutil.TypicalClients;

public class UniqueClientListTest {

    private final UniqueClientList uniqueClientList = new UniqueClientList();

    @Test
    public void contains_nullClient_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.contains(null));
    }

    @Test
    public void contains_clientNotInList_returnsFalse() {
        assertFalse(uniqueClientList.contains(TypicalClients.ALICE));
    }

    @Test
    public void contains_clientInList_returnsTrue() {
        uniqueClientList.add(TypicalClients.ALICE);
        assertTrue(uniqueClientList.contains(TypicalClients.ALICE));
    }

    @Test
    public void contains_clientWithSameIdentityFieldsInList_returnsTrue() {
        uniqueClientList.add(TypicalClients.ALICE);
        Client editedAlice = new ClientBuilder(TypicalClients.ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(uniqueClientList.contains(editedAlice));
    }

    @Test
    public void add_nullClient_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.add(null));
    }

    @Test
    public void add_duplicateClient_throwsDuplicateClientException() {
        uniqueClientList.add(TypicalClients.ALICE);
        Assert.assertThrows(DuplicateClientException.class, () -> uniqueClientList.add(TypicalClients.ALICE));
    }

    @Test
    public void setClient_nullTargetClient_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.setClient(null, TypicalClients.ALICE));
    }

    @Test
    public void setClient_nullEditedClient_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.setClient(TypicalClients.ALICE, null));
    }

    @Test
    public void setClient_targetClientNotInList_throwsClientNotFoundException() {
        Assert.assertThrows(ClientNotFoundException.class, () -> uniqueClientList.setClient(TypicalClients.ALICE,
                TypicalClients.ALICE));
    }

    @Test
    public void setClient_editedClientIsSameClient_success() {
        uniqueClientList.add(TypicalClients.ALICE);
        uniqueClientList.setClient(TypicalClients.ALICE, TypicalClients.ALICE);
        UniqueClientList expectedUniqueClientList = new UniqueClientList();
        expectedUniqueClientList.add(TypicalClients.ALICE);
        assertEquals(expectedUniqueClientList, uniqueClientList);
    }

    @Test
    public void setClient_editedClientHasSameIdentity_success() {
        uniqueClientList.add(TypicalClients.ALICE);
        Client editedAlice = new ClientBuilder(TypicalClients.ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        uniqueClientList.setClient(TypicalClients.ALICE, editedAlice);
        UniqueClientList expectedUniqueClientList = new UniqueClientList();
        expectedUniqueClientList.add(editedAlice);
        assertEquals(expectedUniqueClientList, uniqueClientList);
    }

    @Test
    public void setClient_editedClientHasDifferentIdentity_success() {
        uniqueClientList.add(TypicalClients.ALICE);
        uniqueClientList.setClient(TypicalClients.ALICE, TypicalClients.BOB);
        UniqueClientList expectedUniqueClientList = new UniqueClientList();
        expectedUniqueClientList.add(TypicalClients.BOB);
        assertEquals(expectedUniqueClientList, uniqueClientList);
    }

    @Test
    public void setClient_editedClientHasNonUniqueIdentity_throwsDuplicateClientException() {
        uniqueClientList.add(TypicalClients.ALICE);
        uniqueClientList.add(TypicalClients.BOB);
        Assert.assertThrows(DuplicateClientException.class, () -> uniqueClientList.setClient(TypicalClients.ALICE, TypicalClients.BOB));
    }

    @Test
    public void remove_nullClient_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.remove(null));
    }

    @Test
    public void remove_clientDoesNotExist_throwsClientNotFoundException() {
        Assert.assertThrows(ClientNotFoundException.class, () -> uniqueClientList.remove(TypicalClients.ALICE));
    }

    @Test
    public void remove_existingClient_removesClient() {
        uniqueClientList.add(TypicalClients.ALICE);
        uniqueClientList.remove(TypicalClients.ALICE);
        UniqueClientList expectedUniqueClientList = new UniqueClientList();
        assertEquals(expectedUniqueClientList, uniqueClientList);
    }

    @Test
    public void setClients_nullUniqueClientList_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.setClients((UniqueClientList) null));
    }

    @Test
    public void setClients_uniqueClientList_replacesOwnListWithProvidedUniqueClientList() {
        uniqueClientList.add(TypicalClients.ALICE);
        UniqueClientList expectedUniqueClientList = new UniqueClientList();
        expectedUniqueClientList.add(TypicalClients.BOB);
        uniqueClientList.setClients(expectedUniqueClientList);
        assertEquals(expectedUniqueClientList, uniqueClientList);
    }

    @Test
    public void setClients_nullList_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> uniqueClientList.setClients((List<Client>) null));
    }

    @Test
    public void setClients_list_replacesOwnListWithProvidedList() {
        uniqueClientList.add(TypicalClients.ALICE);
        List<Client> clientList = Collections.singletonList(TypicalClients.BOB);
        uniqueClientList.setClients(clientList);
        UniqueClientList expectedUniqueClientList = new UniqueClientList();
        expectedUniqueClientList.add(TypicalClients.BOB);
        assertEquals(expectedUniqueClientList, uniqueClientList);
    }

    @Test
    public void setClients_listWithDuplicateClients_throwsDuplicateClientException() {
        List<Client> listWithDuplicateClients = Arrays.asList(TypicalClients.ALICE, TypicalClients.ALICE);
        Assert.assertThrows(DuplicateClientException.class, () -> uniqueClientList.setClients(listWithDuplicateClients));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        Assert.assertThrows(UnsupportedOperationException.class, ()
            -> uniqueClientList.asUnmodifiableObservableList().remove(0));
    }
}
