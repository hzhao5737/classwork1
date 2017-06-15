package symposium;

public class Moves {

	public String move;
	public int power;
	public int accuracy;
	public int type;
	public boolean physical;
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
			physical = true;
			pp = 10;
			currentpp = pp;
			action = "Recoil 1/2";
			break;
		case "Tackle":
			power = 35;
			accuracy = 95;
			type = 0;
			physical = true;
			pp = 35;
			currentpp = pp;
			action = "";
			break;
		case "Solar Beam":
			power = 120;
			accuracy = 100;
			type = 10;
			physical = false;
			pp = 10;
			currentpp = pp;
			action = "Skip First Turn";
			break;

		case "Razor Leaf":
			power = 55;
			accuracy = 95;
			type = 10;
			physical = false;
			pp = 25;
			currentpp = pp;
			action = "Crit";
			break;

		case "Vine Whip":
			power = 35;
			accuracy = 100;
			type = 10;
			physical = false;
			pp = 10;
			currentpp = pp;
			action = "";
			break;
		case "Rage":
			power = 20;
			accuracy = 100;
			type = 0;
			physical = true;
			pp = 20;
			currentpp = pp;
			action = "Rage";
			break;
		case "Slash":
			power = 70;
			accuracy = 100;
			type = 0;
			physical = true;
			pp = 20;
			currentpp = pp;
			action = "Crit";
			break;
		case "Flamethrower":
			power = 95;
			accuracy = 100;
			type = 8;
			physical = false;
			pp = 15;
			currentpp = pp;
			action = "Burn";
			break;
		case "Fire Spin":
			power = 15;
			accuracy = 70;
			type = 8;
			physical = false;
			pp = 15;
			currentpp = pp;
			action = "Fire Wrap";
			break;
		case "Hydro Pump":
			power = 120;
			accuracy = 80;
			type = 9;
			physical = false;
			pp = 5;
			currentpp = pp;
			action = "";
			break;
		case "Skull Bash":
			power = 100;
			accuracy = 100;
			type = 0;
			physical = true;
			pp = 15;
			currentpp = pp;
			action = "Skip First Turn";
			break;
		case "Bite":
			power = 60;
			accuracy = 100;
			type = 0;
			physical = true;
			pp = 25;
			currentpp = pp;
			action = "Flinch";
			break;
		case "Water Gun":
			power = 40;
			accuracy = 100;
			type = 9;
			physical = false;
			pp = 25;
			currentpp = pp;
			action = "";
			break;
		}
	}
}

