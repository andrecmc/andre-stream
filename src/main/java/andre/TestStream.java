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

	static String VOWELS = "aeiou";

	static boolean isVowel(char c) {
		return (VOWELS.indexOf(Character.toLowerCase(c)) >= 0);
	}

	static char vowelCharFromIndex(int i) {
		char result=0;
		switch (i) {
		case 0:
			result = 'a';
			break;
		case 1:
			result = 'e';
			break;
		case 2:
			result = 'i';
			break;		
		case 3:
			result = 'o';
			break;
		case 4:
			result = 'u';
			break;
		}
		return result;
	}
	
	static int vowelIndexFromChar(char c) {
		int i = -1;
		switch (Character.toLowerCase(c)) {
		case 'a':
			i = 0;
			break;
		case 'e':
			i = 1;
			break;
		case 'i':
			i = 2;
			break;
		case 'o':
			i = 3;
			break;
		case 'u':
			i = 4;
			break;
		}
		return i;

	}

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
		ArrayList<Character> a = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			vowelCounter[i] = 0;
			vowelPosition[i] = -1;
		}

		while (input.hasNext()) {
			a.add(input.getNext());
		}

		for (int i = 0; i < a.size(); i++) {
			char currentChar = a.get(i);
			char previousChar = (i > 0) ? a.get(i - 1) : 0;
			char previousPreviousChar = (i > 1) ? a.get(i - 2) : 0;
			
			if (isVowel(currentChar) && !isVowel(previousChar) && isVowel(previousPreviousChar)) {
				vowelCounter[vowelIndexFromChar(currentChar)]++;
				if (vowelCounter[vowelIndexFromChar(currentChar)]==1) {
					vowelPosition[vowelIndexFromChar(currentChar)]=i;
				}
			} else if ((isVowel(currentChar)) && (vowelCounter[vowelIndexFromChar(currentChar)]==1)) {
				vowelCounter[vowelIndexFromChar(currentChar)]++;
			}
		}
		int firstPosition=-1;
		for (int i=0;i<vowelPosition.length;i++) {
			if (vowelCounter[i]==1) {
				if ((firstPosition==-1) || (vowelPosition[i]<firstPosition)) {
					firstPosition=vowelPosition[i];
					result=vowelCharFromIndex(i);
				}
			}
		}

		return result;
	}

}
