package seedu.address.ui;

import java.util.function.Consumer;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.appointmentpanel.AppointmentListPanel;
import seedu.address.ui.clientpanel.ClientListPanel;
import seedu.address.ui.revenuepanel.RevenueListPanel;
import seedu.address.ui.servicepanel.ServiceListPanel;

/**
 * Panel containing the list of tabs.
 */
public class SideTabsBar extends UiPart<Region> {
    private static final String FXML = "SideTabsBar.fxml";

    private final Logger logger = LogsCenter.getLogger(SideTabsBar.class);

    private Consumer<String> consumer;

    /**
     * Constructor for SideTabsBar
     *
     * @param consumer
     */
    public SideTabsBar(Consumer<String> consumer) {
        super(FXML);
        this.consumer = consumer;
    }

    @FXML
    private void handleSwitchToClientTab() {
        consumer.accept(ClientListPanel.TAB_NAME);
    }

    @FXML
    private void handleSwitchToServiceTab() {
        consumer.accept(ServiceListPanel.TAB_NAME);
    }

    @FXML
    private void handleSwitchToAppointmentTab() {
        consumer.accept(AppointmentListPanel.TAB_NAME);
    }

    @FXML
    private void handleSwitchToRevenueTab() {
        consumer.accept(RevenueListPanel.TAB_NAME);
    }

    //    @FXML
    //    private void handleSwitchToExpenseTab() {
    //        consumer.accept(ExpenseListPanel.TAB_NAME);
    //    }
}
