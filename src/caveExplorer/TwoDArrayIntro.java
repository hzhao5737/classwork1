package caveExplorer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayIntro {
	
	public static String[][] arr2D;
	public static String[][] pic;
	public static int i;
	public static int j;
	public static Scanner in;
	
	public static void main(String[] args) {
		/*createMap(5,5);
		arr2D = new String[10][8];
		pic = new String [10][8];
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				(pic[row][col]) = " ";
			}
		}
		for(int row = 0; row < arr2D.length; row++){
			
			//populate with coordinates
			for(int col = 0; col < arr2D[row].length; col++){
				arr2D[row][col] = "("+row+","+col+")";
			}
		}
		//start positions
		i = 2;
		j = 3;
		in = new Scanner(System.in);
		startExploring();
		*/
	}
	
	private static void startExploring() {
		while(true){
			printPic(pic);
			System.out.println("You are in room "+arr2D[i][j]);
			System.out.println("What do you want to do?");
			String input = in.nextLine();
			while(!isValid(input)){
				System.out.println("Please enter w, a, s, d.");
				input = in.nextLine();
			}
			interpretInput(input.toLowerCase());
		}
	}

	private static void interpretInput(String input) {
		int iOrig = i;
		int jOrig = j;
		if(input.equals("w") && i > 0)i--;
		else if(input.equals("a") && j > 0)j--;
		else if(input.equals("s") && i-1< arr2D.length)i++;
		else if(input.equals("d") && j+1< arr2D[0].length)j++;
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				(pic[row][col]) = " ";
			}
		}
		for(int col = 0; col < pic[0].length; col++){
			pic[0][col] = "_";
			pic[pic.length-1][col] = "_";
		}

		for(int row = 1; row < pic.length; row++){
			pic[row][0] = "|";
			pic[row][pic[0].length-1] = "|";
		}
		pic[i][j] = "X";
		if(iOrig == i && jOrig == j){
			System.out.println("You are at the edge og the universe. You can move no further in that direction.");
		}
	}

	private static boolean isValid(String input) {
		String lc = input.toLowerCase();
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if(key.equals(lc)){
				return true;
			}
		}
		return false;
	}

	private static void mines(){
		boolean[][] mines = new boolean[6][6];
		createMines(mines, 10);
		String[][] field = new String[mines.length][mines[0].length];
		matchValues(field, mines);
		printPic(field);
	}
	
	private static void createMap(int row, int col){
		String[][] map = new String[row*3+1][col*3+1];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				(map[i][j]) = " ";
			}
		}
		for(int j = 0; j < map[0].length; j++){
			for(int third = 0; third < row*3; third+=3){
				map[third][j] = "_";
			}
			//map[3][j] = "_";
			map[map.length-1][j] = "_";
		}

		for(int i = 1; i < map.length; i++){
			for(int third = 0; third < col*3; third+=3){
				map[i][third] = "|";
			}
			//map[i][0] = "|";
			map[i][map[0].length-1] = "|";
		}
		
		printPic(map);
	}

	private static void matchValues(String[][] field, boolean[][] mines) {
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[row].length; col++){
				if(mines[row][col]){
					field[row][col] = "X";
				}
				else{
					field[row][col] = countAdjacent(mines, row, col);
				}
			}
		}
	}

	private static String countAdjacent(boolean[][] mines, int r, int c){
		//r and c represent coordinates of element we are providing a String for
		int count = 0;
		//loop through row above to row below
		/*for(int row = r-1; row <= r+1; row++){
			//loop through col left to col right
			for(int col = c-1; col <= c+1; col++){
				//exclude this element when counting
				if(row !=r && col != c){
					if(row >=0 && row < mines.length && col >= 0 && col < mines[row].length){
						
					}
				}
			}
		}*/
		//this method only checks elements in the [][] so it is not necessary to verify they are valid
		
		/*for(int row = 0; row < mines.length; row++){
			for(int col = 0; col < mines[row].length; col++){
				//checks taxi cab distance and checks if true
				if(Math.abs(row - r)+Math.abs(col - c) == 1 && mines[row][col]){
					count++;
				}
			}
		}*/
		//this method is helpful when you want to be very specific
		
		//above
		count+=validAndTrue(mines,r-1,c);
		//below
		count+=validAndTrue(mines,r+1,c);
		//right
		count+=validAndTrue(mines,r,c+1);
		//left
		count+=validAndTrue(mines,r,c-1);
		
		return count +"";
	}

	private static int validAndTrue(boolean[][] mines, int i, int j) {
		//checks valid and checks if true (AFTER checking validity)
		if(i>=0 && i<mines.length && j>=0 && j < mines[0].length && mines[i][j]){
			return 1;
		}
		return 0;
	}

	private static void createMines(boolean[][] mines, int numberOfMines) {
		while(numberOfMines > 0){
			int row = (int)(Math.random()*mines.length);
			int col = (int)(Math.random()*mines[0].length);
			if(!mines[row][col]){
				mines[row][col] = true;
				numberOfMines --;
			}
		}
	}

	public static void intro(){
		int[] arr = {0,1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(arr));

		//rows, columns
		String[][] arr2D = new String[4][3];
		//iterate row  by row
		for(int row = 0; row < arr2D.length; row++){
			//in each row, go col by col
			for(int col = 0; col < arr2D[row].length; col++){
				arr2D[row][col] = "("+row+","+col+")";
			}
		}
		//print each row
		for(String[]row: arr2D){
			System.out.println(Arrays.toString(row));
		}
	}

	public static void picDrawing(){
		String[][] pic = new String[10][8];
		for(int row = 0; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				(pic[row][col]) = " ";
			}
		}

		for(int row = 0; row < pic.length; row++){
			for(int col = 4; col < pic[row].length-3; col++){
				if(Math.random() > .8){
					(pic[row][col]) = "O";
					(pic[row][col+1]) = "v";
					(pic[row][col+2]) = "O";
				}
			}
		}

		pic[1][2] = "O";
		pic[0][2] = "|";
		pic[2][2] = "|";
		pic[1][1] = "-";
		pic[1][3] = "-";
		pic[0][1] = "\\";
		pic[2][3] = "\\";
		pic[0][3] = "/";
		pic[2][1] = "/";

		for(int row = 7; row < pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				(pic[row][col]) = "M";
			}
		}

		for(int col = 0; col < pic[0].length; col++){
			pic[0][col] = "_";
			pic[pic.length-1][col] = "_";
		}

		for(int row = 1; row < pic.length; row++){
			pic[row][0] = "|";
			pic[row][pic[0].length-1] = "|";
		}


		printPic(pic);
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
