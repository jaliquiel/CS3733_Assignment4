package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ArabicToElonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("4332");
        assertEquals(converter.toElbonian(), "I");
        assertEquals(converter2.toElbonian(), "MMMeDCCCmLXXXwVIII");
    }

    @Test
    public void ElonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("MMMeDCCCmLXXXwVIII");
        assertEquals(converter.toArabic(), 1);
        assertEquals(converter2.toArabic(), 4332);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("TEST");
    }

    // TODO Add more test cases
}
