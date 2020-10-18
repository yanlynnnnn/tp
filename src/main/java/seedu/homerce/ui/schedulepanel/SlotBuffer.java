package seedu.homerce.ui.schedulepanel;

import java.time.LocalTime;

/**
 * A region in the schedule that acts a buffer between other regions.
 */
public class SlotBuffer extends SlotContainer {

    private static final String FXML = "schedulepanel/SlotBuffer.fxml";

    public SlotBuffer(LocalTime start, LocalTime end) {
        super(FXML, 2);
    }
}