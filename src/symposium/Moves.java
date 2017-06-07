package symposium;

public class Moves {

	public String move;
	public int power;
	public int accuracy;
	public int type;
	public int which;

	public Moves(String move) {
		this.move = move;
		switch(move){
		case "Tackle":
			power = 35;
			accuracy = 100;
			type = 0;
			which = 1;
			break;
		case "Solar Beam":
			power = 120;
			accuracy = 100;
			type = 0;
			which = 2;
			break;

		case "Razor Leaf":
			power = 55;
			accuracy = 100;
			type = 0;
			which = 2;
			break;

		case "Vine Whip":
			power = 35;
			accuracy = 100;
			type = 0;
			which = 2;
			break;
		}
	}
}

