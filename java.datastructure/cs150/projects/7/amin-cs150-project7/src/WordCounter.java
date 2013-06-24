/**
 * @author Amin Meyghani
 * @version March.07.2011
 * @purpose: This class represents the word counter Binary Search Tree. Each
 *  node of this tree holds a word and its frequency. 
 *  It contains the following methods:
 *  Public methods:
 *  getFrequencyFor(); which returns the frequency of a given word.
 */
public class WordCounter {

	private BinarySearchTree wordCounter;

	public WordCounter(String addressOfInputFile) {
		
		wordCounter = new BinarySearchTree();
		readAndAddToFrequecny(addressOfInputFile); 
	}

	/**
	 * This method counts the number of times a word has occurrence in the input text file.
	 * @param word is the word whose occurrence will be counted.
	 * @return the number of occurrence of the word in the input text file.
	 */
	public int getFrequencyFor(String word){
		WordProcessor processor = new WordProcessor();
		BSTnode node = wordCounter.search(processor.strip(word));
		int wordFrequency = (Integer) node.data;
		return wordFrequency;
	
	}
	
/**
 * This method creates the word counter. It reads one word at a time 
 * and if the word is found one is added to its frequency, otherwise the word's
 * frequency is set to one.
 * @param addressOfInputFile is the file that the words are read from.
 */
	private void readAndAddToFrequecny(String addressOfInputFile) {
		WordProcessor processor = new WordProcessor();
		BSTnode node = null;
		LineReader reader = new LineReader(addressOfInputFile, " ");
		String[] tokens = reader.getNextLine();

		while (canRead(tokens)) {
			for (int j = 0; j < tokens.length; j++) {
				String strippedTokens = processor.strip(tokens[j]);
				increment(strippedTokens,node);
			}	
			tokens = reader.getNextLine();
		}
	}


	// ---------helper methods-----------\\
	/**
	 * This method checks if we can still read from the file.
	 * @param tokens is the array containing tokens.
	 * @return true if we can still read from file and false otherwise.
	 */
	private boolean canRead(String[] tokens) {
		return(tokens != null);		
	}

	/**
	 * This method increments the data field of the nodes in the word counter.
	 * @param token are the words to be read.
	 * @param node checks if the word exits.
	 */
	private void increment(String token, BSTnode node){
		

			node = wordCounter.search(token);
			if (node != null) {

				Integer freq = (Integer) node.data;
				freq++;
				node = wordCounter.search(token);
				node.data = freq;

			} else {
				int frequency = 1;
				wordCounter.insert(new StringMaker(token), frequency);
			}
		
	}

	

}