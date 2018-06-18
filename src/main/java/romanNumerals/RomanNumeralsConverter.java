package romanNumerals;

import java.util.Map;
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
        
        StringBuilder romanNumeralBuilder = new StringBuilder();
        int closestNumber = 0;

        do {
            arabic -= closestNumber;
            closestNumber = ARABIC_TO_ROMAN.floorKey(arabic);
            romanNumeralBuilder.append(ARABIC_TO_ROMAN.get(closestNumber));
        } while (!ARABIC_TO_ROMAN.containsKey(arabic));
        
        return romanNumeralBuilder.toString();
    }
    
    static int toArabic(String roman) throws IllegalArgumentException
    {
        if (!isRomanNumeralValid(roman)) {
            throw new IllegalArgumentException("Illegal roman numeral given");
        }
       
        if (ARABIC_TO_ROMAN.containsValue(roman)) {
            return getArabicByRoman(roman);
        }
        
        return buildArabicNumber(roman);
    }
    
    private static int buildArabicNumber(String roman)
    {
        int romanCurrentIndex = 0;
        int arabic = 0;
        
        do {
            if (romanCurrentIndex + 1 < roman.length() && ARABIC_TO_ROMAN.containsValue(roman.substring(romanCurrentIndex, romanCurrentIndex + 2))) {
                arabic += getArabicByRoman(roman.substring(romanCurrentIndex, romanCurrentIndex + 2));
                romanCurrentIndex += 2;
            } else {
                arabic += getArabicByRoman(roman.substring(romanCurrentIndex, romanCurrentIndex + 1));
                romanCurrentIndex++;
            }
        } while (romanCurrentIndex < roman.length());
        
        return arabic;
    }
    
    private static boolean isRomanNumeralValid(String roman)
    {
        for (Character numeral: roman.toCharArray()) {
            if (!ARABIC_TO_ROMAN.containsValue(numeral.toString())) {
                return false;
            }
        }
        return true;
    }
    
    private static int getArabicByRoman(String roman)
    {
        for (Map.Entry<Integer, String> entry : ARABIC_TO_ROMAN.entrySet()) {
            if (entry.getValue().equals(roman)) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
