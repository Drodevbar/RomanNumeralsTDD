package romanNumerals;

import java.util.HashMap;

class RomanNumeralsConverter
{
    private static HashMap<Integer, Character> arabicToRomanMap = new HashMap<Integer, Character>() {
        {
            put(1, 'I');
            put(5, 'V');
            put(10, 'X');
            put(50, 'L');
            put(100, 'C');
            put(500, 'D');
            put(1000, 'M');
        }
    };

    static String toRoman(int arabic)
    {
        if (arabicToRomanMap.containsKey(arabic)) {
            return arabicToRomanMap
                    .get(arabic)
                    .toString();
        }
        return "";
    }
}
