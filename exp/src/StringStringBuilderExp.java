public class StringStringBuilderExp {

    static final int N = 10000;

    public static void main(String[] args) {
        expWithStringBuilder();
        expWithString();
    }

    // StringBuilder
    static void expWithStringBuilder() {
        long beg = System.nanoTime();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<N; ++i) {
            res.append("Hello".charAt(i%5));
        }
        long end = System.nanoTime();

        System.out.println(res.length());
        System.out.println(end-beg);
    }

    // String
    static void expWithString() {
        long beg = System.nanoTime();
        String res = "";
        for(int i=0; i<N; ++i) {
            res += "Hello".charAt(i%5);
        }
        long end = System.nanoTime();

        System.out.println(res.length());
        System.out.println(end-beg);
    }
}
