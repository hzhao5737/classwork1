package array;

public class ArrayAndArrayList {

	public static void main(String[] args) {
		numberOne();
		numberTwo();
		numberThree();
		numberFour();
	}

	private static void numberOne(){
		int[] string = new int[50];
		for (int i = 0; i < string.length; i++){
			string[i] = (i+1);
			System.out.println(string[i]);
		}
	}
	
	private static void numberTwo(){
		int[] string = new int[10];
		for (int i = 0; i < string.length; i++){
			string[i] = (int) (1+(6 *(Math.random())));
			System.out.println("2 " +string[i]);
		}
	}
	
	private static void numberThree(){
		int[] string = new int[50];
		for (int i = 0; i < string.length; i++){
			string[i] = (int) (1+(6 *(Math.random()))) + (int) (1+(6 *(Math.random())));
			System.out.println("3 " +string[i]);
		}
	}
	
	private static void numberFour(){
		for (int i = 1; i < 14; i++){
			System.out.println(i+ " of diamonds");
		}
		for (int i = 1; i < 14; i++){
			System.out.println(i+ " of clubs");
		}
		for (int i = 1; i < 14; i++){
			System.out.println(i+ " of hearts");
		}
		for (int i = 1; i < 14; i++){
			System.out.println(i+ " of spades");
		}
	}
}