import java.math.BigInteger;

public class Problem04 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("111111111111111111111111111111111111111111");
        BigInteger b = new BigInteger("222222222222222222222222222222222222222222222222222");
        System.out.println(a.multiply(b));
        System.out.println(a.gcd(b));
        // Home task: change class rational, create BigRational, represent it as BigInteger
        // BigInteger has GCD
    }
}
