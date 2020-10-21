package seedu.homerce.model.undo;

import seedu.homerce.logic.commands.Command;
import seedu.homerce.model.Model;

/**
 * Contains information of the state of Homerce at a particular time instance.
 */
public class History {
    /** State of storage of Homerce */
    private final Model model;
    /** Command that caused the change to Homerce's state */
    private final Command command;

    public History(Model model, Command command) {
        this.model = model;
        this.command = command;
    }

    public Model getModel() {
        return this.model;
    }

    public Command getCommand() {
        return this.command;
    }
}
