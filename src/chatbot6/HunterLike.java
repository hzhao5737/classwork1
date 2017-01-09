package chatbot6;

public class HunterLike implements Topic {

	private boolean inLikeLoop;
	private String likeResponse;

	public void talk() {
		HunterMain.print("What are some things you like?");
		inLikeLoop = true;
		while(inLikeLoop){
			likeResponse = HunterMain.getInput();
			int likePsn = HunterMain.findKeyword(likeResponse, "like", 0);
			if(likePsn >= 0){
				String thingsLiked = likeResponse.substring(likePsn+5);
				HunterMain.print("You are such an interesting person, because you like "+thingsLiked);
				if(HunterMain.findKeyword(thingsLiked, "school", 0) >= 0){
					inLikeLoop = false;
					HunterMain.school.talk();
				}
				else{
					inLikeLoop = false;
					HunterMain.talkForever();
				}
			}
			else{
				HunterMain.print("I don't understand you.");
			}
		}
	}
	public boolean isTriggered(String userInput) {
		if(HunterMain.findKeyword(userInput, "like", 0) >= 0){
			return true;
		}
		return false;
	}
}