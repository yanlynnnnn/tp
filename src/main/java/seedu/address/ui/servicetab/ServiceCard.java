package seedu.address.ui.servicetab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.service.Service;
import seedu.address.ui.UiPart;

/**
 * An UI component that displays information of a {@code Service}.
 */
public class ServiceCard extends UiPart<Region> {

    private static final String FXML = "ServiceListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable titles cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Service service;

    @FXML
    private HBox cardPane;
    @FXML
    private Label title;
    @FXML
    private Label id;
    @FXML
    private Label duration;
    @FXML
    private Label price;

    /**
     * Creates a {@code ServiceCode} with the given {@code Service} and index to display.
     */
    public ServiceCard(Service service, int displayedIndex) {
        super(FXML);
        this.service = service;
        id.setText(displayedIndex + ". ");
        title.setText(service.getTitle().value);
        duration.setText(String.valueOf(service.getDuration().value));
        price.setText(String.valueOf(service.getAmount().value));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ServiceCard)) {
            return false;
        }

        // state check
        ServiceCard card = (ServiceCard) other;
        return id.getText().equals(card.id.getText())
                && service.equals(card.service);
    }
}
