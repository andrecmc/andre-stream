package andre;

import java.util.ArrayList;

/**
 * @author Andre
 *
 */
public class TestStream implements Stream {

	String str;
	int pos = 0;

	public TestStream(String str) {
		this.str = str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stream#getNext()
	 */
	@Override
	public char getNext() {
		// TODO Auto-generated method stub
		char result = 0;
		if (pos < str.length()) {
			result = str.charAt(pos);
			pos++;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Stream#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return (pos < str.length());
	}

	static String VOWELS = "AEIOU";

	static boolean isVowel(char c) {
		return (VOWELS.indexOf(Character.toUpperCase(c)) >= 0);
	}

	/**
	 * Dada uma stream, encontre
	 * o primeiro caractere Vogal, (R1)
	 * apos uma consoante, (R2)
	 * onde a mesma e antecessora a uma vogal (R3)
	 * e que nao se repita no resto da stream. (R4)
	 * 
	 * O termino da leitura da stream deve ser garantido atraves do metodo hasNext(), ou seja, retorna falso para o 
	 * termino da leitura da stream. Voce tera acesso a leitura da stream atraves dos metodos de interface fornecidos ao termino do
	 * enunciado. (15 pontos) (*Leia todo o enunciado)
	 * 
	 * Premissas:
	 * 
	 * Uma chamada para hasNext() ira retornar se a stream ainda contem caracteres para processar.
	 * Uma chamada para getNext() ira retornar o proximo caractere a ser processado na stream.
	 * Nao sera possivel reiniciar o fluxo da leitura da stream.
	 * Nao podera ser utilizado nenhum framework Java, apenas codigo nativo.
	 * 
	 * Exemplo:
	 * 
	 * Input:  aAbBABacafe
	 * Output: e
	 * No exemplo, 'e' e o primeiro caractere Vogal da stream que nao se repete apos a primeira Consoante 'f' o qual tem uma vogal 'a' como antecessora.
	 * 
	 * @param input
	 * @return
	 */
	public static char firstChar(Stream input) {
		char result = 0;
		ArrayList<Character> a = new ArrayList<>();
		while (input.hasNext()) {
			a.add(input.getNext());
		}

		
		for (int i=0; i<a.size();i++) {
			char currentChar=a.get(i);
			char previousChar=(i>0) ? a.get(i-1) : 0;
			char previousPreviousChar=(i>1) ? a.get(i-2) : 0;
			if (isVowel(currentChar) && !isVowel(previousChar) && isVowel(previousPreviousChar)) {
				result = a.get(i);
			}
		}

		return result;
	}

}
