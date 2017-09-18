import java.util.Random;

/**
 * Created by bigmanstan on 18/9/17.
 */
public class Game {

    private Board board;
    private Random random;

    public Game(){
        initializeGame();
        displayBoard();
        makeFirstMove();
        playGame();
        checkStatus();

    }

    private void makeFirstMove(){

    }

    private void displayBoard(){
        this.board.displayBoard();
    }

    private void checkStatus(){
        if (board.isWinning(Player.COMPUTER)){
        System.out.println();}
        else if ( board.isWinning(Player.USER)){
        System.out.println("User has won");}
        else{
            System.out.println("Its a draw");
        }

    }

    public void initializeGame(){
        this.board=new Board();
        this.board.setupBoard();
        this.random = new Random();

    }
}
