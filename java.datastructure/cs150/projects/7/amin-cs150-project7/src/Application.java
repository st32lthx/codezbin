/**
 * @author Amin Meyghani
 *@version March.7.2011
 *@purpose This class contains the main method. It is responsible to make a GrammerChecker
 *object and have its checkGrammer method to apply the grammar check operation on an input text file.
 *
 * When the method is called on the input file, two object are created.
 *One is the thesaurus that contains entries and a of synonyms for each entry 
 * and the other is a word counter that records the frequency of each 
 *word given an input text file. Having the two objects available, it goes through the algorithm:
 *
 * For every word in the text file it checks if any overused word
 *has an entry in the thesarus and  if the entry exists , the word is replaced by its random synonym and  if the 
 *entry does not exists in the thesaurus the word is not replaced.
 * It keeps on doing the same thing until there are no more words to read from the text file.
 */
public class Application {
		 // SHORT VERSION 
		 
		public static void main(String[] args) {
			String[] inputFiles={"input/lamb.txt","input/apartment.txt","input/withCapitalCase.txt","input/withCommaOnly.txt","input/withSymbols.txt","input/test.txt"};
				GrammerChecker evaluator = new GrammerChecker("bigThesaurus.txt");
				checkGrammer(inputFiles, evaluator);
			
				System.out.println("Done! Output files were created in the poject folder successfully.");
			}
		
		
		/**
		 * The helper method that helps to create the output files.
		 * @param inputFiles is the array containing text files that are going to be checked.
		 * @param evaluator is a grammerChecker object.
		 */
		private static  void checkGrammer(String[] inputFiles, GrammerChecker evaluator){
			for (int i = 0; i < inputFiles.length; i++) {
				evaluator.checkGrammerAndWriteToFIle(inputFiles[i],"output/"+"Output"+inputFiles[i].substring(6, inputFiles[i].length()));
			}
	
		}
	
}
