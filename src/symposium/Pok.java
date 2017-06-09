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
	
	public Pok(String name){
		this.name = name;
		moves = new Moves[4];
		switch(name){
		case "Venusaur":
			type = new int[2];
			hp = 270;
			attack = 82;
			defense = 83;
			speed = 80;
			special = 100;
			type[0] = 3;
			type[1] = 10;
			moves[0] = new Moves("Solar Beam");
			moves[1] = new Moves("Razor Leaf");
			moves[2] = new Moves("Vine Whip");
			moves[3] = new Moves("Tackle");
			break;
		case "Charizard":
			type = new int[2];
			hp = 266;
			attack = 84;
			defense = 78;
			speed = 100;
			special = 85;
			type[0] = 2;
			type[1] = 8;
			moves[0] = new Moves("Tackle");
			moves[1] = new Moves("Tackle");
			moves[2] = new Moves("Tackle");
			moves[3] = new Moves("Tackle");
			break;
		case "Blastoise":
			type = new int[1];
			hp = 268;
			attack = 83;
			defense = 100;
			speed = 78;
			special = 85;
			type[0] = 9;
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
