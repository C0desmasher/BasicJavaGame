import java.util.Scanner;
public class tictactoe {
    static String names(){
        System.out.println("Enter player name");
        Scanner sc = new Scanner(System.in);
        String player1 = sc.next();
        return player1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[3][3];

        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[row].length; col++){
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean brd = false;
        boolean whowon = false;

        while (!brd){
        showBoard(board);
            System.out.print("Player " + player + " turn: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] == ' ') {
             board[row][col] = player;
             
             whowon = whoWon(board, player);
             if (whowon) {
                System.out.println("------player " + player + " Won------");
                brd = true;
             }
             else{
                // if (player == 'X') {
                //     player = 'O';
                // }                                  first method
                // else{
                //     player = 'X';
                // }
                player = (player=='X')? 'O' : 'X';    // second method
             }
            }
        }
    } 
    static boolean whoWon(char[][] board, char player){
        for(int row = 0; row<board.length; row++){
        if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
            return true;
        }
        }
        for(int col = 0; col<board.length; col++){ 
        if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
            return true;
        }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
      return false;
    }
    static void showBoard(char[][] board){
         for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[row].length; col++){
                System.out.print(board[row][col]);
                System.out.print( " | ");
            }
            System.out.println();
         }
    }
}