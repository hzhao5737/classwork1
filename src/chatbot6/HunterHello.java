package chatbot6;

public class HunterHello implements Topic {

	private boolean inHelloLoop;
	private String helloResponse;

	private int helloCount;

	//responses are constants
	private static String[] calmResponses = {"We've already said our hellos. Remember?","Yes, hello to you too. Let's actually talk."};
	private static String[] angryResponses = {"Okay, seriously. This has to stop","You are beginning to annoy me.","We've SAID HELLO"};

	public HunterHello(){
		helloCount = 0;
	}

	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			printResponse();
			helloResponse = HunterMain.getInput();
			//! is used for negation
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				HunterMain.talkForever();
			}
		}
	}

	private void printResponse() {
		int responseIndex = 0;
		//calm response
		if(helloCount <5){
			responseIndex = (int)(Math.random() * calmResponses.length);
			HunterMain.print(calmResponses[responseIndex]);
		}
		//angry response
		else{
			responseIndex = (int)(Math.random() * angryResponses.length);
			HunterMain.print(angryResponses[responseIndex]);
		}
	}

	public boolean isTriggered(String userInput){
		if(HunterMain.findKeyword(userInput, "hi", 0) >= 0){
			return true;
		}
		if(HunterMain.findKeyword(userInput, "hello", 0) >= 0){
			return true;
		}
		return false;
	}
}
