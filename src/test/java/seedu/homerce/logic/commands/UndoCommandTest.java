package seedu.homerce.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.homerce.logic.commands.client.AddClientCommandTest;
import seedu.homerce.model.manager.ReadOnlyRevenueTracker;
import seedu.homerce.model.manager.RevenueTracker;
import seedu.homerce.model.revenue.Revenue;

public class UndoCommandTest {

    @Test
    public void constructor_nullRevenue_throwsNullPointerException() {

    }

    @Test
    public void constructor_nullModel_throwsNullPointerException() {

    }

    @Test
    public void execute_latestChange_throwsCommandException() {

    }

    @Test
    public void execute_validUndo_successfulUndo() {

    }

    @Test
    public void equals() {

    }

    /**
     * A Model stub that always accepts the expense being added.
     */
    private class ModelStubAcceptingRevenueAdded extends AddClientCommandTest.ModelStub {

        final ArrayList<Revenue> revenuesAdded = new ArrayList<>();

        @Override
        public void addRevenue(Revenue revenue) {
            requireNonNull(revenue);
            revenuesAdded.add(revenue);
        }

        @Override
        public ReadOnlyRevenueTracker getRevenueTracker() {
            return new RevenueTracker();
        }
    }
}
