
package seedu.homerce.ui.schedulepanel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import seedu.homerce.commons.core.LogsCenter;
import seedu.homerce.model.appointment.Appointment;
import seedu.homerce.model.service.Duration;
import seedu.homerce.model.util.attributes.Date;
import seedu.homerce.ui.UiPart;

/**
 * Panel containing list of Appointments.
 */
public class SchedulePanel extends UiPart<Region> {
    public static final String TAB_NAME = "Schedule";

    private static final double SCALE_FACTOR = 4.0;
    private static final String FXML = "schedulepanel/SchedulePanel.fxml";
    private final Logger logger = LogsCenter.getLogger(seedu.homerce.ui.schedulepanel.SchedulePanel.class);

    private final ObservableList<Appointment> appointments;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane gridPane;

    /**
     * Creates a {@code AppointmentListPanel} with the given {@code ObservableList}.
     */
    public SchedulePanel(ObservableList<Appointment> appointments) {
        super(FXML);
        this.appointments = appointments;
    }

    /**
     * Fills the grid pane with the slots.
     */
    public void construct() {
        if (appointments.size() == 0) {
            return;
        }

        int rowIndex = 0;
        LocalDate initAppointmentDate = appointments.get(0).getAppointmentDate().getLocalDate();

        for (int i = 0; i < appointments.size(); i++) {
            Appointment curr = appointments.get(i);
            LocalDate currAppointmentDate = curr.getAppointmentDate().getLocalDate();
            Slot slot = new Slot(curr, i);
            int colSpan = getColSpan(curr.getService().getDuration());

            if (!isSameDate(initAppointmentDate, currAppointmentDate)) {
                rowIndex++;
                initAppointmentDate = currAppointmentDate;
            }
            gridPane.add(slot.getRoot(), i, rowIndex, colSpan, 1);
        }
    }

    private int getColSpan(Duration duration) {
        // Duration of service are by 0.5 hours so multiplication by 4 will always give an integer
        return (int) (duration.value * SCALE_FACTOR);
    }

    private boolean isSameDate(LocalDate currDate, LocalDate next) {
        // Dates are sorted so next will only be after or the same as currDate
        assert !next.isBefore(currDate): "Dates not sorted properly";
        if (next.isAfter(currDate)) {
            return false;
        }
        return true;
    }

}
