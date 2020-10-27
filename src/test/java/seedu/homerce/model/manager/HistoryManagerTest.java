package seedu.homerce.model.manager;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.homerce.testutil.service.TypicalServices.MANICURE;

import java.time.Month;
import java.time.Year;

import org.junit.jupiter.api.Test;

import seedu.homerce.logic.commands.BreakdownFinanceCommand;
import seedu.homerce.logic.commands.schedule.CustomWeekCommand;
import seedu.homerce.logic.commands.service.AddServiceCommand;
import seedu.homerce.logic.commands.service.ListServiceCommand;
import seedu.homerce.model.Model;
import seedu.homerce.model.ModelManager;
import seedu.homerce.model.util.attributes.Date;

public class HistoryManagerTest {

    @Test
    public void addToHistory() {
        Model modelTest = new ModelManager();
        HistoryManager historyTest = HistoryManager.getInstance();
        AddServiceCommand commandTest = new AddServiceCommand(MANICURE);
        ListServiceCommand listServiceCommandTest = new ListServiceCommand();

        historyTest.addToHistory(modelTest, commandTest);

        assertTrue(historyTest.getPreviousHistory().getCommand().equals(commandTest));

        // List command will not be added to history -> throw exception when poll
        historyTest.addToHistory(modelTest, listServiceCommandTest);

        BreakdownFinanceCommand breakdownFinanceCommand = new BreakdownFinanceCommand(Month.of(12),
            Year.of(2020));

        historyTest.addToHistory(modelTest, breakdownFinanceCommand);
        assertThrows(NullPointerException.class, () -> historyTest.getPreviousHistory().getCommand());

        CustomWeekCommand customWeekCommandTest = new CustomWeekCommand(new Date("02-02-2020"));
        historyTest.addToHistory(modelTest, customWeekCommandTest);
        assertThrows(NullPointerException.class, () -> historyTest.getPreviousHistory().getCommand());
    }
}
