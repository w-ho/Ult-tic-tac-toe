package board;

import player.Player;

public class BoardHandler extends Board {

    public Board[][] bigBoard = new Board[length][length];

    public BoardHandler() {
           for (int i = 0; i < bigBoard.length; i++) {
                  for (int j = 0; j < bigBoard.length; j++) {
                        bigBoard[i][j] = new Board();
                  }
           }
    }

    public void displayBigBoard() {
           for (int i = 0; i < bigBoard.length; i++) {
                  String checker = "";
                  for (int j = 0; j < bigBoard.length; j++) {
                        checker += "\n";
                        for (int k = 0; k < playBoard.length; k++) {
                               checker += "|";
                               for (int l = 0; l < playBoard.length; l++) {
                                      checker += " " +bigBoard[i][k].playBoard[j][l] +" |";
                               }
                        }
                  }
                  System.out.println(checker);
           }
    }
    
    public void updatefield(int place, int place2, int place3, int place4, Player player){
           bigBoard[place-1][place2-1].playBoard[place3-1 ][place4-1] =  player.getPlayer();
 }

    public void setSmallBoardWinner(Player player, Board board) {
           if (player.getPlayer() == "x"){
                  board.playBoard[0][0] = "\\";
                  board.playBoard[0][1] = " ";
                  board.playBoard[0][2] = "/";
                  board.playBoard[1][0] = " ";
                  board.playBoard[1][1] = "X";
                  board.playBoard[1][2] = " ";
                  board.playBoard[2][0] = "/";
                  board.playBoard[2][1] = " ";
                  board.playBoard[2][2] = "\\";
                  board.smallBoardWinner = 1;
           } else {
                  board.playBoard[0][0] = "┌";
                  board.playBoard[0][1] = "─";
                  board.playBoard[0][2] = "┐";
                  board.playBoard[1][0] = "|";
                  board.playBoard[1][1] = " ";
                  board.playBoard[1][2] = "|";
                  board.playBoard[2][0] = "└";
                  board.playBoard[2][1] = "─";
                  board.playBoard[2][2] = "┘";
                  board.smallBoardWinner = 10;
           }
           
    }
    
    public void setSmallBoardWinnerDontLike(Player player, Board board) {
           for (int i = 0; i < playBoard.length; i++) {
                  for (int j = 0; j < playBoard.length; j++) {
                        board.playBoard[i][j] = "+player.getPlayer()+";
                  }
           }

    }

}

