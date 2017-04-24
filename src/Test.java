import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		String[] r = {"Joe", "Kim", "Chris"};
		int[][] g1 = {{80, 90, 90, 100, 70},
				{90, 60, 75, 80, 80},
				{100, 90, 96, 98, 99}};
		System.out.println(bestAverage(r, g1));
		int[][] g2 ={{-3, 4, -8},           
				{14, 2, 21},
				{3, 32, -3}};
		printArray2(removeRowCol(g2, 1, 1));
		int[][] g ={{9, 8, 7, 6},           
	   	         {5, 4, 2, 1},
	   	         {3, 9, 2, 3}};
		printArray(getNeighbors(g, 2, 2));
	}
	
	private static void printArray(int[] neighbors) {
		for(int i = 0; i < neighbors.length; i++){
			System.out.print(neighbors[i] + ",");
		}
	}

	public static int[] getNeighbors(int[][] grid, int row, int col){
        ArrayList<Integer> ints = new ArrayList<Integer>();
        if(row - 1 >= 0 && col - 1 >= 0){
            ints.add(grid[row-1][col-1]);
        }
        if(row - 1 >= 0){
            ints.add(grid[row-1][col]);
        }
        if(row - 1 >= 0 && col + 1 < grid[0].length){
            ints.add(grid[row-1][col+1]);
        }
        if(col - 1 >= 0){
            ints.add(grid[row][col-1]);
        }
        if(col + 1 < grid[0].length){
            ints.add(grid[row][col+1]);
        }
        if(row + 1 < grid.length && col - 1 >= 0){
            ints.add(grid[row+1][col-1]);
        }
        if(row + 1 < grid.length){
            ints.add(grid[row+1][col]);
        }
        if(row + 1 < grid.length && col + 1 < grid[0].length){
            ints.add(grid[row+1][col+1]);
        }
        int[] array = new int[ints.size()];
        array = ints.stream().mapToInt(i->i).toArray();
        return array;
    }

	public static int[][] removeRowCol(int[][] mat, int row, int col){
		int[][] nothing = new int[mat.length-1][mat[0].length-1];
		int insertr = 0;
		for(int i = 0; i < mat.length; i++){
			int insertk = 0;
			if(i == row){
				i++;
				if(i == mat.length){
					break;
				}
			}
			for(int k = 0; k < mat[i].length; k++){
				if(k == col){
					k++;
					if(k == mat[i].length){
						break;
					}
				}
				nothing[insertr][insertk] = mat[i][k];
				insertk++;
			}
			insertr++;
		}
		return nothing;
	}

	public static String bestAverage(String[] roster, int[][] grades){
		String name = "";
		int highest = 0;
		for(int i = 0; i < grades.length; i++){
			int average = 0;
			int sum = 0;
			for(int k = 0; k < grades[i].length; k++){
				sum += grades[i][k];
			}
			average = sum / grades[i].length;
			if(average > highest){
				highest = average;
				name = roster[i];
			}
		}
		return name;
	}

	public static void printArray2(int[][] array){
		for(int i = 0; i < array.length; i++){
			for(int k = 0; k < array[i].length; k++){
				System.out.print(array[i][k] + ",");
			}
			System.out.println("");
		}
	}
}
