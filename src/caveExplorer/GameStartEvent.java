package caveExplorer;

public class GameStartEvent implements Event {

	public static final String[] SEQ_1 = {"A spiky- haired guy with orange pants flies up to you.",
			"Have you arrived to save us from the treacherous Buu?",
			"We need your help."};
	public static final String[] SEQ_2 = {"Great, I will be meditating on my super yellow version"
			+ "while you figure out where Buu is.", "kaaaaa, maaaaaaay....",
			"By the way, here is a map."};
	
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	public void play() {
		readSequence(SEQ_1);
		CaveExplorer.print("Will you help us?");
		while(CaveExplorer.in.nextLine().indexOf("yes") < 0){
			CaveExplorer.print("Please say yes. I beg of you!");
		}
		readSequence(SEQ_2);
		CaveExplorer.inventory.setMap(true);
	}

	private static void readSequence(String[] seq){
		for(String s : seq){
			CaveExplorer.print(s);
			CaveExplorer.print("- - - Press enter - - -");
			CaveExplorer.in.nextLine();
		}
		
		
	}

}