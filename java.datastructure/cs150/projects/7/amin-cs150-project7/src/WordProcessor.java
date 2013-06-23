/**
 * @author Amin Meyghani
 *@version March 09 2011
 *This class represents a word processor that takes care of the extra punctuation marks given 
 *a word. It has different methods with different signatures that are used for different purposes.
 *
 * strip(String token) is used for stripping extra punctuation marks from a single word that is needed 
 * to be searched for in the thesaurus for.
 * example: really,.!- = > really
 * getPunctuation(String token) => returns the punctuation in a word if it has any at the end of it. Returns 
 * empty string otherwise.
 */
public class WordProcessor {
	private  String [] symbols = { ",", ".", "?", "!", "~", "-", "'", "(", ")","/", "{", "}", "*", "&", "%", "$", "#", "@", "^"};
	
	/**
	 * This method removes extra punctuation marks for a given word.
	 * @param token is the word that is passed in.
	 * @return the word without extra punctuation marks.
	 */
public String strip(String token){
		
		String punctuation = "";

		
		for (int l = 0; l < symbols.length; l++) {
			if (token.contains(symbols[l])) {
				punctuation = symbols[l];
				token = removePunctuation(token, punctuation);
			}
		}
		return token;
	}

/**
 * This method returns the string from index 0 to before the index of the occurrence of the 
 * punctuation mark.
 * @param token is the word passed in as a string.
 * @param punctuation is the punctuation to be removed.
 * @return the word without punctuation marks.
 */
	private String removePunctuation(String token, String punctuation) {
		String strippedString = null;
		strippedString = token.substring(0, token.indexOf(punctuation));
		return strippedString;
	}

	/**
	 * This method gets the punctuation marks of a given word and returns it.
	 * @param token is the string passed in.
	 * @return the punctuation symbol at the end of the string.
	 */
	public String getPunctuation(String token){
		
			String punctuation = " ";
			for (int j = 0; j < symbols.length; j++) {
				if (token.contains(symbols[j])) {
					punctuation = token.substring(token.indexOf(symbols[j]),token.length());
					return punctuation + " ";
				}
			}

			return punctuation;
		}
}



