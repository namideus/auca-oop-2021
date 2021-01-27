public class StringVsStringBuilder {
    public static void main(String[] args) {
        String s = "";
        s = s + "Hello";
        s = s + " World!";
        s+="!!!";
        System.out.println(s);

        StringBuilder b = new StringBuilder();
        b.append("Hello");
        b.append(" World");
        b.append("!!!");
        System.out.println(b.toString());

        // heap
        // dynamic memory
        // garbage collector
        // string is immutable
        //
    }
}
