import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.math.*;

public class RSA {
	
	/*Co-primos ou Números primos entre si
	Dois números são primos entre si quando o Máximo Divisor Comum (MDC) entre eles é 1.*/
	
	public static void main(String[] args) {
		
		Map<BigInteger, String> NumLetra = geraTabela();
		
		BigInteger primeiroPrimo = new BigInteger("17");
		BigInteger segundoPrimo = new BigInteger("41");
		BigInteger tamanhoConjunto = primeiroPrimo * segundoPrimo;
		
		BigInteger resultadoTotiente = totiente(tamanhoConjunto, primeiroPrimo, segundoPrimo);
		
		System.out.println(NumLetra.get(19));
		System.out.println(tamanhoConjunto);
		System.out.println(resultadoTotiente);
		System.out.println(resultadoTotiente.gcd(13));
	}
	
		
	//calcula totiente
	public static BigInteger totiente(BigInteger tamanhoConjunto, BigInteger primeiroPrimo, BigInteger segundo){
		return (primeiroPrimo - 1) * (segundo - 1);
	}
	
	//Função para gerar a tabela de relação Número-Caracter
	public static Map<BigInteger, String> geraTabela() {
		Map<BigInteger, String> hashNumLetra = new HashMap<BigInteger, String>();
		
		String[] caracteres = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z", };

		BigInteger i = 1;

		for (String caracter : caracteres) {
			hashNumLetra.put(i, caracter);
			i++;
		}

		return hashNumLetra;
	}
}
