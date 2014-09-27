



public class beaufortCipher {
	public static void main(String[] args){
		
		/*
		for(int i=-3;i<5;i++){
			int x = 89 + 103*i;
			if((7*x-5)%103==0){
				System.out.println("true");
			}
		}*/
		
		System.out.println((295-89)%103);
		System.out.println((-7)%26);
		System.out.println((-27)%5);
		//System.out.println(bCipher("ATTACKATDAWN".toLowerCase().toCharArray(),"KEY".toLowerCase().toCharArray()));
		System.out.println(bDecipher("KLFKCOKLVKIL".toLowerCase().toCharArray(),"KEY".toLowerCase().toCharArray()));
	}
	
	public static char[] bCipher(char[] plantext, char[] key){
		char[] encipher = new char[plantext.length];
		for(int i = 0; i<plantext.length; i++){
			encipher[i] =  (char)('A'+((key[i%key.length] - plantext[i])+26000)%26);
		}
	
		return encipher;
	}
	public static char[] bDecipher(char[] encipher, char[] key){
		char[] decipher = new char[encipher.length];
		for(int i = 0; i<encipher.length; i++){
			decipher[i] =  (char)('A'+((key[i%key.length] - encipher[i])+26000)%26);
		}
	
		return decipher;
	}

	

}
