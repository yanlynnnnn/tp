
package seedu.homerce.ui.schedulepanel;

import com.sun.javafx.collections.ImmutableObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
        // gridPane.setGridLinesVisible(true);
        for (int i = 0; i < 48; i++) {
            ColumnConstraints con = new ColumnConstraints();
            con.setPrefWidth(120);
            gridPane.getColumnConstraints().add(con);
        }

        if (appointments.size() == 0) {
            return;
        }

        int rowIndex = 0;
        int colIndex = 0;
        // boolean nextIncrement = false;
        // int addBy = 0;

        LocalDate prevAppointmentDate = appointments.get(0).getAppointmentDate().getLocalDate();
        Appointment apt0 = appointments.get(0);
        Appointment apt1 = appointments.get(1);
        Appointment apt2 = appointments.get(2);
        Appointment apt3 = appointments.get(3);
        Appointment apt4 = appointments.get(4);
        Appointment apt5 = appointments.get(5);
        Appointment apt6 = appointments.get(6);
        Appointment apt7 = appointments.get(7);
        Appointment apt8 = appointments.get(8);
        Appointment apt9 = appointments.get(9);
        Slot s0 = new Slot(apt0, 0);
        Slot s1 = new Slot(apt1, 0);
        Slot s2 = new Slot(apt2, 0);
        Slot s3 = new Slot(apt3, 0);
        Slot s4 = new Slot(apt4, 0);
        Slot s5 = new Slot(apt5, 0);
        Slot s6 = new Slot(apt6, 0);
        Slot s7 = new Slot(apt7, 0);
        Slot s8 = new Slot(apt8, 0);
        Slot s9 = new Slot(apt9, 0);

        gridPane.add(s0.getRoot(), 9, 0, 1, 1);

        gridPane.add(s1.getRoot(), 4, 1, 2, 1);

        gridPane.add(s2.getRoot(), 4, 2, 3, 1);
        gridPane.add(s3.getRoot(), 15, 2, 4, 1);
        gridPane.add(s4.getRoot(), 21, 2, 3, 1);
        gridPane.add(s5.getRoot(), 25, 2, 2, 1);

        gridPane.add(s6.getRoot(), 9, 3, 3, 1);
        gridPane.add(s7.getRoot(), 15, 3, 1, 1);
        gridPane.add(s8.getRoot(), 21, 3, 2, 1);
        gridPane.add(s9.getRoot(), 11, 4, 4, 1);

        /*for (int i = 0; i < appointments.size(); i++) {
            Appointment curr = appointments.get(i);
            LocalDate currAppointmentDate = curr.getAppointmentDate().getLocalDate();
            Slot slot = new Slot(curr, i);


            if (isSameDate(prevAppointmentDate, currAppointmentDate)) {
                if (i != 0) {
                    colIndex++;
                }
            }

            if (!isSameDate(prevAppointmentDate, currAppointmentDate)) {
                rowIndex++;
                prevAppointmentDate = currAppointmentDate;
                colIndex = 0;
            }

            int colSpan = getColSpan(curr.getService().getDuration());
            curr.getAppointmentEndTime();
            colIndex = nextIncrement ? colIndex + addBy : colIndex;
            if (curr.getService().getDuration().value == 0.5) {
                gridPane.add(slot.getRoot(), colIndex, rowIndex, 1, 1);
                nextIncrement = false;
            } else if (curr.getService().getDuration().value == 1.0) {
                gridPane.add(slot.getRoot(), colIndex, rowIndex, 2, 1);
                nextIncrement = true;
                addBy = 2;
            } else if (curr.getService().getDuration().value == 1.5) {
                gridPane.add(slot.getRoot(), colIndex, rowIndex, 3, 1);
                nextIncrement = true;
                addBy = 3;
            } else if (curr.getService().getDuration().value == 2.0) {
                gridPane.add(slot.getRoot(), colIndex, rowIndex, 4, 1);
                nextIncrement = true;
                addBy = 4;
            }
        }
        */
    }

    private int getColSpan(Duration duration) {
        // Service timings are in 0.5 hours so multiplication by an even SCALE_FACTOR will always give an a whole number
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
