import java.math.BigInteger;

public class MyBigRatio {
    private BigInteger nom, den;

    public MyBigRatio(BigInteger nom, BigInteger den) {
        if (den.equals(BigInteger.ZERO)) {
            throw new RuntimeException("Denom is zero!");
        }
        if(den.signum()<0) {
            nom = nom.negate();
            den = den.negate();
        }
        BigInteger a = nom.gcd(den);

        this.nom = nom.divide(a);
        this.den = den.divide(a);
    }

    public MyBigRatio add(MyBigRatio other) {
              BigInteger newNom = other.nom.multiply(this.den).add(other.den.multiply(this.nom));
              BigInteger newDen = other.den.multiply(this.den);
              return new MyBigRatio(newNom, newDen);
    }

    public String toString() {
        return this.nom.toString() + "/" + this.den.toString();
    }
}
