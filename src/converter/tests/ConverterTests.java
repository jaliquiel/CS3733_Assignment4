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

    /**
     * Test cases for spaces between, after and before the number string
     */
    @Test(expected = MalformedNumberException.class)
    public void spacesTest() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  2 0  ");
    }

    @Test(expected = MalformedNumberException.class)
    public void spacesTest3() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  MIII e");
    }

    @Test
    public void spaceTest2() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("  20");
    }

    @Test
    public void spaceTest4() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("  CCCw");
    }

    /**
     * Test cases for MarformedNumberException
     */
    @Test(expected = MalformedNumberException.class)
    public void ArabicElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  MMM5");
    }

    // todo should it be valueOut of bounds or malformed?
    @Test(expected = ValueOutOfBoundsException.class)
    public void ArabicElbonianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("  234M");
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


    /**
     * Test cases for ValueOutOfBoundsException
     */
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

    /**
     * Test cases for toElbonian Function
     */
    @Test
    public void ArabicToElonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("3999");
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("1837");
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("2544");
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("3666");
        assertEquals(converter.toElbonian(), "I");
        assertEquals(converter2.toElbonian(), "MMMeDmLwV");
        assertEquals(converter3.toElbonian(), "MDCCCXXXVII");
        assertEquals(converter4.toElbonian(), "MMDmw");
        assertEquals(converter5.toElbonian(), "MMMDCLXVI");
    }

    /**
     * Test cases for toArabic Function
     */
    @Test
    public void ElonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("MMMeDmLwV");
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("MDCCCXXXVII");
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("MMDmw");
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("MMMDCLXVI");
        assertEquals(converter.toArabic(), 1);
        assertEquals(converter2.toArabic(), 3999);
        assertEquals(converter3.toArabic(), 1837);
        assertEquals(converter4.toArabic(), 2544);
        assertEquals(converter5.toArabic(), 3666);
    }
    // TODO WRITE MORE

}
