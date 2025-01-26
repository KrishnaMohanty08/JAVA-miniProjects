package JAVA.project.TicTacToe;

import java.util.*;

class Board {

    char[][] stage = new char[3][3];

    Board() {
        System.out.println("************Demo**************");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + '\0' + " ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("******Start the game*********");
    }

    public void printBoard() {
        System.out.println("**************************");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + (stage[i][j] == '\0' ? " - " :" "+ stage[i][j]) + " ");
                if (j < 2)System.out.print("|");
                else System.out.println();
            }System.out.println(" ----|---- |----");
        }
        System.out.println("**************************");
    }

    public boolean isSpotAvailable(int row, int col){
            return stage[row][col]=='\0';
        }
        public void placeMove(int row,int col,char player){
            stage[row][col]=player;
        }
    
    }
    
class Players {
    Scanner sc = new Scanner(System.in);
    
    char p1;
    
    Players(char p1) {
        this.p1 = p1;
    }
    
    void playerTurn(Board board) {
        int row, col;
        while (true) {
    
            System.out.println("Player " + p1);
            row = sc.nextInt();
            col = sc.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if(board.isSpotAvailable(row,col)){
                board.placeMove(row,col,p1);
                break;
            }else 
                System.out.println("The place is taken, try again");
        } else
            System.out.println("Invalid row or col selected");
        }
    }
}

public class tictactoe{

    public static boolean checkWin(char[][] board,char player){
        for(int i=0;i<3;i++){
            if(board[i][0] ==player && board[i][1]==player && board[i][2]==player ||
            board[0][i] ==player && board[1][i]==player && board[2][i]==player ||
            board[0][0] ==player && board[1][1]==player && board[2][2]==player ||
            board[2][0] ==player && board[1][1]==player && board[0][2]==player )
            return true;
        }
        return false;
    }
    public static void main(String[] args) {


        Board board =new Board();
        Players player1=new Players('X');
        Players player2=new Players('O');

        char currPlayer ='X';
        int turn =0;

        while(true){
            board.printBoard();

            if(currPlayer=='X'){
                player1.playerTurn(board);
            }else{
                player2.playerTurn(board);
            }
            turn++;
            if(checkWin(board.stage,currPlayer)){
                board.printBoard();
                System.out.println("Player "+currPlayer+" wins");
                break;
            }

            if(turn==9){
                board.printBoard();
                System.out.println("Its a draw");
                break;
            }

            currPlayer=(currPlayer=='X')?'O':'X';
        }
        
    }
}