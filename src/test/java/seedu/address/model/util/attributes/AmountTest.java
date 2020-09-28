package seedu.address.model.util.attributes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AmountTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Amount(null));
    }

    @Test
    public void constructor_invalidAmount_throwsIllegalArgumentException() {
        String invalidAmount = "";
        assertThrows(IllegalArgumentException.class, () -> new Amount(invalidAmount));
    }

    @Test
    public void isValidAmount() {
        // null amount
        assertThrows(NullPointerException.class, () -> Amount.isValidAmount(null));

        // invalid amounts
        assertFalse(Amount.isValidAmount("")); // empty string
        assertFalse(Amount.isValidAmount(" ")); // spaces only
        assertFalse(Amount.isValidAmount("$2.00")); // incorrect symbol
        assertFalse(Amount.isValidAmount("two")); // word input
        assertFalse(Amount.isValidAmount("2.0")); // one decimal place
        assertFalse(Amount.isValidAmount("1000.00")); // thousands

        // valid amounts are whole numbers or with two decimal places
        assertTrue(Amount.isValidAmount("0")); // zero
        assertTrue(Amount.isValidAmount("12")); // whole number
        assertTrue(Amount.isValidAmount("0.12")); // cents
        assertTrue(Amount.isValidAmount("1.23")); // ones
        assertTrue(Amount.isValidAmount("12.34")); // tens
        assertTrue(Amount.isValidAmount("123.45")); // hundreds
    }
}
