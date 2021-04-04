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
            } else {
                game = new MinesweeperGame(MinesweeperGame.BEGINNER);
                StringBuilder msg = new StringBuilder("Incorrect app args: ");
                for(int i=0;i<args.length;++i)
                    msg.append(args[i]).append( i<args.length-1 ? ", " : "" );
                game.usage(msg.toString());
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
        boolean isGameOver = false;

        while(true) {
            System.out.print("cmd: ");
            UserCommand cmd = new UserCommand(scanner.nextLine());
            System.out.println();

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
