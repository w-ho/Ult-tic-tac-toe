package check;

import board.Board;

public class Check {

    public boolean winner(Board board) {
     if ((rowWinner(board) || columnWinner(board) || crossWinner(board)))
         return true;
     return false;
 }

 public boolean placeAvaible(int place, int place2, Board board){
     if ((placeWithinArray(place, place2, board)) && (placeNotTaken(place, place2, board)))
         return true;
     return false;
 }

 public boolean isDraw(Board board){
     int counter = 0;
      for (int i = 0; i < board.playBoard.length ; i++) {
          for (int j = 0; j <  board.playBoard.length; j++) {
              if (board.playBoard[i][j].equals(" ")){
                  counter ++;
              }
          }
      }
      if ( counter == 0){
            return true;
      }
      return false;
  }

  private  boolean placeNotTaken(int place, int place2, Board board){
     if ( board.playBoard[place-1][place2-1] == (" ")){
            return true;
     }
     return false;

  }


 protected boolean placeWithinArray(int place, int place2, Board board){
     if (place > board.playBoard.length || place < 0)
         return false;
     if (place2 > board.playBoard.length || place2 < 0)
         return false;
     return true;
 }


 private boolean rowWinner(Board board) {
     if (((board.playBoard[0][0] == board.playBoard[0][1] && board.playBoard[0][1] == board.playBoard[0][2]) && board.playBoard[0][0] != " " )||
             ((board.playBoard[1][0] == board.playBoard[1][1] && board.playBoard[1][1] == board.playBoard[1][2]) && board.playBoard[1][0] != " " )||
                     ((board.playBoard[2][0] == board.playBoard[2][1] && board.playBoard[2][1] == board.playBoard[2][2] && board.playBoard[2][0] != " " )))
         return true;
     return false;
 }

 private boolean columnWinner(Board board) {
     if (((board.playBoard[0][0] == board.playBoard[1][0] && board.playBoard[1][0] == board.playBoard[2][0]) && board.playBoard[0][0] != " " ) ||
             ((board.playBoard[0][1] == board.playBoard[1][1] && board.playBoard[1][1] == board.playBoard[2][1]) && board.playBoard[0][1] != " " )||
             ((board.playBoard[0][2] == board.playBoard[1][2] && board.playBoard[1][2] == board.playBoard[2][2] && board.playBoard[0][2] != " " )))
         return true;
     return false;
 }

 private boolean crossWinner(Board board) {
     if (((board.playBoard[0][0] == board.playBoard[1][1] && board.playBoard[1][1] == board.playBoard[2][2]) && board.playBoard[0][0] != " " ) ||
             ((board.playBoard[0][2] == board.playBoard[1][1] && board.playBoard[1][1] == board.playBoard[2][0] && board.playBoard[0][2] != " " )))
         return true;
     return false;
 }

}
