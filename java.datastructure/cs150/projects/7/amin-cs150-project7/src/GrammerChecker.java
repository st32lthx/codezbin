/**
 * @author Amin Meyghani
 *@version March.7.2011
 *@purpose This class represent a class that does the  grammar check operation on an input text file. 
 *It is a subclass of the wordProcessor class that processes the punctuation marks and extra symbols.
 *
 *It does it by first creating two Binary Search Trees. 
 *One for holding the thesaurus information and the other for the word counter information. 
 *Then it reads from the input file and for each word in the input file it checks word counter tree for frequency of word
 *and if frequency is above some threshold it checks thesaurus for an entry and if the entry is not 
 *there it appends the original word to the string that is to be written out. Otherwise if the 
 *entry exists in the thesaurus it gets a random synonym for that word and replaces it by the overused
 *word in the input file.
 */
public class GrammerChecker{
	
	
	private int threshold;
	private Thesaurus thesaurus;
/**
 * The non-default constructor that takes the name o the thesaurus text file and 
 * makes the thesaurus file out of it.
 * @param thesaurusName is the name of the thesaurus used to make the thesaurus.
 */
	public GrammerChecker(String thesaurusName){
		 thesaurus = new Thesaurus(thesaurusName);
		 threshold = 3;
		 
	}
	/**
	 * This is the important method that does all the grammer checking for the program.
	 * @param input is the address of the input file to be grammer checked.
	 * @param nameOfOutputFile is the name of the outputfile as a result of grammer checking
	 * @param thesaurusAddress is the address of the thesaurus text file to be used.
	 */
	public void  checkGrammerAndWriteToFIle(String input, String nameOfOutputFile){
		
		WordCounter wordCounter = new WordCounter(input);
		StringWriter write = new StringWriter(nameOfOutputFile);
		LineReader reader = new LineReader(input, " ");

		String[] tokens = reader.getNextLine();
		String toBeWritten = "";
		String synonym = "";
		WordProcessor processor = new WordProcessor();
		while (canRead(tokens)) {
			for (int i = 0; i < tokens.length; i++) {


				if (isFrequencyAboveThreshold(wordCounter, tokens, i))  {
					String punctuation = " ";
					String strippedWord = processor.strip(tokens[i]);
					
					if (thesaurus.doesEntryExist(strippedWord)) {
						synonym = thesaurus.getRandomSynonymFor(tokens[i]);
						 punctuation = processor.getPunctuation(tokens[i]);
						toBeWritten += synonym + punctuation;
					} else {
						toBeWritten += (tokens[i])+" ";
					}
				}else {
					toBeWritten += (tokens[i]) + " ";
				}
			}
			tokens = reader.getNextLine();
		}
		write.write(toBeWritten);
		write.closeFile();
	}

	/**
	 * This method checks if we can still read from the file.
	 * @param tokens is the array containing tokens.
	 * @return true if we can still read from file and false otherwise.
	 */
	private boolean canRead(String[] tokens) {
		return(tokens != null);		
	}
	/**
	 * This helper method checks if the frequency of a given word is above the threshold.
	 * @param wordCounter is the word counter to look in
	 * @param tokens are words that we get frequency for.
	 * @param i number of times that we go through loop.
	 * @return
	 */
	private boolean isFrequencyAboveThreshold(WordCounter wordCounter, String[] tokens, int i){
		return(wordCounter.getFrequencyFor(tokens[i]) >= threshold);
	}

}
