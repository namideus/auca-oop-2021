package p03;

import java.math.BigInteger;

public class BigRational implements MyComparable {

    private final BigInteger nominator;
    private final BigInteger denominator;

    public BigRational(BigInteger nominator, BigInteger denominator) {
        if(denominator.equals(BigInteger.ZERO))
            throw new RuntimeException("calc01.Rational: denominator is zero");

        if(denominator.signum()<0) {
            nominator=nominator.negate();
            denominator=denominator.negate();
        }

        BigInteger gcd = nominator.gcd(denominator);

        this.nominator = nominator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    @Override
    public String toString() {
        return this.nominator.toString() + "/" + this.denominator;
    }

    public BigRational add(BigRational other) {
        BigInteger rNum = nominator.multiply(other.denominator).add(denominator.multiply(other.nominator));
        BigInteger rDen = denominator.multiply(other.denominator);
        return new BigRational(rNum, rDen);
    }

    public BigRational subtract(BigRational other) {
        BigInteger rNum = nominator.multiply(other.denominator).subtract(denominator.multiply(other.nominator));
        BigInteger rDen = denominator.multiply(other.denominator);
        return new BigRational(rNum, rDen);
    }

    public BigRational multiply(BigRational other) {
        return new BigRational(nominator.multiply(other.nominator),
                denominator.multiply(other.denominator));
    }

    public BigRational divide(BigRational other) {
        if(other.nominator.equals(BigInteger.ZERO)) {
            throw new RuntimeException("BigRational: division by zero");
        }
        return new BigRational(nominator.multiply(other.denominator),
                denominator.multiply(other.nominator));
    }

    public BigInteger getNominator() {
        return nominator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public static BigRational parse(String s) {

        s = s.trim();
        int indexSlash = s.indexOf("/");

        if(indexSlash==-1) {
            return new BigRational(new BigInteger(s),BigInteger.ONE);
        }
        BigInteger num = new BigInteger(s.substring(0,indexSlash));
        BigInteger den = new BigInteger(s.substring(indexSlash+1));
        return new BigRational(num, den);

    }

    @Override
    public int compareTo(Object o) {
        BigRational other  = (BigRational)o;
        return nominator.multiply(other.denominator).compareTo(denominator.multiply(other.nominator));
    }
}
