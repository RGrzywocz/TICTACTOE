package tictactoe;
import javax.print.DocFlavor;
import java.util.*;
class TicTacaToe{
    String[][] board={{" "," "," "},{" "," "," "},{" "," "," "}};
    static boolean xTurn=true;
    void move(){
        Scanner input=new Scanner(System.in);
        boolean noInput=true;
        int column;
        int row;
        while (noInput){
            try{
                System.out.println("Enter the coordinates:");
                column=input.nextInt();
                row=input.nextInt();

                if(column>0&&column<4&&row>0&&row<4){
                    if(!board[column-1][row-1].equals(" ")){
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    board[column-1][row-1]=(xTurn?"X":"O");
                    noInput=false;
                    xTurn=!xTurn;
                    input.close();
                }
                System.out.println("Coordinates should be from 1 to 3!");
            }
            catch (Exception e){
                System.out.println("You should enter numbers!");
            }
        }
    }
    void drawBoard(){
        System.out.println("---------");
        System.out.println("| "+board[0][2]+" "+board[1][2]+" "+board[2][2]+" |");
        System.out.println("| "+board[0][1]+" "+board[1][1]+" "+board[2][1]+" |");
        System.out.println("| "+board[0][0]+" "+board[1][0]+" "+board[2][0]+" |");
        System.out.println("---------");
    }
    boolean xWin(){
        if(board[0][0].equals("X")&&board[0][1].equals("X")&&board[0][2].equals("X")) return true;
        if(board[1][0].equals("X")&&board[1][1].equals("X")&&board[1][2].equals("X")) return true;
        if(board[2][0].equals("X")&&board[2][1].equals("X")&&board[2][2].equals("X")) return true;
        if(board[0][0].equals("X")&&board[1][0].equals("X")&&board[2][0].equals("X")) return true;
        if(board[0][1].equals("X")&&board[1][1].equals("X")&&board[2][1].equals("X")) return true;
        if(board[0][2].equals("X")&&board[1][2].equals("X")&&board[2][2].equals("X")) return true;
        if(board[0][0].equals("X")&&board[1][1].equals("X")&&board[2][2].equals("X")) return true;
        if(board[2][0].equals("X")&&board[1][1].equals("X")&&board[0][2].equals("X")) return true;
        return false;
    }
    boolean oWin(){
        if(board[0][0].equals("O")&&board[0][1].equals("O")&&board[0][2].equals("O")) return true;
        if(board[1][0].equals("O")&&board[1][1].equals("O")&&board[1][2].equals("O")) return true;
        if(board[2][0].equals("O")&&board[2][1].equals("O")&&board[2][2].equals("O")) return true;
        if(board[0][0].equals("O")&&board[1][0].equals("O")&&board[2][0].equals("O")) return true;
        if(board[0][1].equals("O")&&board[1][1].equals("O")&&board[2][1].equals("O")) return true;
        if(board[0][2].equals("O")&&board[1][2].equals("O")&&board[2][2].equals("O")) return true;
        if(board[0][0].equals("O")&&board[1][1].equals("O")&&board[2][2].equals("O")) return true;
        if(board[2][0].equals("O")&&board[1][1].equals("O")&&board[0][2].equals("O")) return true;
        return false;
    }
    boolean fullBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j].equals(" "))return false;
            }
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
    TicTacaToe gra=new TicTacaToe();
    gra.drawBoard();
    while(gra.xWin()==false&&gra.oWin()==false&&gra.fullBoard()==false){
        gra.move();
        gra.drawBoard();
    }
    if(gra.xWin()==true){
        System.out.println("X wins");
    }
    else if(gra.oWin()==true){
        System.out.println("O wins");
    }
    else {
        System.out.println("Draw");
    }
    }
}
