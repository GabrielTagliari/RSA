import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class RsaCryptography {

	private static final BigInteger NUM_1 = new BigInteger("1");

	//TODO ADICIONAR A LETRA K
	private static final String[] CARACTERES = { "A", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
		"U", "V", "W", "X", "Y", "Z"};

	private static final Map<String, BigInteger> TBL_LETRA_NUM = geraTabelaLetraNum();
	private static final Map<BigInteger, String> TBL_NUM_LETRA = geraTabelaNumLetra();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a mensagem a ser criptografada: ");
		BigInteger a = sc.nextBigInteger();
		//String plainText = sc.nextLine();
		sc.close();
       
		
		// Variaveis do tipo BigInteger
		BigInteger p = new BigInteger("3");
		BigInteger q = new BigInteger("11");
		BigInteger n = p.multiply(q);

		int e = calculaMdc(n);		
		int d = findD(p,q,e);
		BigInteger b = new BigInteger("0");
		
		System.out.println(e);
		System.out.println(d);
		System.out.println("acabou");
		
		b = a.pow(e).mod(n);
		
		System.out.println(b);
		
		BigInteger a2 = b.pow(d).mod(n);
		
		System.out.println(a2);

		/*BigInteger[] cipherText = new BigInteger[plainText.length()];
		String letra;
		for (int i = 0; i < plainText.length(); i++) {
			letra = plainText.substring(i, i+1).toUpperCase();
			cipherText[i] = (new BigInteger(""+TBL_LETRA_NUM.get(letra)).pow(e)).mod(n);
		}

		System.out.print("criptografia chave pública: ");
		for (BigInteger bigInteger : cipherText) {
			System.out.print(bigInteger+" ");
		}*/

		/*BigInteger[] msgDescriptografada = new BigInteger[plainText.length()];
		for (int i = 0; i < cipherText.length; i++) {
			msgDescriptografada[i] = (cipherText[i].pow(inverso).mod(n));
		}

		System.out.print("\ndescriptografia chave privada: ");
		for (BigInteger bigInteger : msgDescriptografada) {
			System.out.print(bigInteger+" ");
		}

		System.out.print("\nMensagem descriptografada: ");
		for (int i = 0; i < msgDescriptografada.length; i++) {
			System.out.print(TBL_NUM_LETRA.get(new BigInteger(""+msgDescriptografada[i])));
		}*/		
	}

	private static int findD(BigInteger p, BigInteger q, int e) {
		int d = 3;
		BigInteger n1 = p.subtract(new BigInteger("1")); 
		BigInteger n2 = q.subtract(new BigInteger("1"));
		BigInteger n = n1.multiply(n2);
		BigInteger ed = new BigInteger(""+e).multiply(new BigInteger(""+d)); 
		if (ed.mod(n).equals(NUM_1)) {
			System.out.println("é igual a 1");
		} else {
			System.out.println("não é igual a 1");
		}
		
		return d;
	}

	public static Map<String, BigInteger> geraTabelaLetraNum() {
		Map<String, BigInteger> hashLetraNum = new HashMap<String, BigInteger>();

		int i = 1;

		for (String caracter : CARACTERES) {
			hashLetraNum.put(caracter, new BigInteger(""+i));
			i++;
		}

		return hashLetraNum;
	}

	public static Map<BigInteger, String> geraTabelaNumLetra() {
		Map<BigInteger, String> hashNumLetra = new HashMap<BigInteger, String>();

		int i = 1;

		for (String caracter : CARACTERES) {
			hashNumLetra.put(new BigInteger(""+i), caracter);
			i++;
		}

		return hashNumLetra;
	}

	private static int calculaMdc(BigInteger n) {
		int num = 7;
		BigInteger mdc = n.gcd(new BigInteger(""+num));
		while (!mdc.equals(NUM_1)) {
			mdc = n.gcd(new BigInteger(""+num));
			System.out.println(num);
			num++;
		}
		return num;
	}
}
