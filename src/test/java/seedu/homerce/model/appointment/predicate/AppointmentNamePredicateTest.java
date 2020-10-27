package seedu.homerce.model.appointment.predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.homerce.testutil.client.TypicalClients.ALICE;
import static seedu.homerce.testutil.client.TypicalClients.BENSON;

import org.junit.jupiter.api.Test;

import seedu.homerce.model.client.Name;
import seedu.homerce.testutil.appointment.AppointmentBuilder;

public class AppointmentNamePredicateTest {
    @Test
    public void equals() {
        Name firstName = new Name("Benson Tan");
        Name secondName = new Name("Carlson Lim");
        Name thirdName = new Name("Carlson Lim");
        AppointmentNamePredicate firstPredicate = new AppointmentNamePredicate(firstName);
        AppointmentNamePredicate secondPredicate = new AppointmentNamePredicate(secondName);
        AppointmentNamePredicate thirdPredicate = new AppointmentNamePredicate(thirdName);
        // same object -> return true
        assertEquals(firstPredicate, firstPredicate);
        // same values -> return true
        assertEquals(secondPredicate, thirdPredicate);
        // different types -> return false
        assertNotEquals(firstPredicate, 1);
        assertNotEquals(firstPredicate, null);
        // different values -> return false
        assertNotEquals(firstPredicate, secondPredicate);
    }

    @Test
    public void test_appointmentContainsName_returnsTrue() {
        Name name = new Name("Benson Meier");
        AppointmentNamePredicate predicate = new AppointmentNamePredicate(name);
        assertTrue(predicate.test(new AppointmentBuilder().withClient(BENSON).build()));
    }

    @Test
    public void test_appointmentContainsName_returnsFalse() {
        Name name = new Name("Benson Tan");
        AppointmentNamePredicate predicate = new AppointmentNamePredicate(name);
        assertFalse(predicate.test(new AppointmentBuilder().withClient(ALICE).build()));
    }
}
