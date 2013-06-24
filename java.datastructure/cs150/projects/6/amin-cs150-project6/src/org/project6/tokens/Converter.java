package org.project6.tokens;

import org.project6.mainClasses.FileReader;
import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This class contains the converter method that reads in a token,
 *		identifies it, makes a new Token type from it, and then calls the
 *		item's handle() method to process it. It repeats this process
 *		until all tokens have been read and processed.
 */
// ======================================
public class Converter {

	private String readToken;
	private String output;
	private Stack stack;
	private FileReader reader;
	private String fileAddress;

	public Converter(String address) {
		fileAddress = address;
		output = "";
		reader = new FileReader(fileAddress);
		stack = new Stack();
		readToken = "";
	}

	// ======================================
	/**
	 * This method is responsible to convert each read token. 
	 */
	public void convert() {
		readTokenFromFile();
		while (canReadFromFile()) {
			convertTheReadTokenAccordingToAlgorithm();
			readTokenFromFile();
		}
		printResults();
	}

	// ======================================

	/**
	 * This is the main method that is responsible for converting the read token
	 * from the text file depending on the nature of the read token. Depending on the
	 * type of read token this method will call appropriate methods from the
	 * interface (Token) according to the following algorithm:
	 * Algorithm:
	 * If the read token is an operand, the token is appended to the output. 
	 * If the read token is an operator the top of stack is popped  and appended to the output until stack
	 * is empty, or the top of stack is left parenthesis or the top of the stack
	 * has less precedence than the read token.
	 * If the read token is left parenthesis the token is pushed to the stack.
	 * If the read token is right parenthesis tokens are popped from stack and appended to the output until the top of stack is left parenthesis.
	 * If the read token is semicolon, tokens are popped from stack and appended to answer until the stack is empty.
	 */
	private void convertTheReadTokenAccordingToAlgorithm() {
		Token currentToken;

		if (isOperand()) {
			currentToken = new Operand(readToken);
			output += currentToken.handle(stack);
		}

		else if (isOperator()) {

			currentToken = (Token) new Operator(readToken);
			output += currentToken.handle(stack);

		} else if (isLeftParen()) {

			currentToken = new LeftParen(readToken);
			output += currentToken.handle(stack);

		} else if (isRightParen()) {

			currentToken = new RightParen(readToken);
			output += currentToken.handle(stack);

		} else {

			currentToken = new Semicolon();
			output += currentToken.handle(stack);
		}

	}

	// ======================================
	/**
	 * This method reads the next token from the text file and stores in the
	 * readToken variable.
	 */
	private void readTokenFromFile() {
		readToken = reader.nextToken();
	}

	/**
	 * This method prints the results after all the tokens are read from the
	 * text file.
	 */
	private void printResults() {
		System.out.print("The Input file is" + "'" + fileAddress + "'"
				+ " and the following are the outputs: " + "\n" + output);
	}

	/**
	 * This method determines when we have reached the end of the file or not.
	 * 
	 * @return true if we have reached the end of the file, false otherwise.
	 */
	private boolean canReadFromFile() {
		return !(readToken.equals("EOF"));
	}

	/**
	 * This method checks if the read token is an operand.
	 * @return true if the read token is an operand and false otherwise.
	 */
	private boolean isOperand() {

		return !(isOperator() ||  readToken.equals(";")|| readToken.equals("(")|| readToken.equals(")"));	 
	}

	/**
	 * This method checks if the read token is a plus operator.
	 * @return true if the read token is an operator and false otherwise.
	 */
	
/**
 * This method checks if the read token is an operator.
 * @return
 */
	private boolean isOperator() {

		return (isExponent() || isDivision() || isMultiplication() || isPlus() || isMinus());
	}
	/**
	 * This method checks if the read token is a left parenthesis
	 * @return true if the read token is a left parenthesis and false otherwise.
	 */
	private boolean isLeftParen() {

		return (readToken.equals("("));
	}

	/**
	 * This method checks if the read token is right parenthesis.
	 * @return true if the read token is right parenthesis and false otherwise.
	 */

	private boolean isRightParen() {

		return (readToken.equals(")"));
	}
	//--------------------------------------
	//--------------------------------------
	
	private boolean isPlus() {
		return (readToken.equals("+"));
	}

	/**
	 * This method checks if the read token is a minus operator. 
	 * @return true if the read token is a minus operator and false otherwise.
	 */

	private boolean isMinus() {
		return (readToken.equals("-"));
	}

	/**
	 * This method checks if the read token is a divider.
	 * @return true if the read token is a divider and false otherwise.
	 */

	private boolean isDivision() {
		return (readToken.equals("/"));
	}

	/**
	 * This method checks if the read token is a multiplier.
	 * @return true if the read token is a multiplier and false otherwise
	 */
	private boolean isMultiplication() {
		return (readToken.equals("*"));
	}

	/**
	 * This method checks if the read token is an exponent operator.
	 * @return true if the read token is an exponent operator and false otherwise,
	 */
	private boolean isExponent() {

		return (readToken.equals("^"));
	}

}
