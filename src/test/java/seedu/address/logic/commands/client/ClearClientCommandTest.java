package seedu.address.logic.commands.client;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.manager.AppointmentManager;
import seedu.address.model.manager.ExpenseTracker;
import seedu.address.model.manager.RevenueTracker;
import seedu.address.model.manager.ServiceManager;

public class ClearClientCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearClientCommand(), model, ClearClientCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(new UserPrefs(), getTypicalAddressBook(), new ServiceManager(),
            new RevenueTracker(), new ExpenseTracker(), new AppointmentManager());
        Model expectedModel = new ModelManager(new UserPrefs(), getTypicalAddressBook(), new ServiceManager(),
            new RevenueTracker(), new ExpenseTracker(), new AppointmentManager());
        expectedModel.setAddressBook(new AddressBook());

        assertCommandSuccess(new ClearClientCommand(), model, ClearClientCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
