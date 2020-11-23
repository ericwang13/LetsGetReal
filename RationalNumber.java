public class RationalNumber extends RealNumber{
    private int numerator, denominator;

    public RationalNumber(int nume, int deno){        
        super(0.0);//this value is ignored! 
        if (deno == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            numerator = nume;
            denominator = deno;
            reduce();
        }
    }

    public double getValue(){
        return (double) numerator / (double) denominator;
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public RationalNumber reciprocal(){
        return new RationalNumber(denominator, numerator);
    }

    public boolean equals(RationalNumber other){
        return numerator == other.getNumerator() && denominator == other.getDenominator();
    }

    /**
     *@return the value expressed as "3/4" or "8/3"
    */
    public String toString(){
        return "" + numerator + "/" + denominator;
    }

    /**Calculate the GCD of two integers.
     *@param a the first integers
    *@param b the second integer
    *@return the value of the GCD
    */
    private static int gcd(int a, int b){
        if (a < b) {
            int swap = a;
            a = b;
            b = swap;
        }

        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        } return b;
    }

    private void reduce(){
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public RationalNumber multiply(RationalNumber other){
        RationalNumber product = new RationalNumber(numerator * other.getNumerator(), denominator * other.getDenominator());
        product.reduce();
        return product;
    }


    public RationalNumber divide(RationalNumber other){
        return multiply(other.reciprocal());
    }

    public RationalNumber add(RationalNumber other){
        RationalNumber sum = new RationalNumber(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator);
        sum.reduce();
        return sum;
    }

    public RationalNumber subtract(RationalNumber other){
        RationalNumber difference = new RationalNumber(numerator * other.denominator - other.numerator * denominator, denominator * other.denominator);
        difference.reduce();
        return difference;    
    }
}
