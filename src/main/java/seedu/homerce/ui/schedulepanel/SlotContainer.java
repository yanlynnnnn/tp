package seedu.homerce.ui.schedulepanel;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.homerce.ui.UiPart;

/**
 * A UI Component that that constitutes a region of a calendar view.
 */
public abstract class SlotContainer extends UiPart<Region> {

    public static final double WIDTH_SCALING_FACTOR = 120; // Value chosen to fit within the screen

    @FXML
    protected HBox slotPane;

    public SlotContainer(String fxml, double hours) {
        super(fxml);
        slotPane.setPrefWidth(WIDTH_SCALING_FACTOR);
    }
}