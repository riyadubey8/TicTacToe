import java.util.Scanner;

class TicTacToe{
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String playAgain = "Yes";
        

        while(playAgain.equalsIgnoreCase("Yes")){
            initializeBoard();
            boolean gameEnded = false;

            while(!gameEnded){
                printBoard();
                makeMove(scanner);

                if(checkWin()){
                    gameEnded = true;
                    System.out.println("Player "+ currentPlayer+ " wins!");
                    break;
                } else if(checkDraw()){
                    gameEnded = true;
                    System.out.println("Its a draw!");
                    break;
                } else {
                    switchPlayer();
                }
            }
            System.out.println("Play again? (Yes/No)");
            playAgain = scanner.nextLine();   
        }  
    }

    private static void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard(){
        System.out.println("-------------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void makeMove(Scanner scanner){
        int row, col;
        while(true){
            System.out.println("Player:" + currentPlayer + " , enter row (1-3) and column (1-3): ");
            row = scanner.nextInt() -1;
            col = scanner.nextInt() - 1;
            scanner.nextLine();

            if(row >= 0 && row < 3 && col >= 0 && col < 3){
                if(board[row][col] == ' '){
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("Looks like that spot is already taken, try again!");
                }
            } else {
                System.out.println("Invalid input! Try again!");
            }
        }
    }

    private static boolean checkWin(){
        for(int i = 0; i < 3; i++){
            if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2]== currentPlayer){
                return true;
            } else if(board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i]== currentPlayer){
                return true;
            }
        }

        if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2]== currentPlayer){
            return true;
        } else if(board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0]== currentPlayer){
            return true;
        }

        return false;
    }

    private static boolean checkDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer(){
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}