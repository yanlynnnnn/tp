package seedu.address.logic.commands.expense;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.expense.Expense;

/**
 * Clears the expense list.
 */
public class ClearExpenseCommand extends Command {

    public static final String COMMAND_WORD = "clearexp";
    public static final String MESSAGE_SUCCESS = "Expense List has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setExpenses(new ArrayList<>());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
