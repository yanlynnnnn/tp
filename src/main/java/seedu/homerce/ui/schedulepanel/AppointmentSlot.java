package seedu.homerce.ui.schedulepanel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.homerce.model.appointment.Appointment;

/**
 * A region of a calendar view that represents a single slot.
 */
public class AppointmentSlot extends SlotContainer {

    private static final String FXML = "schedulepanel/AppointmentSlot.fxml";

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

    /**
     * Constructor that creates a slot to be added to the schedule with relevant appointment information.
     */
    public AppointmentSlot(Appointment appointment) {
        super(FXML);

        this.clientName = appointment.getClient().getName().fullName;
        this.dateText = appointment.getAppointmentDate().toString();
        this.timeText = appointment.getAppointmentStartTime().getTime().toString();
        this.descriptionText = appointment.getService().getTitle().value;

        setText();
    }

    private void setText() {
        title.setText(clientName);
        time.setText(timeText);
        description.setText(descriptionText);
    }
}
