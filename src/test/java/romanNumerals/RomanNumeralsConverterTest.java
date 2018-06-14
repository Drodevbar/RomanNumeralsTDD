package romanNumerals;

import junit.framework.TestCase;
import static romanNumerals.RomanNumeralsConverter.toRoman;

public class RomanNumeralsConverterTest extends TestCase
{
    public void testOne()
    {
        assertEquals("I", toRoman(1));
    }

    public void testFive()
    {
        assertEquals("V", toRoman(5));
    }

    public void testTen()
    {
        assertEquals("X", toRoman(10));
    }

    public void testFifty()
    {
        assertEquals("L", toRoman(50));
    }

    public void testHundred()
    {
        assertEquals("C", toRoman(100));
    }

    public void testFiveHundred()
    {
        assertEquals("D", toRoman(500));
    }

    public void testThousand()
    {
        assertEquals("M", toRoman(1000));
    }
    
    public void testTwo()
    {
        assertEquals("II", toRoman(2));
    }
}
