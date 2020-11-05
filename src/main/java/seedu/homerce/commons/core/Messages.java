package seedu.homerce.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_CLIENT_DISPLAYED_INDEX = "The client index provided is invalid";
    public static final String MESSAGE_CLIENTS_LISTED_OVERVIEW = "%1$d clients listed!";
    public static final String MESSAGE_INVALID_EXPENSE_DISPLAYED_INDEX = "The expense index provided is invalid";
    public static final String MESSAGE_EXPENSES_LISTED_OVERVIEW = "%1$d expenses listed!";
    public static final String MESSAGE_SERVICES_LISTED_OVERVIEW = "%1$d services listed!";
    public static final String MESSAGE_REVENUE_LISTED_OVERVIEW = "%1$d revenue listed!";
    public static final String MESSAGE_INVALID_APPOINTMENT_DISPLAYED_INDEX = "The appointment index provided is "
            + "invalid";
    public static final String MESSAGE_MULTIPLE_PARAMETERS = "Please only input one parameter";
    public static final String MESSAGE_APPOINTMENTS_LISTED_OVERVIEW = "%1$d appointments listed!";
    public static final String MESSAGE_APPOINTMENT_ALREADY_DONE = "This appointment is already marked as done!";
    public static final String MESSAGE_APPOINTMENT_ALREADY_UNDONE = "This appointment is already marked as not done!";
    public static final String MESSAGE_DUPLICATE_APPOINTMENT = "This appointment already exists in the homerce.";
    public static final String MESSAGE_INVALID_PHONE = "The phone number does not refer to an existing client.";
    public static final String MESSAGE_INVALID_SERVICE_CODE = "The service code specified does not exist in Homerce.";
    public static final String MESSAGE_CLIENT_INVALID_DELETION = "The client you want to delete is being scheduled"
            + " today or at a future appointment, it cannot be deleted.";

    // ============== Service related messages ===========
    public static final String MESSAGE_INVALID_SERVICE_DISPLAYED_INDEX = "The service index provided is invalid";
    public static final String MESSAGE_SERVICES_INVALID_SERVICE_DISPLAYED_INDEX = "The service index "
            + "provided is invalid";
    public static final String MESSAGES_SERVICES_INVALID_DELETION = "The service you want to delete is being scheduled"
            + " today or at a future appointment, it cannot be deleted.";
}
