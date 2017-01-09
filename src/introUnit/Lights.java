package introUnit;

public class Lights {

	private static boolean[][] array;

	public static void main(String[] args) {
		array = new boolean [5][5];
		printGrid(array);
		buttonClick(3,3);
		printGrid(array);
		buttonClick(3,3);
		printGrid(array);
	}

	public static void switchRow(boolean[] row, int x){
		if(x >=0 && x < row.length){
			for(int i = -1; i < 2; i++){
				if(x+i >= 0 && x+i < row.length){
					row[x+i] = !row[x+i];
				}
			}
		}
	}

	public static void switchColumn(boolean[][] grid, int r, int c){
		switchIfValid(grid, r-1, c);
		switchIfValid(grid, r+1, c);
	}
	
	public static void switchIfValid(boolean[][] grid, int r, int c){
		if(r >= 0 && r < grid.length && c >= 0 && c < grid[r].length){
			grid[r][c] = !grid[r][c];
		}
	}

	public static void buttonClick(int r, int c) {
		if(r >= 0 && r < array.length){//not on rubric
			switchRow(array[r],c);
		}
		switchColumn(array, r, c);//one point
		//check if any lights are on
		boolean win = true;
		A: for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				//1 of 2 points
				if(array[i][j]){//1 of 2 points
					win = false;
					break A;
				}
			}
		}
		if(win){
			System.out.println("You have solved the puzzle!");
		}
	}

	public static void printGrid(boolean[][] grid){
		for(int i = 0; i < grid.length; i++){
			for(int k = 0; k < grid[i].length; k++){
				if(grid[i][k] == true){
					System.out.print("O");
				}
				else{
					System.out.print("X");
				}
			}
			System.out.print("\n");
		}
	}
}
