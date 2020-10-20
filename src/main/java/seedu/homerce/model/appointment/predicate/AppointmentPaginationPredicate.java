package seedu.homerce.model.appointment.predicate;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.function.Predicate;

import seedu.homerce.model.appointment.Appointment;
import seedu.homerce.model.util.attributes.Date;

public class AppointmentPaginationPredicate implements Predicate<Appointment> {

    private Date date;

    public AppointmentPaginationPredicate(Date date) {
        this.date = date;
    }

    @Override
    public boolean test(Appointment appointment) {
        return calculateStartWeek(date).getLocalDate().isBefore(appointment.getAppointmentDate().getLocalDate())
            && calculateEndWeek(date).getLocalDate().isAfter(appointment.getAppointmentDate().getLocalDate());
    }

    private Date calculateStartWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(java.util.Date
            .from(date.getLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        String startWeekDate = String
            .format("%s-%s-%s", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar
                .get(Calendar.YEAR));
        return new Date(startWeekDate);
    }

    private Date calculateEndWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        date = calculateStartWeek(date);
        calendar.setTime(java.util.Date
            .from(date.getLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        calendar.add(Calendar.DATE, 6);
        String endWeekDate = String
            .format("%s-%s-%s", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar
                .get(Calendar.YEAR));
        return new Date(endWeekDate);
    }
}
