package p05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {
    public static void main(String[] args) throws Exception {
        if(args.length!=2) {
            System.out.println("Usage: java RemoveText <text> <filename>");
            System.exit(1);
        }

        File sourceFile = new File(args[0]);
        if(!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        try (
                Scanner scan = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(sourceFile);
        ) {
            while (scan.hasNext()) {
                String s1 = scan.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.println(s2);
            }
        }
    }
}
