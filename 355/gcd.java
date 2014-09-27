

public class gcd {
	public static void main(String[] args){
		System.out.println(Math.floor(10/3));
		gcd(14955,7575);

	}
	
	public static void gcd(int a, int b){
		/*
		if(a%b == 0){
			System.out.println(a/b);
			return;
		}*/
		if(b == 0){
			System.out.println(a);
			return;
		}
		System.out.println(a+" = "+(int)Math.floor(a/b)+" * "+b+" + "+a%b);
		gcd(b,a%b);
	}
	

	
	
}
