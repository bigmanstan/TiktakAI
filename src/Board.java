import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bigmanstan on 17/9/17.
 */
public class Board {
    private List<Cell> emptyCells;
    private Scanner scanner;
    private Player[][] board;
    private List<Cell> rootValues;

    public Board() {
        initializeBoard();

    }

    public void initializeBoard() {
        this.rootValues = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.board = new Player[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    }

    public boolean isRunning() {
        if (isWinnng(Player.COMPUTER)) return false;
        if (isWinnng(Player.USER)) return false;
        if (getEmptyCells().isEmpty()) return false;

        return true;

    }

    public List<Cell> getEmptyCells(){
        emptyCells = new ArrayList<>();

        for (int i=0;i<Constants.BOARD_SIZE;i++){

            for (int j=0;j<Constants.BOARD_SIZE;j++){
                if(board[i][j]==Player.NONE){
                    emptyCells.add(new Cell(i,j));
                }
            }
        }
        return emptyCells;
    }

    private boolean isWinnng(Player player) {

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {

            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;

            }
        }
        return false;
    }
    public void move(Cell cell,Player player){
        this.board[cell.getX()][cell.getY()] = player;
    }

    public Cell getBestMove(){
        int max = Integer.MIN_VALUE;
        int best = Integer.MIN_VALUE;

        for (int i=0;i<rootValues.size();i++){
            if (max < rootValues.get(i).getMinimaxValue()){
                max = rootValues.get(i).getMinimaxValue();
                best = i;
            }
        }
        return rootValues.get(best);
    }

    public void makeUserInput(){
        System.out.println("User's input");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Cell cell = new Cell(x,y);
        move(cell, Player.USER);
    }

    public void displayBoard(){

        System.out.println();

        for (int i=0;i<Constants.BOARD_SIZE;i++){

            for (int j=0;j<Constants.BOARD_SIZE;j++){
             System.out.print(board[i][j]+" ");

        }
        System.out.println();
    }

}

     public int returnMin(List<Integer> list){

        int min = Integer.MAX_VALUE;
        int index = Integer.MIN_VALUE;

        for (int i=0;i<list.size();i++){
            if (list.get(i)  < min){
                min=list.get(i);
                index=i;

            }
        }
         return list.get(index);
    }


    public int returnMax(List<Integer> list){

        int max = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;

        for (int i=0;i<list.size();i++){
            if (list.get(i) > max){
                max=list.get(i);
                index=i;

            }
        }
        return list.get(index);
    }
    public void callMinmax(int depth, Player player){
        rootValues.clear();
        minimax(depth,player);

    }

    private int minimax(int depth,Player player){
        if (isWinnng(Player.COMPUTER) ) return +1;
        if (isWinnng(Player.USER) ) return -1;
        List<Cell> availableCells = getEmptyCells();

        if (availableCells.isEmpty() ) return 0;

        List<Integer> scores = new ArrayList<>();

        for(int i=0;i<availableCells.size();i++){
            Cell point = availableCells.get(i);

            if(player == Player.COMPUTER ){
                move(point, Player.COMPUTER);
                int currentScore =minmax(depth+1,Player.USER);
                scores.add(currentScore);

                if (depth== 0){
                    point.setMinimaxValue(currentScore);
                    rootValues.add(point);
                    
                }
            }
        }
    }

    }
    public void setupBoard(){
        for (int i=0;i<Constants.BOARD_SIZE;i++){
            for (int j=0;j<Constants.BOARD_SIZE;j++){
                board[i][j] =Player.NONE;

        }
    }
}

    public void setEmptyCells(List<Cell> emptyCells) {
        this.emptyCells = emptyCells;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Player[][] getBoard() {
        return board;
    }

    public void setBoard(Player[][] board) {
        this.board = board;
    }

    public List<Cell> getRootValues() {
        return rootValues;
    }

    public void setRootValues(List<Cell> rootValues) {
        this.rootValues = rootValues;
    }