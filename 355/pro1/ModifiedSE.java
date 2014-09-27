

public class ModifiedSE {
	public static void main(String[] args){
			System.out.println("Part B\n");
			long t=System.currentTimeMillis();
			int i=(int)Math.pow(10, 9);
			int j=(int)(Math.pow(10, 9)+Math.pow(10, 6));
		    MSE(i,j);
		    System.out.println("(J/lnJ)-(I/lnI): "+(int)(j/Math.log(j)-i/Math.log(i)));
		    System.out.println("\nrun time: "+(System.currentTimeMillis()-t)+"ms");
		    System.out.println("\n\n\nPart C\n");
		    t=System.currentTimeMillis();
		    MSE2(i,j);
		    System.out.println("run time: "+(System.currentTimeMillis()-t)+"ms");
	}
	
	public static void MSE(int i, int j){
		Primes primeSE = SE((int)Math.sqrt(j));
		Primes prime = new Primes(j);
		for(int k = 2; k < (int)Math.sqrt(j); k++){
			if(primeSE.read(k)){
				int temp = (i+k-1)/k*k;
				while(temp<=j){
					prime.write(temp,false);
					temp += k;
				}
			}
		}
		int n=0;
		int m=0;
		System.out.println("First five primes:");
		for(int k = i; k <= j; k++){
			if(prime.read(k)){
				n++;
				if(n<6)
					System.out.println(k);
			}
		}
		System.out.println("Last five primes:");
		for(i = j; i > 2; i-- ){
			if(prime.read(i)){
				m++;
				if(m<6)
					System.out.println(i);
				else
					break;
			}
		}
		System.out.println("\nnumber of primes: "+n+"\n");
	}
	
	public static void MSE2(int i, int j){
		Primes primeSE = SE(999);
		Primes prime = new Primes(j);
		for(int k = 2; k < 1000; k++){
			if(primeSE.read(k)){
				int temp = (i+k-1)/k*k;
				while(temp<j+1){
					prime.write(temp,false);
					temp += k;
				}
			}
		}
		int n=0;
		int m=0;
		System.out.println("First five:");
		for(int k = i; k < j; k++){
			if(prime.read(k)){
				n++;
				if(n<6){
					System.out.print(k);
					checkPrime(k);
				}
			}
		}
		System.out.println("Last five:");
		for(i = j; i > 2; i-- ){
			if(prime.read(i)){
				m++;
				if(m<6){
					System.out.print(i);
					checkPrime(i);
				}else
					break;
			}
		}
		System.out.println("\nnumber of not crossed out: "+n+"\n");
	}
	
	public static Primes SE(int n){
		int length = n+1;
		Primes prime = new Primes(n);
		prime.write(1, false);
		for(int i =2; i < Math.sqrt(length);i++){
			if( !prime.read(i))
				continue;
			int temp = i*2;
			while(temp<length){
				prime.write(temp,false);
				temp += i;
			}
		}
		return prime;
	}
	
	public static void checkPrime(int n){
		for (int i=2;i<=Math.sqrt(n);i++){
			if (n%i==0){
				System.out.println(" is not a prime, has factor "+i+"...");
				return;
			}
		}
		System.out.println(" is a prime!");
	}
}
