package chatbot6;

public class School implements Topic {

	private Boolean inSchoolLoop;
	private String schoolResponse;

	public School(){

	}

	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			HunterMain.print("Tell me about school.");
			schoolResponse = HunterMain.getInput();
			if(schoolResponse.indexOf("stop") >= 0){
				inSchoolLoop = false;
				HunterMain.talkForever();
			}
			HunterMain.print("That's my favorite part about school too.");
		}
	}

	public boolean isTriggered(String userInput) {
		//String[] triggers = {"schools","class","teacher"};
		//you could use a for loop to iterate through an array
		if(HunterMain.findKeyword(userInput, "school", 0) >= 0){
			return true;
		}
		if(HunterMain.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
	}
}