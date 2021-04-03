import java.util.Scanner;

/**
 * @author Iman Augustine
 *
 * Minesweeper game main driver program.
 *
 * */

public class MinesweeperTerminalMain {
    private static MinesweeperGame game;

    public static void main(String[] args) {
        // Drive the Minesweeper game
        try {

            if(args.length==0) {
                game = new MinesweeperGame(MinesweeperGame.BEGINNER);
            } else if(args.length==1) {
                game = new MinesweeperGame(args[0]);
            } else if(args.length==3) {
                game = new MinesweeperGame(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            }

            game.help();
            game.printBoard();

            run();
        } catch(RuntimeException e) {
            System.out.println("\t"+e.getMessage());
        }
    }

    // Run program until quit command
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("cmd: ");
        UserCommand cmd = new UserCommand(scanner.nextLine());
        boolean isGameOver = false;

        while(!cmd.getCommand().equals(UserCommand.QUIT)) {
            switch (cmd.getCommand()) {
                case UserCommand.LEFT:
                    isGameOver = game.left(cmd.getRow(), cmd.getCol());
                    game.printBoard();
                    break;
                case UserCommand.RIGHT:
                    game.right(cmd.getRow(), cmd.getCol());
                    game.printBoard();
                    break;
                case UserCommand.SHOW:
                    game.printBoard();
                    break;
                case UserCommand.HELP:
                    game.help();
                    break;
            }
            if(!isGameOver && game.getMovesLeft()==0) {
                System.out.println("You won!");
                break;
            }
            if(isGameOver) {
                System.out.println("You lost!");
                break;
            }
            System.out.print("cmd: ");
            cmd = new UserCommand(scanner.nextLine());
        }
    }
}
