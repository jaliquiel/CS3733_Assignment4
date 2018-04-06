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
    public void eCTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("eC");
    }

    @Test(expected = MalformedNumberException.class)
    public void mXTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mX");
    }

    @Test(expected = MalformedNumberException.class)
    public void badLetterTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("lkDew");
    }

    @Test(expected = MalformedNumberException.class)
    public void MTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMMMeI");
    }

    @Test(expected = MalformedNumberException.class)
    public void DTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DD");
    }

    @Test(expected = MalformedNumberException.class)
    public void LTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("LLL");
    }

    @Test(expected = MalformedNumberException.class)
    public void VTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("VV");
    }

    @Test(expected = MalformedNumberException.class)
    public void eTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("ee");
    }

    @Test(expected = MalformedNumberException.class)
    public void mTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("mm");
    }

    @Test(expected = MalformedNumberException.class)
    public void wTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("ww");
    }

    @Test(expected = MalformedNumberException.class)
    public void CTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCCC");
    }

    @Test(expected = MalformedNumberException.class)
    public void XTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXXX");
    }

    @Test(expected = MalformedNumberException.class)
    public void ITest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IIII");
    }

    @Test(expected = MalformedNumberException.class)
    public void badOrderTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MVDm");
    }

    @Test(expected = MalformedNumberException.class)
    public void badOrderTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("De");
    }

    @Test(expected = MalformedNumberException.class)
    public void badOrderTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Lm");
    }

    @Test(expected = MalformedNumberException.class)
    public void badOrderTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("Vw");
    }

    @Test(expected = MalformedNumberException.class)
    public void badOrderTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("IDM");
    }


    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void outOfBounds2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("4000");
    }
    @Test(expected = ValueOutOfBoundsException.class)
    public void decimalTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3998.999");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void decimalTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1.01");
    }
}
