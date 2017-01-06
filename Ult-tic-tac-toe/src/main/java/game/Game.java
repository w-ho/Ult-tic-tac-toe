package game;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.Board;
import check.Check;
import player.Player;

public class Game {

    protected Scanner scanner = new Scanner(System.in);
    Board board = new Board();
    protected Player player = new Player();
    protected Check check = new Check();
    
    int place;
    int place2;

    public Game(){}

    public void play (){
        boolean endGame = false;
        board.display();
        while(!endGame){
            try {
              intakeValue();
                if (check.placeAvaible(place, place2, board)) {
                    board.updatefield(place, place2, player);
                    board.display();
                    if (check.winner(board)) {
                        endGame = true;
                    } else if (check.isDraw(board)) {
                        draw();
                    }
                    player.changePlayer();
                } else {
                    System.out.println("This place is not avaible");
                }
            }catch (InputMismatchException e){
                endGame = true;
                System.out.println("You enter a a non number, You lose!");
            }
        }
        player.changePlayer();
        System.out.println("The winner is " + player.getPlayer());
        scanner.close();
    }

    private void intakeValue(){
        System.out.println("Enter the number of row then column");
        place = scanner.nextInt();
        place2 = scanner.nextInt();
    }

    protected void draw(){
        System.out.println("Draw, both team lose");
        System.exit(0);
    }
}
