package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;

import java.util.function.Consumer;
import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.servicetab.ServiceListPanel;

/**
 * Panel containing the list of persons.
 */
public class SideTabsBar extends UiPart<Region> {
    private static final String FXML = "SideTabsBar.fxml";

    private final Logger logger = LogsCenter.getLogger(SideTabsBar.class);

    private Consumer<String> consumer;

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
}