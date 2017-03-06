import java.util.ArrayList;

public class ListRunner {
	
	static ArrayList<Item> shoppingList;

	public static void main(String[] args) {
		String[] justDescription = getDescription();
		initList(justDescription);
		doSomeShopping();
		printPurchasedItems();
	}

	private static void printPurchasedItems() {
		for(int i = 0; i < shoppingList.size(); i++){
			if(shoppingList.get(i).isPurchased()){
				System.out.println("Bought "+shoppingList.get(i).getDescription());
				shoppingList.remove(i);
				i--;
			}
		}
	}

	private static void doSomeShopping() {
		shoppingList.get(0).setPurchased(true);
	}

	private static void initList(String[] justDescription) {
		shoppingList = new ArrayList<Item>();
		for(String s: justDescription){
			shoppingList.add(new Item(s));
		}
	}

	private static String[] getDescription() {
		String[] test = {"CLothes","Dryer","Shampoo"};
		return test;
	}

}
