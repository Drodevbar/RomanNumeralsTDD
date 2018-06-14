package romanNumerals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import static romanNumerals.RomanNumeralsConverter.toRoman;

@RunWith(JUnit4.class)
public class RomanNumeralsConverterTest
{
    @Rule
    public final ExpectedException thrown = ExpectedException.none();
     
    @Test
    public void testOne()
    {
        assertEquals("I", toRoman(1));
    }
     
    @Test
    public void testFive()
    {
        assertEquals("V", toRoman(5));
    }
     
    @Test
    public void testTen()
    {
        assertEquals("X", toRoman(10));
    }
     
    @Test
    public void testFifty()
    {
        assertEquals("L", toRoman(50));
    }
     
    @Test
    public void testHundred()
    {
        assertEquals("C", toRoman(100));
    }
     
    @Test
    public void testFiveHundred()
    {
        assertEquals("D", toRoman(500));
    }
     
    @Test
    public void testThousand()
    {
        assertEquals("M", toRoman(1000));
    }
    
    @Test
    public void testExceptionWhenNumberLessThanOneGiven() throws IllegalArgumentException
    {
        thrown.expect(IllegalArgumentException.class);
        toRoman(0);
    }
    
    @Test
    public void testTwo()
    {
        assertEquals("II", toRoman(2));
    }
}
