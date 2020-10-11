package seedu.address.ui.revenuetab;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.revenue.Revenue;
import seedu.address.ui.UiPart;

public class RevenueListPanel extends UiPart<Region> {

    private static final String FXML = "RevenueListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(RevenueListPanel.class);

    @FXML
    private ListView<Revenue> revenueListView;

    /**
     * Creates a {@code RevenueListPanel} with the given {@code ObservableList}.
     */
    public RevenueListPanel(ObservableList<Revenue> revenueList) {
        super(FXML);
        revenueListView.setItems(revenueList);
        revenueListView.setCellFactory(listView -> new RevenueListPanel.RevenueListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Revenue} using a {@code RevenueCard}.
     */
    class RevenueListViewCell extends ListCell<Revenue> {

        @Override
        protected void updateItem(Revenue revenue, boolean empty) {
            super.updateItem(revenue, empty);

            if (empty || revenue == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new RevenueCard(revenue, getIndex() + 1).getRoot());
            }
        }
    }
}
