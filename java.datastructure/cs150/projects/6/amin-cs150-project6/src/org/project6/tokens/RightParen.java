package org.project6.tokens;

import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This class represents a right parenthesis token whose handle method
 *  describes how it should be processed according to the rules defined
 * in the converter class.
 */
public class RightParen implements Token {

	String readToken;
	String output;

	public RightParen(String read) {
		readToken = read;

	}

	public String toString() {
		return ")";
	}
	/**
	 * This is the handle method that defines how this token should be handled 
	 * when read by the converter in the converter class. This method implements
	 * the Token interface.
	 */
	public String handle(Stack s) {
		String output = appendToAnswerAllOperatorsUntilFacedALeftParen(s);
		discardThisPairOfParenthesis(s);
		return output;
	}
/**
 * This method pops from the stack and append operators to the output
 * answer until the top of the stack is a left parenthesis.
 * @param s is the stack from which the operators are popped from
 * @return the output string that is to be appended to the output answer.
 */
	private String appendToAnswerAllOperatorsUntilFacedALeftParen(Stack s) {

		while (!isStackEmpty(s)) {
			if (!s.getStackTop().equals("(")) {
				output = s.pop();
			} else {
				return output;
			}
		}

		return output;
	}
/**
 * This method checks if the stack is empty
 * @param s, the stack
 * @return true if and only if the stack is empty.
 */
	private boolean isStackEmpty(Stack s) {
		return (s.getStackIncrementer() == 0);
	}
/**
 * This method discards extra parenthesis
 * @param s is the stack from which the extra parenthesis is popped from.
 */
	private void discardThisPairOfParenthesis(Stack s) {

		if (s.getStackIncrementer() != 0) {
			s.pop();
		} else {
			s.pop();
		}

	}

}
