package symposium;

public class Moves {

	public String move;
	public int power;
	public int accuracy;
	public int type;
	public int which;
	public int pp;
	public int currentpp;
	public String action;
	
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
			power = 50;
			accuracy = 100;
			type = 0;
			which = 1;
			pp = 10;
			currentpp = pp;
			action = "Recoil 1/2";
			break;
		case "Tackle":
			power = 35;
			accuracy = 95;
			type = 0;
			which = 1;
			pp = 35;
			currentpp = pp;
			action = "";
			break;
		case "Solar Beam":
			power = 120;
			accuracy = 100;
			type = 10;
			which = 2;
			pp = 10;
			currentpp = pp;
			action = "Skip First Turn";
			break;

		case "Razor Leaf":
			power = 55;
			accuracy = 95;
			type = 10;
			which = 2;
			pp = 25;
			currentpp = pp;
			action = "Crit";
			break;

		case "Vine Whip":
			power = 35;
			accuracy = 100;
			type = 10;
			which = 2;
			pp = 10;
			currentpp = pp;
			action = "";
			break;
		case "Rage":
			power = 20;
			accuracy = 100;
			type = 0;
			which = 1;
			pp = 20;
			currentpp = pp;
			action = "Rage";
			break;
		case "Slash":
			power = 70;
			accuracy = 100;
			type = 0;
			which = 1;
			pp = 20;
			currentpp = pp;
			action = "";
			break;
		case "Flamethrower":
			power = 95;
			accuracy = 100;
			type = 8;
			which = 2;
			pp = 15;
			currentpp = pp;
			action = "";
			break;
		case "Fire Spin":
			power = 15;
			accuracy = 70;
			type = 8;
			which = 2;
			pp = 15;
			currentpp = pp;
			action = "";
			break;
		}
	}
}

