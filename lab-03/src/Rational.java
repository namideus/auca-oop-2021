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
}
