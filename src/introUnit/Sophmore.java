package introUnit;

public class Sophmore extends Student {

	private String internship;

	public Sophmore(String name, String internship) {
		super(name);
		this.internship = internship;
	}

	public void talk(){
		super.talk();//calls the super method
		System.out.println("... and I am a sophmore!");
		System.out.println("I intern as a "+internship);
	}
}
