/**
 * 
 */
package introUnit;

/**
 * @author student 6
 * This class is designed to contrast with the ProceduralExample. It embodies an Object-Oriented approach.
 */
public class OOPExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//construct a student
		Student jillian = new Senior("Jillian","programmer");
		Student jordan = new Freshmen("Jordan","programmer");
		Student jason = new Sophmore("Jason","programmer");
		jillian.talk();
		jordan.talk();
		jason.talk();
	}

}
