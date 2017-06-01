package symposium;

public class Pok {
	
	public String name;
	public int hp;
	public int attack;
	public int defense;
	public int speed;
	public int special;
	public int[] type;
	public Moves[] moves;
	public int currenthp;
	
	public Pok(String name){
		this.name = name;
		switch(name){
		case "Venusaur":
			type = new int[2];
			moves = new Moves[4];
			hp = 80;
			attack = 82;
			defense = 83;
			speed = 80;
			special = 100;
			type[0] = 3;
			type[1] = 8;
			currenthp = hp;
			moves[0] = new Moves("Tackle");
			moves[1] = new Moves("Tackle");
			moves[2] = new Moves("Tackle");
			moves[3] = new Moves("Tackle");
			break;
		case "Charizard":
			type = new int[2];
			hp = 80;
			attack = 82;
			defense = 83;
			speed = 80;
			special = 100;
			type[0] = 2;
			type[1] = 10;
			currenthp = hp;
			moves[0] = new Moves("Tackle");
			moves[1] = new Moves("Tackle");
			moves[2] = new Moves("Tackle");
			moves[3] = new Moves("Tackle");
			break;
		case "Blastoise":
			type = new int[1];
			hp = 80;
			attack = 82;
			defense = 83;
			speed = 80;
			special = 100;
			type[0] = 3;
			currenthp = hp;
			moves[0] = new Moves("Tackle");
			moves[1] = new Moves("Tackle");
			moves[2] = new Moves("Tackle");
			moves[3] = new Moves("Tackle");
			break;
		}
	}
}
