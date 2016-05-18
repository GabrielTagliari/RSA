import java.util.Scanner;
import java.math.*;

public class CriptografaNumero {

	private static final BigInteger NUM_1 = new BigInteger("1");

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a mensagem a ser criptografada: ");
		String a = sc.nextLine();
		sc.close();
		       
		// Variaveis do tipo BigInteger
		BigInteger p = new BigInteger("3");
		BigInteger q = new BigInteger("11");
		BigInteger n = p.multiply(q); //a entrada nao pode ser maior do que este numero.

		int e = calculaMdc(n);		
		int d = calculaD(p,q,e);
		BigInteger b = new BigInteger("0");
		
		String strArray[] = a.split(" ");
		BigInteger textoCriptografado[] = new BigInteger[strArray.length]; 
        
		System.out.print("Mensagem Criptografada: ");
        for (int i=0; i<strArray.length;i++) {
        	b = new BigInteger(strArray[i]).pow(e).mod(n);
        	textoCriptografado[i] = b;
        	System.out.print(b+" ");
		}
        
		System.out.println();
        System.out.print("Mensagem Descriptografada: ");
        for (BigInteger bigInteger : textoCriptografado) {
			System.out.print(bigInteger.pow(d).mod(n)+" ");
		}
	}

	private static int calculaMdc(BigInteger n) {
		/*int num = 7;
		BigInteger mdc = n.gcd(new BigInteger(""+num));
		while (!mdc.equals(NUM_1)) {
			mdc = n.gcd(new BigInteger(""+num));
			num++;
		}*/
		return 7;
	}
	
	private static int calculaD(BigInteger p, BigInteger q, int e) {
		int d = 1;		
		BigInteger n1 = p.subtract(new BigInteger("1"));
		BigInteger n2 = q.subtract(new BigInteger("1"));
		BigInteger n = n1.multiply(n2);
		BigInteger ed = new BigInteger(""+e).multiply(new BigInteger(""+d)); 
		while(!ed.mod(n).equals(NUM_1)){
			d++;
			ed = new BigInteger(""+e).multiply(new BigInteger(""+d));
		}
		
		return d;
	}
}
