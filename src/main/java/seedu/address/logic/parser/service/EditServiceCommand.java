package seedu.address.logic.parser.service;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.service.Duration;
import seedu.address.model.service.Service;
import seedu.address.model.util.attributes.*;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_SERVICES;

/**
 * Edits the details of an existing service in SuperSalon.
 * EditServiceCommand does not allow users to edit the service code of services.
 */
public class EditServiceCommand extends Command {

    public static final String COMMAND_WORD = "editsvc";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the service identified "
            + "by the index number used in the displayed service list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_SERVICE_TITLE + " TITLE] "
            + "[" + PREFIX_SERVICE_DURATION + " DURATION] "
            + "[" + PREFIX_SERVICE_PRICE + " PRICE] "
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_SERVICE_DURATION + "1 "
            + PREFIX_SERVICE_PRICE + "45 ";

    public static final String MESSAGE_EDIT_SERVICE_SUCCESS = "Edited Service: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    private final Index index;
    private final EditServiceCommand.EditServiceDescriptor editServiceDescriptor;

    /**
     * @param index of the service in the filtered service list to edit
     * @param editServiceDescriptor details to edit the service with
     */
    public EditServiceCommand(Index index, EditServiceCommand.EditServiceDescriptor editServiceDescriptor) {
        requireNonNull(index);
        requireNonNull(editServiceDescriptor);

        this.index = index;
        this.editServiceDescriptor = new EditServiceCommand.EditServiceDescriptor(editServiceDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Service> lastShownList = model.getFilteredServiceList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_SERVICE_DISPLAYED_INDEX);
        }

        Service serviceToEdit = lastShownList.get(index.getZeroBased());
        Service editedService = createEditedService(serviceToEdit, editServiceDescriptor);

        if (serviceToEdit.isSame(editedService)) { // Used .isSame instead of .equals because .eqauls compares only ServiceCode
            throw new CommandException(MESSAGE_NOT_EDITED);
        }

        model.setService(serviceToEdit, editedService);
        model.updateFilteredServiceList(PREDICATE_SHOW_ALL_SERVICES);
        return new CommandResult(String.format(MESSAGE_EDIT_SERVICE_SUCCESS, editedService));
    }

    /**
     * Creates and returns a {@code Service} with the details of {@code serviceToEdit}
     * edited with {@code editServiceDescriptor}.
     */
    private static Service createEditedService(Service serviceToEdit,
                                               EditServiceCommand.EditServiceDescriptor editServiceDescriptor) {
        assert serviceToEdit != null;

        Title updatedTitle = editServiceDescriptor.getTitle().orElse(serviceToEdit.getTitle());
        Duration updatedDuration = editServiceDescriptor.getDuration().orElse(serviceToEdit.getDuration());
        Amount updatedAmount = editServiceDescriptor.getAmount().orElse(serviceToEdit.getAmount());

        return new Service(updatedTitle, updatedDuration, updatedAmount);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditServiceCommand)) {
            return false;
        }

        // state check
        EditServiceCommand e = (EditServiceCommand) other;
        return index.equals(e.index)
                && editServiceDescriptor.equals(e.editServiceDescriptor);
    }

    /**
     * Stores the details to edit the service with. Each non-empty field value will replace the
     * corresponding field value of the service.
     */
    public static class EditServiceDescriptor {
        private Title title;
        private Amount value;
        private Duration duration;

        public EditServiceDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditServiceDescriptor(EditServiceCommand.EditServiceDescriptor toCopy) {
            setTitle(toCopy.title);
            setAmount(toCopy.value);
            setDuration(toCopy.duration);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(title, value, duration);
        }

        public void setTitle(Title title) {
            this.title = title;
        }

        public Optional<Title> getTitle() {
            return Optional.ofNullable(title);
        }

        public void setAmount(Amount value) {
            this.value = value;
        }

        public Optional<Amount> getAmount() {
            return Optional.ofNullable(value);
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

        public Optional<Duration> getDuration() {
            return Optional.ofNullable(duration);
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditServiceCommand.EditServiceDescriptor)) {
                return false;
            }

            // state check
            EditServiceCommand.EditServiceDescriptor e = (EditServiceCommand.EditServiceDescriptor) other;

            return getTitle().equals(e.getTitle())
                    && getAmount().equals(e.getAmount())
                    && getDuration().equals(e.getDuration());
        }
    }
}
