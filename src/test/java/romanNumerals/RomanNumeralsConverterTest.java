package romanNumerals;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;
import static romanNumerals.RomanNumeralsConverter.toRoman;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralsConverterTest
{
    @Rule
    public final ExpectedException thrown = ExpectedException.none();
    
    @Test
    @Parameters({
            "I, 1", "V, 5", "C, 100", "M, 1000",
            "IV, 4", "IX, 9", "CD, 400", "CM, 900",
            "II, 2", "III, 3", "XLVI, 46", "CLXVII, 167", 
            "CMXCIX, 999", "XLV, 45", "CIX, 109", "VIII, 8",
            "MLIX, 1059", "LXXVII, 77", "MMM, 3000", "DXXXIII, 533"
    })
    public void shouldConvertToProperRomanNumeral(String roman, int arabic)
    {
        assertEquals(roman, toRoman(arabic));
    }
    
    @Test
    public void shouldThrowExceptionWhenNumberLessThanOneGiven() throws IllegalArgumentException
    {
        thrown.expect(IllegalArgumentException.class);
        toRoman(0);
    }
}
