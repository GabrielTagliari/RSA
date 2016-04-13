import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RSA {
	public static void main(String[] args) {
		
		Map<Integer, String> hashNumLetra = new HashMap<Integer, String>();
		
		String[] caracteres = {"A","B","C","D","E","F","G","H","I","J","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",};
		int i = 1;
		for (String caracter : caracteres) {
			hashNumLetra.put(i, caracter);
			i++;
		}
		
		System.out.println(hashNumLetra.get(19));
		
	}
}
