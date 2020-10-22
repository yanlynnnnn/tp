package seedu.homerce.model.appointment.predicate;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.function.Predicate;

import seedu.homerce.model.appointment.Appointment;

public class AppointmentPaginationPredicate implements Predicate<Appointment> {

    private final LocalDate startOfWeekDate;
    private final LocalDate endOfWeekDate;

    /**
     * Creates a Predicate that filters appointments such that only those in the same week as
     * {@code referenceDate} will be displayed.
     */
    public AppointmentPaginationPredicate(Calendar calendar) {
        requireNonNull(calendar);
        this.startOfWeekDate = calculateStartDateOfWeek(calendar);
        this.endOfWeekDate = calculateEndDateOfWeek(calendar);
    }

    @Override
    public boolean test(Appointment appointment) {
        return (startOfWeekDate.isBefore(appointment.getAppointmentDate().getLocalDate())
            || startOfWeekDate.isEqual(appointment.getAppointmentDate().getLocalDate()))
            && (endOfWeekDate.isAfter(appointment.getAppointmentDate().getLocalDate())
            || endOfWeekDate.isEqual(appointment.getAppointmentDate().getLocalDate()));
    }

    private LocalDate calculateStartDateOfWeek(Calendar inputCalendar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputCalendar.getTime());
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDate.ofInstant(calendar.toInstant(), zid);
    }

    private LocalDate calculateEndDateOfWeek(Calendar inputCalendar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputCalendar.getTime());
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDate.ofInstant(calendar.toInstant(), zid);
    }
}
