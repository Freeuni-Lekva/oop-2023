public class Main {
    public static void main(String[] args) {

        RomanToNumeral r;
        try {
             r = new RomanToNumeral(Integer.valueOf(args[0]));
        } catch (NumberFormatException e) {
            r = new RomanToNumeral(args[0]);
        }

        System.out.println(r.toArabic());
        System.out.println(r.toRoman());
    }
}