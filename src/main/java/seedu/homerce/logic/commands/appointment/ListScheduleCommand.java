package seedu.homerce.logic.commands.appointment;

import seedu.homerce.logic.commands.Command;
import seedu.homerce.logic.commands.CommandResult;
import seedu.homerce.logic.commands.exceptions.CommandException;
import seedu.homerce.model.Model;
import seedu.homerce.model.manager.HistoryManager;
import seedu.homerce.ui.schedulepanel.SchedulePanel;

public class ListScheduleCommand extends Command {

    public static final String COMMAND_WORD = "schedule";
    private static final String MESSAGE_LIST_SCHEDULE_SUCCESS = "Navigated to schedule tab.";

    @Override
    public CommandResult execute(Model model, HistoryManager historyManager) throws CommandException {
        return new CommandResult(MESSAGE_LIST_SCHEDULE_SUCCESS, SchedulePanel.TAB_NAME);
    }
}
