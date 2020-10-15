package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.LinkedList;
import java.util.List;

/**
 * Holds all the previous states of Homerce's storage.
 *
 * A new HistoryManager is initialized upon each start up of Homerce.
 */
public class HistoryManager {
    private List<Model> models;

    public HistoryManager(Model model) {
        requireNonNull(model);
        List<Model> models = new LinkedList<>();
        models.add(model);
        this.models = models;
    }

}
