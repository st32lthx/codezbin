package org.project6.tokens;

import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;
import org.project6.tokens.Operator;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This class represents a plus token whose handle method describes how
 *          it should be processed according to the rules defined in the
 *          converter class.
 */
public class Plus extends Operator implements Token {

	public Plus(String read) {
		super(read);
	}

	public String toString() {
		return "+";
	}
/**
 * This is the handle method that defines how this token should be handled 
 * when read by the converter in the converter class. This method implements
 * the Token interface.
 */
	public String handle(Stack s) {
		toBeAppended = checkCases(s);
		s.push(readToken);
		return toBeAppended;
	}

}