import java.util.*;

// read line
// change lowercase to uppercase
// change uppercase letters to lowercase

public class StringAndArrays {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        // s is a reference (address)
        String s = inp.nextLine();

        char[] v = s.toCharArray();

        for(int i=0; i<v.length; ++i)
        {
            if(Character.isUpperCase(v[i])) {
                v[i] = Character.toLowerCase(v[i]);
            } else if(Character.isLowerCase(v[i])) {
                v[i] = Character.toUpperCase(v[i]);
            }
        }

        String r = new String(v);
        System.out.println(r);
    }
}
