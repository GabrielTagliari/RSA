import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.math.*;

public class RSA {

	/*
	 * Co-primos ou Números primos entre si Dois números são primos entre si
	 * quando o Máximo Divisor Comum (MDC) entre eles é 1.
	 */

	private static final BigInteger NUM_1 = new BigInteger("1");

	private static final String[] CARACTERES = { "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z"};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String plainText = sc.next();
		
		Map<String, BigInteger> NumLetra = geraTabela();

		// Variáveis do tipo BigInteger
		BigInteger primeiroPrimo = new BigInteger("17");
		BigInteger segundoPrimo = new BigInteger("41");
		BigInteger tamanhoConjunto = primeiroPrimo.multiply(segundoPrimo);
		BigInteger resultadoTotiente = totiente(primeiroPrimo, segundoPrimo);

		int mdc = calculaMdc(resultadoTotiente);

		// Prints
		System.out.println(NumLetra.get("T"));
		System.out.println("Tamanho do conjunto: " + tamanhoConjunto);
		System.out.println("Totiente: " + resultadoTotiente);
		System.out.println("MDC: " + mdc);

		BigInteger[] cipherText = new BigInteger[plainText.length()];
		String letra;
		for (int i = 0; i < plainText.length(); i++) {
			letra = plainText.substring(i, i+1).toUpperCase();
			//System.out.println(Math.pow(NumLetra.get(letra), mdc));
			cipherText[i] = (new BigInteger(""+NumLetra.get(letra)).pow(mdc)).mod(tamanhoConjunto);
		}
		
		for (BigInteger bigInteger : cipherText) {
			System.out.println(bigInteger);
		}
		
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

	// Função para gerar a tabela de relação Número-Caracter
	public static Map<String, BigInteger> geraTabela() {
		Map<String, BigInteger> hashNumLetra = new HashMap<String, BigInteger>();

		int i = 1;

		for (String caracter : CARACTERES) {
			hashNumLetra.put(caracter, new BigInteger(""+i));
			i++;
		}

		return hashNumLetra;
	}
}
