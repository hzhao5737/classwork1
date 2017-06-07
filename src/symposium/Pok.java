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
	public int currentattack;
	public int currentdefense;
	public int currentspeed;
	public int currentspecial;
	
	
	public Pok(String name){
		this.name = name;
		moves = new Moves[4];
		switch(name){
		case "Venusaur":
			type = new int[2];
			hp = 80;
			attack = 82;
			defense = 83;
			speed = 80;
			special = 100;
			type[0] = 3;
			type[1] = 8;
			moves[0] = new Moves("SolarBeam");
			moves[1] = new Moves("Razor Leaf");
			moves[2] = new Moves("Vine Whip");
			moves[3] = new Moves("Tackle");
			break;
		case "Charizard":
			type = new int[2];
			hp = 78;
			attack = 84;
			defense = 78;
			speed = 100;
			special = 85;
			type[0] = 2;
			type[1] = 10;
			moves[0] = new Moves("Tackle");
			moves[1] = new Moves("Tackle");
			moves[2] = new Moves("Tackle");
			moves[3] = new Moves("Tackle");
			break;
		case "Blastoise":
			type = new int[1];
			hp = 79;
			attack = 83;
			defense = 100;
			speed = 78;
			special = 85;
			type[0] = 3;
			moves[0] = new Moves("Tackle");
			moves[1] = new Moves("Tackle");
			moves[2] = new Moves("Tackle");
			moves[3] = new Moves("Tackle");
			break;
		}
		currenthp = hp;
		currentattack = attack;
		currentdefense = defense;
		currentspeed = speed;
		currentspecial = special;
	}
}
