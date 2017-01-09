package caveExplorer;

import java.util.Scanner;

public class ConnectFour {

	public static String[][] board = new String[6][8];
	public static Scanner in;

	public static void main(String[] args) {
		startExploring();
	}

	private static void startExploring() {
		while(true){
			printPic(board);
			String input = in.nextLine();
			while(!isValid(input)){
				System.out.println("Please enter 1-8.");
				input = in.nextLine();
			}
			interpretInput(input);
		}
	}

	private static void interpretInput(String input) {
		int row = board.length;
		int col = Integer.parseInt(input);
		if(board[0][col] == "0"){
			System.out.println("Col already full.");
		}
		else{
			while(board[row][col] == "0"){
				row--;
			}
			board[row][col] = "0";
		}
	}

	private static boolean isValid(String input) {
		int x = Integer.parseInt(input);
		for(int i = 1; i < board[0].length; i++){
			if(x == i)
				return true;
		}
		return false;
	}

	public static void printPic(String[][] pic){
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}
}
