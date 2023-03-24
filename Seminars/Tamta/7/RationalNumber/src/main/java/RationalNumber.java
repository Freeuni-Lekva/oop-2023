/** Ratnum is an immutable type representing rational numbers
 */
public class RationalNumber {
    public int numerator;
    private int denominator;

    // inv: denominator > 0
    // inv: gcd(numerator, denominator) = 1

    // Abstraction Function: represents the rational number numerator / denominator

    /**
     * Make a new RationalNumber == (n / d).
     * @param numerator n
     * @param denominator d
     * @throws IllegalArgumentException if d == 0
     */
    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be 0");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    /**
     * Make a new RationalNumber == n
     * @param wholeNum n
     */
    public RationalNumber(int wholeNum) {
        this(wholeNum, 1);
    }

    /**
     * Make a new RationalNumber == ratNum. copy constructor
     * მომხმარებელი გამოიყენებს როდესაც სჭირდება ორი იდენტური ობიექტი სხვადასხვა მისამართით.
     * @param ratNum
     */
    public RationalNumber(RationalNumber ratNum) {
        this(ratNum.numerator, ratNum.denominator);
    }

    public RationalNumber add(RationalNumber a) {
        int newDenom = a.denominator * denominator;
        int newNum = a.numerator * denominator + numerator * a.denominator;
        return new RationalNumber(newNum, newDenom);
    }

    public RationalNumber multiply(RationalNumber a) {
        return new RationalNumber(a.numerator * numerator, a.denominator * numerator);
    }

    /////////////////////////////////////////
    // other methods should go here
    //    producers: add(), subtract(), multiply(), divide(), etc.
    //    observers: isPositive(), intValue(), etc.
    //    mutators: none

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        int r = a % b;
        return gcd(b, r);
    }


}
