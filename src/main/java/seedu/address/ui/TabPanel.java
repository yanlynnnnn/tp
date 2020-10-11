package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.client.Client;
import seedu.address.model.service.Service;
import seedu.address.ui.servicetab.ServiceListPanel;

/**
 * Panel containing the list of persons.
 */
public class TabPanel extends UiPart<Region> {
    private static final String FXML = "TabPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TabPanel.class);

    @FXML
    private StackPane clientListPanelPlaceholder;

    @FXML
    private StackPane serviceListPanelPlaceholder;

    public TabPanel(ObservableList<Client> clientList,
                    ObservableList<Service> serviceList
    ) {
        super(FXML);
        clientListPanelPlaceholder.getChildren().add(new ClientListPanel(clientList).getRoot());
        serviceListPanelPlaceholder.getChildren().add(new ServiceListPanel(serviceList).getRoot());
    }
}
