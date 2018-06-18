package romanNumerals;

import java.util.Map;
import java.util.TreeMap;
import static java.lang.Math.*;

class RomanNumeralsConverter
{
    private final static TreeMap<Integer, String> ARABIC_TO_ROMAN = new TreeMap<Integer, String>()
    {
        {
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
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
        
        return buildRomanNumeral(arabic);
    }
    
    private static String buildRomanNumeral(int arabic)
    {
        int powerOfTen = (int) pow(10, floor(log10(arabic)));
        int firstDigit = arabic / powerOfTen;
        
        if (firstDigit % 5 == 4) {
            int rest = arabic - (firstDigit * powerOfTen);
            return toRoman(powerOfTen) + toRoman((firstDigit + 1) * powerOfTen) + ((rest > 0) ? toRoman(rest) : "");
        }
        
        int floorKey = ARABIC_TO_ROMAN.floorKey(arabic);  
        return ARABIC_TO_ROMAN.get(floorKey) + toRoman(arabic - floorKey);
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
        int arabic = 0;
        
        for (int i = 0; i < roman.length(); i++) {
            int currentNumber = getArabicByRoman(Character.toString(roman.charAt(i)));
            if (i + 1 < roman.length() && currentNumber < getArabicByRoman(Character.toString(roman.charAt(i + 1)))) {
                arabic += getArabicByRoman(Character.toString(roman.charAt(i + 1))) - currentNumber;
                i++;
            } else {
                arabic += currentNumber;
            }
        }
        
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
