package chatbot6;

import java.util.Scanner;

public class HunterMain {

	static Scanner input;
	static String user;
	static boolean inLoop;
	static String response;
	static Topic school;
	static Topic like;
	static Topic hello;

	public static void main(String[] args) {
		createTopics();
		promptName();
		talkForever();
	}

	public static void promptName() {
		print("Hello, human! I am a board covered with semiconductors and other such electric components. What is your name?");
		user = input.nextLine();
		print("Awsome I will call you "+user+" until you terminate me.");
	}

	public static void talkForever(){
		inLoop = true;
		while(inLoop){
			print("Greetings, "+user+". How are you?");
			response = getInput();
			if(findKeyword(response, "good", 0) >= 0){
				print("I'm so happy you're good.");
			}
			else if(like.isTriggered(response)){
				inLoop = false;
				like.talk();
			}
			else if(school.isTriggered(response)){
				inLoop = false;//exit this loop
				school.talk();
			}
			else if(hello.isTriggered(response)){
				inLoop = false;
				hello.talk();
			}
			else{
				print("I'm sorry, I don't understand you.");
			}
		}
	}

	public static int findKeyword(String searchString, String key, int startIndex) {
		//delete white space
		String phrase = searchString.trim();
		//set all letters to lowercase
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();

		System.out.println("The phrase is "+phrase);
		System.out.println("The key is "+key);

		//find position of key
		int psn = phrase.indexOf(key);
		System.out.println("The position found is "+psn);
		//keep looking for the word until you find the right context
		while(psn >= 0){
			String before = " ";
			String after = " ";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + key.length()+1);
				System.out.println("The character after "+ key + " is "+after);
			}
			//if the phrase does not begin with this word
			if(psn >0){
				before = phrase.substring(psn-1,psn).toLowerCase();
				System.out.println("The character before "+ key + " is "+before);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
				System.out.println(key+ " was found at " +psn);
				if(noNegations(phrase, psn)){
					return psn;
				}
			}
			//in case the keyword was not found yet, check the rest of the string
			psn = phrase.indexOf(key,psn+1);
			System.out.println(key+ " was not found. Checking " +psn);
		}

		return -1;
	}

	//"helper method" a method that contributes functionality to another method. Helper methods 
	//are very common when you need to do the same thing repeatedly. They also help make methods 
	//more readable.This method is private because it is only used by the method it is helping.

	private static boolean noNegations(String phrase, int index) {
		//check for word "No " (3 characters)
		//check to see if there is space for the word "No " to be in front of the index
		if(index - 3 >= 0 && phrase.substring(index-3,index).equals("no ")){
			return false;
		}
		//check for "not "
		if(index - 4 >= 0 && phrase.substring(index-4,index).equals("not ")){
			return false;
		}
		//check for "never "
		if(index - 6 >= 0 && phrase.substring(index-6,index).equals("never ")){
			return false;
		}
		//check for "n't "
		if(index - 4 >= 0 && phrase.substring(index-4,index).equals("n't ")){
			return false;
		}
		return true;
	}

	public static void promptInput() {
		print(user+ ", try inputing a String!");
		String userInput = input.nextLine();
		print("You typed: "+userInput);
	}

	public static String getInput(){
		return input.nextLine();
	}
	public static void createTopics() {
		input = new Scanner(System.in);
		school = new School();
		like = new HunterLike();
		hello = new HunterHello();
	}

	public static void print(String s){
		//create a multi-line String
		String printString ="";
		int cutoff = 35;
		//check to see if there are words to add
		//(IOW, is the length of s > 0
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			//while the current line and next word are less than the cutoff, and there are still words to add do the following loop
			while(currentLine.length() + nextWord.length() <= cutoff && s.length() > 0){
				//add the next word to the line
				currentLine += nextWord;
				//remove that word
				s = s.substring(nextWord.length());
				//get the following word
				int endOfWord = s.indexOf(" ");
				//checks to see if this is last word
				if(endOfWord == -1){
					endOfWord = s.length() -1;
				}
				//get the next word and space
				nextWord = s.substring(0, endOfWord+1);
			}
			printString += currentLine +"\n";
		}

		System.out.println(printString);
	}
}