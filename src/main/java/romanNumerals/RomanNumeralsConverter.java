package romanNumerals;

import java.util.HashMap;

class RomanNumeralsConverter
{
    private final static HashMap<Integer, Character> ARABIC_TO_ROMAN = new HashMap<Integer, Character>() {
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
        if (ARABIC_TO_ROMAN.containsKey(arabic)) {
            return ARABIC_TO_ROMAN
                    .get(arabic)
                    .toString();
        }
        return "";
    }
}
