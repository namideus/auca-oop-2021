public class Problem01 {
    private static final int CANVAS_SIZE = 20;
    public static void main(String[] args) {
        int x;
        char[][] canvas = new char[CANVAS_SIZE][CANVAS_SIZE];

        init(canvas);

        print(canvas);
    }

    public static void init(char[][] canvas) {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                canvas[row][col] = '.';
            }
        }
    }

    public static void print(char[][] canvas)
    {
        for(int row = 0; row < CANVAS_SIZE; ++row) {
            for(int col = 0; col < CANVAS_SIZE; ++col) {
                System.out.print(canvas[row][col]);
            }
            System.out.println();
        }
    }
}
