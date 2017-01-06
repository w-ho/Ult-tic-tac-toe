package game;

import java.util.InputMismatchException;

import board.BoardHandler;
import check.CheckBigBoard;

public class BigGame extends Game {

	BoardHandler boardHandler = new BoardHandler();
	CheckBigBoard checkBigBoard = new CheckBigBoard();

	Integer bigplace = null;
	Integer bigplace2 = null;
	Integer smplace3 = null;
	Integer smplace4 = null;

	boolean endGame = false;

	public void play() {
		boardHandler.displayBigBoard();
		while (!endGame) {
			try {
				autoSetBigBoard();
				findBigBoardPlace();
				if (checkBigBoard.placeAvaible(bigplace, bigplace2, boardHandler)) {
					findSmallBoardPlace();
				}
				if (check.placeAvaible(smplace3, smplace4, boardHandler.bigBoard[bigplace - 1][bigplace2 - 1])) {
					turnPlacer();
					CheckforWinner();
					player.changePlayer();
					bigplace = smplace3;
					bigplace2 = smplace4;
				} else {
					System.out.println("This place is not available");
					System.out.println("Enter the number of row then column of the Big Board");
					bigplace = scanner.nextInt();
					bigplace2 = scanner.nextInt();
					smplace3 = null;
					smplace4 = null;
				}
			} catch (InputMismatchException e) {
				endGame = true;
				System.out.println("You entered a non-number, You lose!");
			}
		}
		printWinner();
		scanner.close();
	}

	public void intro() {
		System.out.println(
				"Welcome to ultimate tic-tac-toe. \nThe reason it is called ultimate is because we use a 3x3 board"
						+ "but within each box is an extra 3x3 tic-tac-toe game.\nYou can win by winning on the small board to get 3 in a "
						+ " row in the bigger board. \n \n \nHowever, here is where it gets interesting where ever your opponent goes"
						+ " in the small board, you are have to go that board in the big board is your next move and vice versa."
						+ "\n \n \n Good luck and Have fun. ");
	}


	private void turnPlacer() {
		boardHandler.updatefield(bigplace, bigplace2, smplace3, smplace4, player);
		boardHandler.displayBigBoard();

	}

	private void printWinner() {
		player.changePlayer();
		System.out.println("The winner is " + player.getPlayer());
	}

	private void CheckforWinner() {
		if (check.winner(boardHandler.bigBoard[bigplace - 1][bigplace2 - 1])) {
			boardHandler.setSmallBoardWinner(player, boardHandler.bigBoard[bigplace - 1][bigplace2 - 1]);
			CheckForOverallWinner();
		} else if (check.isDraw(boardHandler)) {
			draw();
		}
	}

	private void CheckForOverallWinner() {
		if (checkBigBoard.winner(boardHandler)) {
			endGame = true;
		}
	}

	private void findSmallBoardPlace() {
		System.out.println(
				"Enter the number of row then column of the Small Board of place " + bigplace + " " + bigplace2);
		smplace3 = scanner.nextInt();
		smplace4 = scanner.nextInt();
	}

	private void findBigBoardPlace() {
		if (bigplace == null) {
			System.out.println("Enter the number of row then column of the Big Board");
			bigplace = scanner.nextInt();
			bigplace2 = scanner.nextInt();
		}
	}

	private void autoSetBigBoard() {
		if (checkBigBoard.notKnownBigBoardPosition(bigplace, bigplace2, boardHandler)) {
			bigplace = null;
			bigplace2 = null;
		} else {
			bigplace = smplace3;
			bigplace2 = smplace4;
		}
	}

}
