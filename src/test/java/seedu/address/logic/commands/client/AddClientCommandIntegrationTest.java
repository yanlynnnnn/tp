package seedu.address.logic.commands.client;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalClients.getTypicalClientManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.client.Client;
import seedu.address.model.manager.AppointmentManager;
import seedu.address.model.manager.ExpenseTracker;
import seedu.address.model.manager.RevenueTracker;
import seedu.address.model.manager.ServiceManager;
import seedu.address.testutil.ClientBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddClientCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(new UserPrefs(), getTypicalClientManager(), new ServiceManager(),
                new RevenueTracker(), new ExpenseTracker(), new AppointmentManager());
    }

    @Test
    public void execute_newClient_success() {
        Client validClient = new ClientBuilder().build();

        Model expectedModel = new ModelManager(new UserPrefs(), model.getClientManager(), new ServiceManager(),
            new RevenueTracker(), new ExpenseTracker(), new AppointmentManager());
        expectedModel.addClient(validClient);

        assertCommandSuccess(new AddClientCommand(validClient), model,
                String.format(AddClientCommand.MESSAGE_SUCCESS, validClient), expectedModel);
    }

    @Test
    public void execute_duplicateClient_throwsCommandException() {
        Client clientInList = model.getClientManager().getClientList().get(0);
        assertCommandFailure(new AddClientCommand(clientInList), model, AddClientCommand.MESSAGE_DUPLICATE_CLIENT);
    }

}
