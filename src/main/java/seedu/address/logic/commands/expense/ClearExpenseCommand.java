package seedu.address.logic.commands.expense;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.manager.ExpenseTracker;

/**
 * Clears the expense list.
 */
public class ClearExpenseCommand extends Command {

    public static final String COMMAND_WORD = "clearexp";
    public static final String MESSAGE_SUCCESS = "Expense List has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setExpenseTracker(new ExpenseTracker());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
