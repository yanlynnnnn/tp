
package seedu.homerce.ui.schedulepanel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import seedu.homerce.commons.core.LogsCenter;
import seedu.homerce.model.appointment.Appointment;
import seedu.homerce.model.service.Duration;
import seedu.homerce.ui.UiPart;

/**
 * Panel containing list of Appointments.
 */
public class SchedulePanel extends UiPart<Region> {
    public static final String TAB_NAME = "Schedule";

    private static final double SCALE_FACTOR = 2.0;
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
        gridPane.setGridLinesVisible(true);

        // Creates 48 0.5h columns in the grid with fixed width
        for (int i = 0; i < 48; i++) {
            ColumnConstraints con = new ColumnConstraints();
            con.setPrefWidth(120);
            gridPane.getColumnConstraints().add(con);
        }
        int rowIndex = 0;
        LocalDate prevAppointmentDate = appointments.get(0).getAppointmentDate().getLocalDate();

        for (int i = 0; i < appointments.size(); i++) {
            Appointment curr = appointments.get(i);
            LocalDate currAppointmentDate = curr.getAppointmentDate().getLocalDate();
            Slot slot = new Slot(curr, i);

            if (!isSameDate(prevAppointmentDate, currAppointmentDate)) {
                rowIndex++;
                prevAppointmentDate = currAppointmentDate;
            }
            int colIndex = getColIndex(curr.getAppointmentStartTime().getTime());
            int colSpan = getColSpan(curr.getService().getDuration());
            curr.getAppointmentEndTime();
            gridPane.add(slot.getRoot(), colIndex, rowIndex, colSpan, 1);
        }
    }

    private int getColSpan(Duration duration) {
        // Service timings are in 0.5 hours so multiplication by an even SCALE_FACTOR will always give an a whole number
        return (int) (duration.value * SCALE_FACTOR);
    }

    private int getColIndex(LocalTime startTime) {
        int colIndex = startTime.getHour() * (int) SCALE_FACTOR;
        if (startTime.getMinute() != 0) {
            // Account for 0.5h in the schedule
            colIndex += 1;
        }
        // Accoutn for 0 index
        return colIndex - 1;
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
