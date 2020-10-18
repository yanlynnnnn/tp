package seedu.homerce.ui.schedulepanel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.homerce.model.appointment.Appointment;

/**
 * A region of a calendar view that represents a single slot.
 */
public class Slot extends SlotContainer {

    private static final String FXML = "schedulepanel/Slot.fxml";

    private String clientName;
    private String dateText;
    private String timeText;
    private String descriptionText;

    @FXML
    private Label title;

    @FXML
    private Label time;

    @FXML
    private Label description;

    public Slot(Appointment appointment, int displayedIndex) {
        super(FXML, appointment.getService().getDuration().value);

        this.clientName = appointment.getClient().getName().fullName;
        this.dateText = appointment .getAppointmentDate().toString();
        this.timeText = appointment.getAppointmentTime().getTime().toString();
        this.descriptionText = appointment.getService().getTitle().value;

        setText();
    }

    private void setText() {
        title.setText(clientName);
        time.setText(timeText);
        description.setText(descriptionText);
    }
}