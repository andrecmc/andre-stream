/**
 * 
 */
package andre;

/**
 * @author Andre
 *
 */
public class StreamUtil {

	/**
	 * Dada uma stream, encontre:
	 * - o primeiro caractere Vogal (R1)
	 * - apos uma consoante (R2)
	 * - onde a mesma e antecessora a uma vogal (R3)
	 * - e que nao se repita no resto da stream. (R4)
	 * 
	 * O termino da leitura da stream deve ser garantido atraves do metodo
	 * hasNext(), ou seja, retorna falso para o termino da leitura da stream. Voce
	 * tera acesso a leitura da stream atraves dos metodos de interface fornecidos
	 * ao termino do enunciado. (15 pontos) (*Leia todo o enunciado)
	 * 
	 * Premissas:
	 * 
	 * Uma chamada para hasNext() ira retornar se a stream ainda contem caracteres
	 * para processar. Uma chamada para getNext() ira retornar o proximo caractere a
	 * ser processado na stream. Nao sera possivel reiniciar o fluxo da leitura da
	 * stream. Nao podera ser utilizado nenhum framework Java, apenas codigo nativo.
	 * 
	 * Exemplo:
	 * 
	 * Input: aAbBABacafe Output: e No exemplo, 'e' e o primeiro caractere Vogal da
	 * stream que nao se repete apos a primeira Consoante 'f' o qual tem uma vogal
	 * 'a' como antecessora.
	 * 
	 * Consideracoes adicionais:
	 * - Nao sera feita distincao entre maiusculas e minusculas 
	 * - O resultado sera sempre apresentado utilizando minusculas
	 * - Caso nao seja encontrada uma vogal que satisfaca as condicoes apresentadas sera retornado um caractere null (0)
	 * 
	 * @param input
	 * @return
	 */
	public static char findFirstVowel(Stream input) {
		char result = 0;
		int vowelCounter[] = new int[5];
		int vowelPosition[] = new int[5];
	
		for (int i = 0; i < 5; i++) {
			vowelCounter[i] = 0;
			vowelPosition[i] = -1;
		}
	
		int streamIndex=0;
		char currentChar=0;
		char previousChar=0;
		char previousPreviousChar=0;
		while (input.hasNext()) {
			previousPreviousChar=previousChar;
			previousChar=currentChar;
			currentChar=input.getNext();
			
			if (StreamUtil.isVowel(currentChar) && !StreamUtil.isVowel(previousChar) && StreamUtil.isVowel(previousPreviousChar)) {
				vowelCounter[StreamUtil.vowelIndexFromChar(currentChar)]++;
				if (vowelCounter[StreamUtil.vowelIndexFromChar(currentChar)]==1) {
					vowelPosition[StreamUtil.vowelIndexFromChar(currentChar)]=streamIndex;
				}
			} else if ((StreamUtil.isVowel(currentChar)) && (vowelCounter[StreamUtil.vowelIndexFromChar(currentChar)]==1)) {
				vowelCounter[StreamUtil.vowelIndexFromChar(currentChar)]++;
			}
			streamIndex++;
		}
		int firstPosition=-1;
		for (int index=0;index<vowelPosition.length;index++) {
			if (vowelCounter[index]==1) {
				if ((firstPosition==-1) || (vowelPosition[index]<firstPosition)) {
					firstPosition=vowelPosition[index];
					result=StreamUtil.vowelCharFromIndex(index);
				}
			}
		}
	
		return result;
	}

	private static String VOWELS = "aeiou";
	
	/**
	 * Get a vowel from an index where:
	 * 
	 * index=0 => return='a'
	 * index=1 => return='e'
	 * index=2 => return='i'
	 * index=3 => return='o'
	 * index=4 => return='u'
	 * 
	 * @param index Numeric index for a vowel
	 * @return Vowel character (lowercase) from an index or (char)0 for anything else 
	 */
	private static char vowelCharFromIndex(int index) {
		char result=0;

		if ((index>=0) && (index<VOWELS.length())) {
			result=VOWELS.charAt(index);
		}
		return result;
	}

	private static boolean isVowel(char c) {
		return (VOWELS.indexOf(Character.toLowerCase(c)) >= 0);
	}

	/**
	 * Get an index for a vowel character, where:
	 * 
	 * c='a' => return=0
	 * c='e' => return=1
	 * c='i' => return=2
	 * c='o' => return=3
	 * c='u' => return=4
	 * 
	 * @param c Character
	 * @return Index for a vowel or -1 for anything else
	 */
	private static int vowelIndexFromChar(char c) {
		return VOWELS.indexOf(Character.toLowerCase(c));
	}

}
