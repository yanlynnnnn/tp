package team.supersalon.logic.commands;

import static team.supersalon.logic.commands.CommandTestUtil.assertCommandSuccess;
import static team.supersalon.logic.commands.CommandTestUtil.showClientAtIndex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import team.supersalon.model.Model;
import team.supersalon.model.ModelManager;
import team.supersalon.model.UserPrefs;
import team.supersalon.testutil.TypicalClients;
import team.supersalon.testutil.TypicalIndexes;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(TypicalClients.getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showClientAtIndex(model, TypicalIndexes.INDEX_FIRST_CLIENT);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
