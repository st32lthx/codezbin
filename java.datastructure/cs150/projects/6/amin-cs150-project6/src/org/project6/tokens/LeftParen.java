package org.project6.tokens;

import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This class represents a left parenthesis token whose handle method
 *          describes how it should be processed according to the rules defined
 *          in the converter class.
 */
public class LeftParen implements Token {

	String readToken;

	public LeftParen(String readToken) {

		this.readToken = readToken;

	}

	public String handle(Stack s) {

		s.push(readToken);
		return "";
	}

}
