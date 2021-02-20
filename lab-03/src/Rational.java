public class Rational {

    private int nominator;
    private int denominator;

    public Rational(int nominator, int denominator)
    {
        if(denominator==0)
            throw new RuntimeException("Rational: denominator is zero");
        this.nominator = nominator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    public Rational add(Rational other)
    {
        int rNum = nominator*other.denominator+denominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational subtract(Rational other)
    {
        int rNum = nominator*other.denominator-denominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational multiply(Rational other)
    {
        int rNum = nominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new Rational(rNum, rDen);
    }

    public Rational divide(Rational other)
    {
        int rNum = nominator*other.denominator;
        int rDen = denominator*other.nominator;
        return new Rational(rNum, rDen);
    }
}
