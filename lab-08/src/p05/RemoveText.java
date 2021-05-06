package p05;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {
    public static void main(String[] args) throws Exception {
        if(args.length!=2) {
            System.out.println("Usage: java RemoveText <text> <filename>");
            System.exit(1);
        }

        File sourceFile = new File(args[1]);
        if(!sourceFile.exists()) {
            System.out.println("Source file " + args[1] + " does not exist");
            System.exit(2);
        }

        // File targetFile = new File(args[1]);

        try (
                Scanner scan = new Scanner(sourceFile);
                PrintWriter output = new PrintWriter(sourceFile);
        ) {
            while (scan.hasNext()) {
                String s1 = scan.nextLine();
                String s2 = s1.replaceAll(args[0],null);
                output.println(s2);
            }
        }
    }
}
