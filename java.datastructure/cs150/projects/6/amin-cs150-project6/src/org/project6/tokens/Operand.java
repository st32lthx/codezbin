package org.project6.tokens;

import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011 Data Structures project 6
 * @purpose This class represents a operand token whose handle method describes
 *          how it should be processed according to the rules defined in the
 *          converter class.
 */
public class Operand implements Token {

	String readToken;

	public Operand(String read) {

		readToken = read;

	}

	public String handle(Stack s) {

		return readToken;
	}
}
