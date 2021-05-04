package easy;

public class GameModel {
    private int curLevel = 0;
    Puzzle puzzle;

    private static final char[][][] levels = {
            {
                    {'B','B','#','#','#','#','#','B'},
                    {'#','#','#',' ',' ',' ','#','B'},
                    {'#',' ','$',' ','#',' ','#','#'},
                    {'#',' ','#',' ',' ','E',' ','#'},
                    {'#',' ',' ',' ',' ','#',' ','#'},
                    {'#','#',' ','#',' ',' ',' ','#'},
                    {'B','#','R',' ',' ','#','#','#'},
                    {'B','#','#','#','#','#','B','B'}
            },
            {
                    {'#','#','#','#','#','#','#'},
                    {'#',' ',' ',' ','#','E','#'},
                    {'#',' ','#',' ','#',' ','#'},
                    {'#',' ','#',' ','#',' ','#'},
                    {'#',' ','#',' ',' ',' ','#'},
                    {'#',' ','#',' ','#',' ','#'},
                    {'#','R','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#'}
            },
            {
                    {'#','#','#','#','#','#','#'},
                    {'#',' ',' ',' ',' ',' ','#'},
                    {'#',' ','#','E','#',' ','#'},
                    {'#',' ','#','#','#',' ','#'},
                    {'#',' ',' ','R','#',' ','#'},
                    {'#',' ',' ',' ',' ',' ','#'},
                    {'#',' ',' ',' ',' ',' ','#'},
                    {'#','#','#','#','#','#','#'}
            }
    };

    public GameModel() {
        this.curLevel = 0;
        this.puzzle = new Puzzle(levels[curLevel]);
    }

    public float getCurHeight() {
        return puzzle.getHeight();
    }

    public float getCurWidth() {
        return puzzle.getWidth();
    }

    public int getCurLevel() {
        return curLevel + 1;
    }

    public void nextLevel() {
        ++curLevel;
        if(curLevel==levels.length)
            curLevel = 0;
        puzzle = new Puzzle(levels[curLevel]);
    }
}
