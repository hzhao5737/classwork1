package symposium;

public class Moves {
	
	public String move;
	public int power;
	public int accuracy;
	public int type;

	public Moves(String move) {
		this.move = move;
		switch(move){
		case "Tackle":
			power = 40;
			accuracy = 100;
			type = 0;
			break;
		}
	}
}
