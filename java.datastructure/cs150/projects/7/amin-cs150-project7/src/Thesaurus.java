/**
 * @author Amin Meyghani
 *@version March.06.2011
 *@purpose: This class represents a thesaurus. It contains makeThesaurus() that
 *makes a thesarus given an input text file. The first word in each line of the text file
 *will be the entry and the rest in the line the synonyms for that entry. 
 *
 *Public methods:
 *
 *I)getRandomSynonymFor(String target) =>given a string to look for, if the entry exists, it will return a random synonym for the string.
 *	else it will return an empty string.
 *II) getEntryFor(String target) => given a string to look for if the entry exists it will return the entry and empty string otherwise.
 *III)doesEntryExist(String target) => checks if a given string exists in the thesaurus. Returns true iff the entry does exist in the thesaurus.
 *
**/
public class Thesaurus { //is it necessary to be a subclass.
	
	private BinarySearchTree thesaurus ;	
	
	/**
	 * The default constructor that sets the root of the tree to null
	 */
	public Thesaurus(String thesaurusName){
		
		thesaurus = new BinarySearchTree();
		makeThesaurusFor(thesaurusName);
	}

	/**
	 * This method makes the thesaurus tree. 
	 * 
	 * First it reads from the thesaurus text file and then stores the read tokens in the array. 
	 * The 0th index of the array becomes the entry of the thesaurus and tokens in the 1st index
	 *  to the length-1 index will be the synonyms of that particular entry.
	 *   Afterwards, the synonyms are added to the bag 
	 *  Finally, the entry and the synonyms are added to the thesaurus.
	 * This process repeats until we run out of tokens to read from the input thesaurus text file.
	 */
	public void makeThesaurusFor(String input) {
		LineReader reader = new LineReader(input,",");
		String[] tokens = reader.getNextLine();
		while (canRead(tokens)) {
			Comparable entry = new StringMaker(tokens[0]);
			Bag synonyms = new Bag(tokens.length);
			addSynonyms(synonyms, tokens);

			tokens = reader.getNextLine();
			thesaurus.insert(entry, synonyms);
		}
	}

	/**
	 * This method looks for a random synonym of a given word as a string.
	 * 
	 * @param target is the string to look for
	 * @return synonym of the target word as a string.
	 */
	public String getRandomSynonymFor(String target) {
		WordProcessor processor = new WordProcessor();
		String randomSynonym = "";

		if (this.doesEntryExist(target)) {

			Bag synonymBag = (Bag) thesaurus.search(processor.strip(target)).data;
			randomSynonym += synonymBag.getItemAtIRandomndex(1);
			return randomSynonym;
		} else {
			return "";
		}	
		
	}
	/**
	 * This method looks for a given string in the thesaurus and returns it.
	 * @param target is the string to look for
	 * @return the string that we were looking for if it exists and 
	 * empty string if it does not exist.
	 */
	public String getEntryFor(String target){
		String entry = "";
		if (this.doesEntryExist(target)) {
			entry += thesaurus.search(target);
			return entry;
		} else {
			return "";
		}
	}

/**
 * This method checks if a given entry exists in the thesaurus.	
 * @param target is the entry to look for in the thesaurus.
 * @return true iff the entry exists in the thesaurus.
 */
public boolean doesEntryExist(String target){
	WordProcessor processor =  new WordProcessor();
return (thesaurus.search(processor.strip(target))!=null);
}
	
	
	//-------makeThesaurus() helpers-----------\\
	/**
	 * This methods adds synonyms to the bag of synonyms.
	 * @param bag is the bag to which the synonyms are added.
	 * @param tokens are the synonyms to be added to the bag.
	 */
		private void addSynonyms(Bag bag, String[] tokens) {

			for (int i = 1; i < tokens.length; i++) {
				bag.add(new StringMaker(tokens[i]));
			}
		}
	/**
	 * This method checks if we there are still words to read from the input text file.
	 * @param tokens are the words in the text file.
	 * @return true if there are words in text file and false otherwise.
	 */
		private boolean canRead(String[] tokens) {
			return (tokens != null);
		}	
}
