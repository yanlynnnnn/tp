package seedu.address.model.service.uniquelist;

/**
 * API of an item in a UniqueList.
 */
public interface UniqueListItem {
    boolean isSame(UniqueListItem other);
}
