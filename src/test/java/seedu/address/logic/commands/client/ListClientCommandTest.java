package seedu.address.logic.commands.client;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showClientAtIndex;
import static seedu.address.testutil.TypicalClients.getTypicalAddressBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_CLIENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.manager.AppointmentManager;
import seedu.address.model.manager.ExpenseTracker;
import seedu.address.model.manager.RevenueTracker;
import seedu.address.model.manager.ServiceManager;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListClientCommand.
 */
public class ListClientCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(new UserPrefs(), getTypicalAddressBook(), new ServiceManager(), new RevenueTracker(),
            new ExpenseTracker(), new AppointmentManager());
        expectedModel = new ModelManager(new UserPrefs(), model.getAddressBook(),
                new ServiceManager(), new RevenueTracker(), new ExpenseTracker(), new AppointmentManager());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListClientCommand(), model, ListClientCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showClientAtIndex(model, INDEX_FIRST_CLIENT);
        assertCommandSuccess(new ListClientCommand(), model, ListClientCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
