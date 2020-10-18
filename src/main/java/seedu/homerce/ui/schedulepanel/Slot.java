package seedu.homerce.ui.schedulepanel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.homerce.model.appointment.Appointment;

/**
 * A region of a calendar view that represents a single slot.
 */
public class Slot extends SlotContainer {

    private static final String FXML = "schedulepanel/Slot.fxml";

    private String idText;
    private String dateText;
    private String timeText;
    private String descriptionText;

    @FXML
    private Label id;

    @FXML
    private Label time;

    @FXML
    private Label description;

    public Slot(Appointment appointment, int displayedIndex) {
        super(FXML, 60);

        this.idText = "1";
        this.dateText = "2020";
        this.timeText = "9am";
        this.descriptionText = "Lorem";

        setText();
    }

    private void setText() {
        id.setText(idText);
        time.setText(timeText);
        description.setText(descriptionText);
    }
}