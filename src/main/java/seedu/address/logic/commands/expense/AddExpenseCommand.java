package seedu.address.logic.commands.expense;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AMOUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ISFIXED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.expense.Expense;

/**
 * Adds an expense to GrAB3.
 */
public class AddExpenseCommand extends Command {

    public static final String COMMAND_WORD = "addexpense";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an expense to GrAB3. "
            + "Parameters: "
            + PREFIX_DESCRIPTION + "DESCRIPTION "
            + PREFIX_ISFIXED + "ISFIXED "
            + PREFIX_AMOUNT + "VALUE "
            + PREFIX_DATE + "DATE "
            + PREFIX_TAG + "TAG "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DESCRIPTION + "Conditioner "
            + PREFIX_ISFIXED + "f "
            + PREFIX_AMOUNT + "15.00 "
            + PREFIX_DATE + "29-01-2020 "
            + PREFIX_TAG + "hair supplies ";

    public static final String MESSAGE_SUCCESS = "New expense added: %1$s";

    private final Expense toAdd;

    /**
     * Creates an AddExpenseommand to add the specified {@code Expense}
     */
    public AddExpenseCommand(Expense expense) {
        requireNonNull(expense);
        toAdd = expense;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.addExpense(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }
}
