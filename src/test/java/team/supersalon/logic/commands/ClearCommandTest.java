package team.supersalon.logic.commands;

import static team.supersalon.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import team.supersalon.model.AddressBook;
import team.supersalon.model.Model;
import team.supersalon.model.ModelManager;
import team.supersalon.model.UserPrefs;
import team.supersalon.testutil.TypicalClients;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(TypicalClients.getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(TypicalClients.getTypicalAddressBook(), new UserPrefs());
        expectedModel.setAddressBook(new AddressBook());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
