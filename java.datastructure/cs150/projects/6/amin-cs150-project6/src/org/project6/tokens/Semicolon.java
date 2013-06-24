package org.project6.tokens;

import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This class represents a semicolon token whose handle method
 *          describes how it should be processed according to the rules defined
 *          in the converter class.
 */
public class Semicolon implements Token {

	String theOutput;

	public Semicolon() {
		theOutput = "";
	}

	public String toString() {
		return ";";
	}

	/**
	 * This is the handle method that defines how this token should be handled
	 * when read by the converter in the converter class. This method implements
	 * the Token interface.
	 */
	public String handle(Stack s)

	{
		String mainOutput = popAllAndAppendToOutput(s);

		return mainOutput;
	}
/**
 * This method pops all the tokens in the stack to the output answer.
 * @param s is the stack from which tokens are popped from.
 * @return the sting to be appended to the output answer.
 */
	private String popAllAndAppendToOutput(Stack s) {

		if (s.getStackTop().equals("(")) {
			s.pop();

		} else {
			while (!isStackEmpty(s)) {
				theOutput += s.pop();

			}

		}
		return theOutput + "\n";

	}
/**
 * This method checks if the stack is empty.
 * @param s is the stack
 * @return returs true if and only if the stack is empty.
 */
	private boolean isStackEmpty(Stack s) {
		return (s.getStackIncrementer() == 0);
	}
}
