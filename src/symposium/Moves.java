package symposium;

public class Moves {

	public String move;
	public int power;
	public int accuracy;
	public int type;
	public int which;
	public int pp;
	public int currentpp;
	
	/* 0 normal
	 * 1 fight
	 * 2 flying
	 * 3 poison
	 * 4 ground
	 * 5 rock
	 * 6 bug
	 * 7 ghost
	 * 8 fire
	 * 9 water
	 * 10 grass
	 * 11 electric
	 * 12 psychic
	 * 13 ice
	 * 14 dragon
	 */

	public Moves(String move) {
		this.move = move;
		switch(move){
		case "Struggle":
			power = 25;
			accuracy = 100;
			type = 0;
			which = 1;
			pp = 10;
			currentpp = pp;
			break;
		case "Tackle":
			power = 35;
			accuracy = 95;
			type = 0;
			which = 1;
			pp = 35;
			currentpp = pp;
			break;
		case "Solar Beam":
			power = 120;
			accuracy = 100;
			type = 10;
			which = 2;
			pp = 10;
			currentpp = pp;
			break;

		case "Razor Leaf":
			power = 55;
			accuracy = 95;
			type = 10;
			which = 2;
			pp = 25;
			currentpp = pp;
			break;

		case "Vine Whip":
			power = 35;
			accuracy = 100;
			type = 10;
			which = 2;
			pp = 10;
			currentpp = pp;
			break;
		}
	}
}

