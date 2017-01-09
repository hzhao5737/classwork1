package dataTypes;

import java.util.Random;

public class MathRandom {

	public static void main(String[] args) {
		int [] results = new int[6];
		//same as
		//int[] results = {0,0,0,0,0,0};

		int totalRolls = 10000;
		for(int index = 0; index < totalRolls; index++){
			int roll = rollUnfairDie();
			System.out.println("Roll #"+(index+1)+" Die is "+rollUnfairDie());
			results[roll -1]++;
		}
		for(int i = 0; i < 6; i ++){
			double percentage = (int) (1000*(double)results[i]/totalRolls)/10.0;
			System.out.println((i+1)+" was rolled "+percentage+"%.");
		}

		String draw = drawCard();{
			System.out.println("The "+draw+" of "+rollSuit()+".");
		}
	}

	public static int rollFairDie(){
		//		Random gen = new Random();
		//		return gen.nextInt(6)+1;
		double rand = Math.random();//random double (0,1)
		int roll = (int) (6 * rand);//[0,5] (this is what above code does)
		return roll +1;//0 becomes 1, 5 becomes 6
	}

	public static int rollUnfairDie(){
		double rand = Math.random();
		double counter = Math.random();
		int count = (int) (2 * counter);
		int roll = (int) (6 * rand);
		if (((roll == 0) || (roll == 2) || (roll == 4)) && (count == 1)){
			roll++;
		}
		return roll +1;
	}

	public static String drawCard(){
		double rand = Math.random();
		int roll = (int) (13 * rand);
		if (roll == 0){
			return "Ace";
		}
		if (roll == 10){
			return "Jack";
		}
		if (roll == 11){
			return "Queen";
		}
		if (roll == 12){
			return "King";
		}
		if (roll == 1){
			return "2";
		}
		if (roll == 2){
			return "3";
		}
		if (roll == 3){
			return "4";
		}
		if (roll == 4){
			return "5";
		}
		if (roll == 5){
			return "6";
		}
		if (roll == 6){
			return "7";
		}
		if (roll == 7){
			return "8";
		}
		if (roll == 8){
			return "9";
		}
		if (roll == 9){
			return "10";
		}
		return null;
	}

	public static String rollSuit() {
		double rand = Math.random();
		int roll = (int) (4 * rand);
		if (roll == 0){
			return "Diamonds";
		}
		if (roll == 1){
			return "CLubs";
		}
		if (roll == 2){
			return "Hearts";
		}
		if (roll == 3){
			return "Spades";
		}
		return null;
	}
}
