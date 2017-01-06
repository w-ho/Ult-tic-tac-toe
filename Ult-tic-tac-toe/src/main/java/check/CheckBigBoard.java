package check;

import board.BoardHandler;

public class CheckBigBoard extends Check{

    public boolean notKnownBigBoardPosition(Integer place, Integer place2, BoardHandler boardHandler) {
           if ( place == null){
                  return true;
           }
           if (isDraw(boardHandler.bigBoard[place-1][place2-1])){
                  return true; 
            }
           return false;
    }
    
    public boolean winner(BoardHandler board) {
     if ((rowWinner(board) || columnWinner(board) || crossWinner(board)))
         return true;
     return false;
 }
    
    public boolean placeAvaible(Integer place, Integer place2,BoardHandler board){
           if ((!(board.bigBoard[place-1][place2-1].smallBoardWinner == 1) || !(board.bigBoard[place-1][place2-1 ].smallBoardWinner == 10))  || placeWithinArray( place,place2, board)){
                  return true;
           }
           return false;
    }
    
    private boolean rowWinner(BoardHandler board) {
           int count = 0;
           int count1 = 0;
           int count2 = 0;
           
           for (int i = 0; i < 3; i++) {
                  count += board.bigBoard[0][i].smallBoardWinner;
                  count1 += board.bigBoard[1][i].smallBoardWinner;
                  count2 += board.bigBoard[2][i].smallBoardWinner;
           }
           if (count == 3 || count == 30) {
                  return true;
           }
           
           if (count1 == 3 || count1 == 30) {
                  return true;
           }
           
           if (count2 == 3 || count2 == 30) {
                  return true;
           }
           
           return false;
    }

    private boolean columnWinner(BoardHandler board){
           int count = 0;
           int count1 = 0;
           int count2 = 0;
           
           for (int i = 0; i < 3; i++) {
                  count += board.bigBoard[i][0].smallBoardWinner;
                  count1 += board.bigBoard[i][1].smallBoardWinner;
                  count2 += board.bigBoard[i][2].smallBoardWinner;
           }
           
           if (count == 3 || count == 30) {
                  return true;
           }
           
           if (count1 == 3 || count1 == 30) {
                  return true;
           }
           
           if (count2 == 3 || count2 == 30) {
                  return true;
           }
           return false;
    }
                  
    
    private boolean crossWinner(BoardHandler board){
           int count = 0;
           int count1 = 0;
           
           count += board.bigBoard[0][0].smallBoardWinner;
           count += board.bigBoard[1][1].smallBoardWinner;
           count += board.bigBoard[2][2].smallBoardWinner;
           
           count1 += board.bigBoard[2][1].smallBoardWinner;
           count1 += board.bigBoard[1][1].smallBoardWinner;
           count1 += board.bigBoard[1][2].smallBoardWinner;
           
           if (count == 3 || count == 30) {
                  return true;
           }
           if (count1 == 3 || count1 == 30) {
                  return true;
           }
           return false;
           
    }

}
