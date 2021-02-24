import java.math.BigInteger;

public class Rational {

    private int nominator;
    private int denominator;

    public Rational(int nominator, int denominator)
    {
        if(denominator==0)
            throw new RuntimeException("Rational: denominator is zero");

        if(denominator<0) {
            nominator=-nominator;
            denominator=-denominator;
        }

        int a = Math.abs(nominator);
        int b = Math.abs(denominator);

        while(b!=0) {
            int rem = a % b;
            a = b;
            b = rem;
        }

        this.nominator = nominator/a;
        this.denominator = denominator/a;
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    public Rational add(Rational other) {
        int rNum = nominator*other.denominator+denominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational subtract(Rational other) {
        int rNum = nominator*other.denominator-denominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational multiply(Rational other) {
        return new Rational(nominator*other.nominator,
                denominator*other.denominator);
    }

    public Rational divide(Rational other) {
        return new Rational(nominator*other.denominator,
                denominator*other.nominator);
    }

    public int compareTo(Rational other) {
        int lhs = nominator*other.denominator;
        int rhs = denominator*other.nominator;
        return Integer.compare(lhs, rhs);
    }
    // public void parse
}
