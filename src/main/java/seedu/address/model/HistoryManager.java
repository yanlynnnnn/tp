package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.LinkedList;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.UndoCommand;

/**
 * Holds all the previous states of Homerce's storage.
 *
 * A new HistoryManager is initialized upon each start up of Homerce.
 */
public class HistoryManager {
    private LinkedList<Model> models;

    public HistoryManager(Model model) {
        requireNonNull(model);
        LinkedList<Model> models = new LinkedList<>();
        models.add(model);
        this.models = models;
    }

    public void addToHistory(Model model, Command command) {
        if (!(command instanceof UndoCommand)) {
            Model modelDeepCopy = model.deepCopy();
            models.addLast(modelDeepCopy);
        }
    }

    public Model getPreviousState() {
        return models.pollLast();
    }
}
