import java.math.BigInteger;

public class BigRational {

    private final BigInteger nominator;
    private final BigInteger denominator;

    public BigRational(BigInteger nominator, BigInteger denominator) {
        if(denominator.equals(BigInteger.ZERO))
            throw new RuntimeException("Rational: denominator is zero");

        if(denominator.signum()<0) {
            nominator=nominator.multiply(new BigInteger("-1"));
            denominator=denominator.multiply(new BigInteger("-1"));
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
        return new BigRational(nominator.multiply(other.denominator), denominator.multiply(other.nominator));
    }

    public int compareTo(BigRational other) {
        BigInteger lhs = nominator.multiply(other.denominator);
        BigInteger rhs = denominator.multiply(other.nominator);
        return lhs.compareTo(rhs);
    }

    public static BigRational parse(String s) {

        s = s.trim();
        int indexSlash = s.indexOf("/");

        if(indexSlash==-1) {
            return new BigRational(new BigInteger(s),new BigInteger("1"));
        }
        BigInteger num = new BigInteger(s.substring(0,indexSlash));
        BigInteger den = new BigInteger(s.substring(indexSlash+1));
        return new BigRational(num, den);
    }
}
