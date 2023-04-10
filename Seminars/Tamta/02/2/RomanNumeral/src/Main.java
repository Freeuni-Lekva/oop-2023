public class Main {
    public static void main(String[] args) {

       RomanNumeral roman = new RomanNumeral(17);
       System.out.println(roman.toString());
       System.out.println(roman.toInt());

       RomanNumeral roman2 = new RomanNumeral("XVII");
       System.out.println(roman2.toString());
       System.out.println(roman2.toInt());

       RomanNumeral roman3 = new RomanNumeral("CMXCIX");
       System.out.println(roman3.toString());
       System.out.println(roman3.toInt());

    }

}