package romanNumerals;

import java.util.TreeMap;

class RomanNumeralsConverter
{
    private final static TreeMap<Integer, String> ARABIC_TO_ROMAN = new TreeMap<Integer, String>()
    {
        {
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }
    };

    static String toRoman(int arabic) throws IllegalArgumentException
    {
        if (arabic < 1) {
            throw new IllegalArgumentException("Number can not be less than 1");
        }
        
        if (ARABIC_TO_ROMAN.containsKey(arabic)) {
            return ARABIC_TO_ROMAN.get(arabic);
        }
        
        String outputBuffer = "";
        Integer closestNumber = 0;
        while (!ARABIC_TO_ROMAN.containsKey(arabic)) {
            arabic -= closestNumber;
            closestNumber = ARABIC_TO_ROMAN.floorKey(arabic);
            outputBuffer += ARABIC_TO_ROMAN.get(closestNumber);
        }
        
        return outputBuffer;
    }
}
