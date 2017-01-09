package dataTypes;

public class DataTypes {

	public static void main(String[] args) {
		System.out.println(5.0/2);//double divided by int
		System.out.println((double) 5/2);//casting
		System.out.println(5/2);
		System.out.println(3+5.0/2+5*2);
		System.out.println(3.0+5/2+5*2);
		System.out.println((int)(3.0 + 5)/(2 + 5 * 2));

		double d1 = 4.64; 
		double d2 = 2.0;
		double d3 = 2.64;

		System.out.println("d1 : " + d1); 
		System.out.println("d2 : " + d2); 
		System.out.println("d3 : " + d3);  
		System.out.println("d1 - d2 : " + (d1 - d2));
		
		/*String s = 1;
		System.out.println(s);
		
		String q = (String)1;
		System.out.println(q);*/
		
		String w = "1";
		System.out.println(w);
		
		String e = ""+1;
		System.out.println(e);
		
		String r = "Happy "+18+"th birthday!";
		System.out.println(r);
		
		String t = "Happy 18th birthday!";
		System.out.println(t);
		
		String y = "Happy "+54/3+"th birthday!";
		System.out.println(y);
		
		String u = "Happy "+(54/3)+"th birthday!";
		System.out.println(u);
		
		int m = 22;
		int n = 7;
		System.out.println("m/n is "+(m/n));
		
		int i = 22;
		int o = 7;
		System.out.println("i/o is "+((double)i/o));
	}
}
