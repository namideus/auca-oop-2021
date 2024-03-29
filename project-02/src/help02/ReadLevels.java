package help02;

import java.io.*;
import java.util.*;

public class ReadLevels {
    public static void main(String[] args) {
        ArrayList<String> levels = new ArrayList<>();
        StringBuilder curPuzzle = new StringBuilder();
        try {
            try (Scanner scan = new Scanner(new File("levels/MiniCosmos.txt"))) {
                while(scan.hasNextLine()) {
                    String line = scan.nextLine();
                    if(line.length()==0) {
                        continue;
                    }
                    if(line.startsWith(";")) {
                        levels.add(curPuzzle.toString());
                        curPuzzle = new StringBuilder();
                    } else {
                        curPuzzle.append(line).append("\n");
                    }
                }
            }
            System.out.println("Size: "+levels.size());
            int count = 0;
            for(String puzzle : levels) {
                System.out.println(++count);
                System.out.println(puzzle);
                puzzle.split("\n");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
