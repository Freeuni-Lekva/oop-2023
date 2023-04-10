public class RomanNumeral {
    private final static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private int arabicNumber;
    public RomanNumeral(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }
    public RomanNumeral(String romanNumber) {
        int result = 0;
        for (int i = 0; i < romanNumber.length() - 1; i++) {
            char elem = romanNumber.charAt(i);
            int curElem = letter2Int(elem);
            char nextElemChar = romanNumber.charAt(i+1);
            int nextElem = letter2Int(nextElemChar);

            if (curElem < nextElem) {
                result -= curElem;
            } else {
                result += curElem;
            }
        }

        result += letter2Int(romanNumber.charAt(romanNumber.length()-1));
        arabicNumber = result;

    }

    public String toString(){
        int arabic = arabicNumber;
        String roman = "";
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] <= arabic) {
                arabic -= numbers[i];
                roman += letters[i];
            }
        }
        return roman;
    }

    public int toInt(){
        return arabicNumber;
    }

    private int letter2Int(char roman){
        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new NumberFormatException("invalid roman numeral");
        }
    }

}