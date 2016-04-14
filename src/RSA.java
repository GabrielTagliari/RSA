import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.math.*;

public class RSA {
	
	/*Co-primos ou Números primos entre si
	Dois números são primos entre si quando o Máximo Divisor Comum (MDC) entre eles é 1.*/
	
	public static void main(String[] args) {
		
		Map<Integer, String> NumLetra = geraTabela();
		
		BigInteger primeiroPrimo = new BigInteger("17");
		BigInteger segundoPrimo = new BigInteger("41");
		BigInteger tamanhoConjunto = primeiroPrimo.multiply(segundoPrimo);
		
		BigInteger resultadoTotiente = totiente(tamanhoConjunto, primeiroPrimo, segundoPrimo);
		
		System.out.println(NumLetra.get(19));
		System.out.println(tamanhoConjunto);
		System.out.println(resultadoTotiente);
		System.out.println(resultadoTotiente.gcd(new BigInteger("13")));
	}
	
		
	//calcula totiente
	public static BigInteger totiente(BigInteger tamanhoConjunto, BigInteger primeiro, BigInteger segundo){
		BigInteger num1 = new BigInteger("1");
		return (primeiro.subtract(num1)).multiply((segundo.subtract(num1)));
	}
	
	//Função para gerar a tabela de relação Número-Caracter
	public static Map<Integer, String> geraTabela() {
		Map<Integer, String> hashNumLetra = new HashMap<Integer, String>();
		
		String[] caracteres = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z", };

		int i = 1;

		for (String caracter : caracteres) {
			hashNumLetra.put(i, caracter);
			i++;
		}

		return hashNumLetra;
	}
}
