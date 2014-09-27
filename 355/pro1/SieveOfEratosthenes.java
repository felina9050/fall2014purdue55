

class Primes{
	char primes[];
	int length;
	public Primes(int n){
		length=n/8+2;
		primes=new char[length];
		for(int i=0;i<length;i++)
			primes[i]=(char)0xff;
	}

	public boolean read(int n){
		char t=primes[n/8];
		t=(char) ((char)t&(0x80>>((n-1)%8)));
		return t>0;
	}

	public void write(int n, boolean val){
		char t=primes[n/8];
		if (val)
			t=(char) (t|(0x80>>((n-1)%8)));
		else{
			char k=(char) (t&(0x80>>((n-1)%8)));
			t=(char) ((t|k)-k);
		}
		primes[n/8]=t;
	}
}

public class SieveOfEratosthenes {

	public static void main(String[] args){
		System.out.println("Part A\n");
		long time=System.currentTimeMillis();
		SE1((int)Math.pow(10, 6));
		for(int i=2;i<13;i++)
			SE2(i);
		System.out.println("\nrun time: "+(System.currentTimeMillis()-time)+"ms");
	}


	public static void SE1(int n){
		if(n<2){
			System.out.println("less than two");
			return;
		}
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
		n = 0;
		int m = 0;
		System.out.println("First five primes:");
		for(int i = 2; i < length; i++){
			if(prime.read(i)){
				n++;
				if(n<6)
					System.out.println(i);
			}

		}
		System.out.println("Last five primes:");
		for(int i = length-1; i > 2; i-- ){
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

	public static void SE2(int t){
		int length = (int)Math.pow(3, t)+1;
		boolean[] prime = new boolean[length];
		prime[0] = false;
		prime[1] = false;
		for(int i = 2; i < length; i++ ){
			prime[i] = true;
		}
		for(int i =2; i < Math.sqrt(length);i++){
			if( !prime[i] )
				continue;
			for(int j = 2; i*j <length ; j++){
				prime[i*j] = false;
			}
		}
		int n = 0;
		int m = 0;
		for(int i = 2; i < length; i++){
			if(prime[i])
				n++;
		}
		System.out.println("t="+t+"\t3^t/ln(3t):"+Math.round(Math.pow(3, t)/Math.log(Math.pow(3,t)))+"\t\tpi(3^t):"+n);
	}
}
