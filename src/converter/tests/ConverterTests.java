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
    public void ArabicToElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converterMin = new ElbonianArabicConverter("1");
        assertEquals(converterMin.toElbonian(), "I");

        ElbonianArabicConverter converterMax = new ElbonianArabicConverter("3999");
        assertEquals(converterMax.toElbonian(), "MMMeDmLwV");

        ElbonianArabicConverter converter1234 = new ElbonianArabicConverter("1234");
        assertEquals(converter1234.toElbonian(), "MCCXXXw");

        ElbonianArabicConverter converter444 = new ElbonianArabicConverter("444");
        assertEquals(converter444.toElbonian(), "emw");
    }

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("MMMeDmLwV");
        assertEquals(converter.toArabic(), 1);
        assertEquals(converter2.toArabic(), 3999);
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
