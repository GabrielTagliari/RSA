import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class RSA {

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
		String plainText = sc.nextLine();
		sc.close();
       
		//TODO Implementar o loop para percorrer array com mais de um elemento
        String strArray[] = plainText.split(" ");
        
        for(int i=0; i < strArray.length; i++){
                System.out.println(strArray[i]);
        }
		
		// Variaveis do tipo BigInteger
		BigInteger primeiroPrimo = new BigInteger("13");
		BigInteger segundoPrimo = new BigInteger("41");
		BigInteger tamanhoConjunto = primeiroPrimo.multiply(segundoPrimo);
		BigInteger resultadoTotiente = totiente(primeiroPrimo, segundoPrimo);

		int mdc = calculaMdc(resultadoTotiente);		
		int inverso = modularInverso(resultadoTotiente, mdc);

		BigInteger[] cipherText = new BigInteger[plainText.length()];
		String letra;
		for (int i = 0; i < plainText.length(); i++) {
			letra = plainText.substring(i, i+1).toUpperCase();
			cipherText[i] = (new BigInteger(""+TBL_LETRA_NUM.get(letra)).pow(mdc)).mod(tamanhoConjunto);
		}

		System.out.print("criptografia chave pública: ");
		for (BigInteger bigInteger : cipherText) {
			System.out.print(bigInteger+" ");
		}		

		BigInteger[] msgDescriptografada = new BigInteger[plainText.length()];
		for (int i = 0; i < cipherText.length; i++) {
			msgDescriptografada[i] = (cipherText[i].pow(inverso).mod(tamanhoConjunto));
		}

		System.out.print("\ndescriptografia chave privada: ");
		for (BigInteger bigInteger : msgDescriptografada) {
			System.out.print(bigInteger+" ");
		}

		System.out.print("\nMensagem descriptografada: ");
		for (int i = 0; i < msgDescriptografada.length; i++) {
			System.out.print(TBL_NUM_LETRA.get(new BigInteger(""+msgDescriptografada[i])));
		}		
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

	private static int modularInverso(BigInteger resultadoTotiente, int mdc) {
		BigInteger result = new BigInteger(""+mdc);
		result = result.modInverse(resultadoTotiente);
		return result.intValue();		
	}

	private static int calculaMdc(BigInteger resultadoTotiente) {
		int num = 13;
		BigInteger mdc = resultadoTotiente.gcd(new BigInteger(""+num));
		while (!mdc.equals(NUM_1)) {
			mdc = resultadoTotiente.gcd(new BigInteger(""+num));
			System.out.println(num);
			num++;
		}
		return num;
	}

	// calcula totiente
	public static BigInteger totiente(BigInteger primeiro, BigInteger segundo) {
		// BigInteger num1 = new BigInteger("1");
		return (primeiro.subtract(NUM_1)).multiply((segundo.subtract(NUM_1)));
	}
}
