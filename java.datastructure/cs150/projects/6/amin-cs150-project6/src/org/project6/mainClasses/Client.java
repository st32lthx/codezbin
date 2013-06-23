package org.project6.mainClasses;


import org.project6.tokens.Converter;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This is the class that contains the main method. Its purpose is to
 *          create a new Converter and tell it to convert expressions inside a
 *          text file from infix form to postfix form.
 */
// ======================================
// MAIN TEST
// ======================================
public class Client {
	static String[] testFiles = { "sample.txt", "testWithParen.txt","input.txt" };
	public static void main(String[] args) {
		runTests();
	}
	
// ======================================
//MAIN TEST	
// ======================================

	/**
	 * This method finds the files that are needed to be converted and then
	 * creates a converter object and converts the files.
	 */
	private static void runTests() {
		for (int i = 0; i < testFiles.length; i++) {
			Converter file = new Converter(testFiles[i]);
			file.convert();
			System.out.println("---------");
		}
	}
}
