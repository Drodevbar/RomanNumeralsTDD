package romanNumerals;

import java.util.TreeMap;

class RomanNumeralsConverter
{
    private final static TreeMap<Integer, Character> ARABIC_TO_ROMAN = new TreeMap<Integer, Character>() {
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

    static String toRoman(int arabic) throws IllegalArgumentException
    {
        if (arabic < 1) {
            throw new IllegalArgumentException("Number can not be less than 1");
        }
        
        if (ARABIC_TO_ROMAN.containsKey(arabic)) {
            return ARABIC_TO_ROMAN
                    .get(arabic)
                    .toString();
        }
        return "";
    }
}
