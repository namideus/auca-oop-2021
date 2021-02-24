public class BigRational {

    private int nominator;
    private int denominator;

    public BigRational(int nominator, int denominator)
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

    public BigRational add(BigRational other) {
        int rNum = nominator*other.denominator+denominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new BigRational(rNum, rDen);
    }

    public BigRational subtract(BigRational other) {
        int rNum = nominator*other.denominator-denominator*other.nominator;
        int rDen = denominator*other.denominator;
        return new BigRational(rNum, rDen);
    }

    public BigRational multiply(BigRational other) {
        return new BigRational(nominator*other.nominator,
                denominator*other.denominator);
    }

    public BigRational divide(BigRational other) {
        return new BigRational(nominator*other.denominator,
                denominator*other.nominator);
    }

    public int compareTo(BigRational other) {
        int lhs = nominator*other.denominator;
        int rhs = denominator*other.nominator;
        return Integer.compare(lhs, rhs);
    }

    public static BigRational parse(String s) {

        s = s.trim();
        int indexSlash = s.indexOf("/");

        if(indexSlash==-1) {
            return new BigRational(Integer.parseInt(s),1);
        }
        int num = Integer.parseInt(s.substring(0,indexSlash));
        int den = Integer.parseInt(s.substring(indexSlash+1));
        return new BigRational(num, den);
    }
}
