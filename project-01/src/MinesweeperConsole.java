import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Iman Augustine
 *
 * Minesweeper game main driver program.
 *
 * */

public class MinesweeperConsole {

    // Game
    private static Game game;

    public static void main(String[] args) {
        // Drive the Minesweeper game
        try {
            if(args.length==0) {
                game = new Game(Game.BEGINNER);
            } else if(args.length==1) {
                game = new Game(args[0]);
            } else if(args.length==3) {
                game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            } else {
                Game.usage("Incorrect app args: " + Arrays.toString(args));
            }

            System.out.println(Game.help());
            System.out.println(game);

            run();
        } catch(RuntimeException e) {
            System.out.println("\t"+e.getMessage());
        }
    }

    // Run program until quit command
    private static void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;

        while(true) {
            System.out.print("cmd: ");
            UserCommand cmd = new UserCommand(scanner.nextLine());
            System.out.println();

            switch (cmd.getCommand()) {
                case UserCommand.LEFT:
                    isGameOver = game.left(cmd.getRow(), cmd.getCol());
                    System.out.println(game);
                    break;
                case UserCommand.RIGHT:
                    game.right(cmd.getRow(), cmd.getCol());
                    //game.printBoard();
                    System.out.println(game);
                    break;
                case UserCommand.SHOW:
                    System.out.println(game);
                    break;
                case UserCommand.HELP:
                    System.out.println(Game.help());
                    break;
                case UserCommand.QUIT:
                    if(!game.isMined())
                        System.out.println("the field will be mined after the first left click");
                    System.out.println("Next time you will be better\nBye\n");
                    System.exit(0);
                    break;
            }
            // Game is not over and no moves left, you won!
            if(!isGameOver && game.getMovesLeft()==0) {
                System.out.println("\nCongratulations!\nBye\n");
                break;
            }
            // Game is over, you lost!
            if(isGameOver) {
                System.out.println("\nNext time you will be better\nBye\n");
                break;
            }
        }
    }
}