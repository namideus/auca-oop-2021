package normal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Iman Augustine
 *
 * Sokoban project game, OOP, 2021
 *
 * instructor: S. Shostak
 *
 * */

public class Utils {

    // For checking all eight neighbours
    private static final int[] xs = { 1, -1, 0, 1,-1, 0, -1, 1};
    private static final int[] ys = { 1, -1, 1, 0, 0,-1, 1 , -1 };

    // Read levels from a file
    public static ArrayList<String> readLevelsFromFile(String filePath) throws FileNotFoundException {
        ArrayList<String> levelsList = new ArrayList<>();
        StringBuilder curPuzzle = new StringBuilder();

        try (Scanner scan = new Scanner(new File(filePath))) {
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                if(line.length()==0) {
                    continue;
                }
                if(line.startsWith(";")) {
                    levelsList.add(curPuzzle.toString());
                    curPuzzle = new StringBuilder();
                } else {
                    curPuzzle.append(line).append("\n");
                }
            }
        }

        return levelsList;
    }

    // Flood fill algorithm
    public static void clearEdges(char[][] data, int row, int col, int height, int width) {
        if(!isValid(row, col, height, width))
            throw new RuntimeException("Invalid parameters passed in clearEdges() function");

        // Base case
        if (data[row][col] != ' ')
            return;

        // Set counter or empty chart
        data[row][col] = 'B';

        // Recursion
        for (int k = 0; k < 8; ++k) {
            if (isValid(xs[k] + row, ys[k] + col, height, width)) {
                clearEdges(data, xs[k] + row, ys[k] + col, height, width);
            }
        }
    }

    // If col and row are valid
    public static boolean isValid(int row, int col,  int height, int width) {
        return row>=0 && col>=0 && row<height && col<width;
    }

    //------------------Parse string array and build char matrix---------------------
    public static char[][] parseLevel(String str) {
        // Create string array from string
        String[] strArray = str.split("\n");

        // Get the height
        int height = strArray.length;
        int width = 0;

        // Get the maximum width
        for(String s : strArray) {
            width = Math.max(s.length(), width);
        }

        char[][] level = new char[height][width];

        // Fill initial matrix with empty cells
        for(int r=0; r<height; ++r) {
            for (int c = 0; c < width; ++c) {
                level[r][c] = ' ';
            }
        }

        // Fill the matrix with items (Walls, Ground, Robot, Goals)
        for(int r=0; r<height; ++r) {
            for (int c = 0; c < strArray[r].length(); ++c) {
                level[r][c] = strArray[r].charAt(c);
            }
        }

        // Sets B char in areas outside of maze so they will be painted black on display (invisible)
        clearEdges(level,0,0, height, width);
        clearEdges(level,0,width-1, height, width);
        clearEdges(level,height-1,0, height, width);
        clearEdges(level,height-1,width-1, height, width);

        return level;
    }
}


