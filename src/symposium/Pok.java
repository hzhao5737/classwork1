package symposium;

public class Pok {
	
	public String name;
	public int hp;
	public int attack;
	public int defense;
	public int speed;
	public int special;
	public int type1;
	public int type2;
	
	public Pok(String name, int hp, int attack, int defense, int speed, int special, int type1, int type2){
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.special = special;
		this.type1 = type1;
		this.type2 = type2;
	}

	public String getName() {
		return name;
	}
}
