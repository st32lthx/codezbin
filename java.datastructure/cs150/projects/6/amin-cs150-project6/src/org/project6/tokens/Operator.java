package org.project6.tokens;

import org.project6.mainClasses.Stack;
import org.project6.mainClasses.Token;

/**
 * @author Amin Meyghani
 * @version Feb.22.2011 Data Structures project 6
 * @purpose: This class represents an operator and all the methods necessary to
 *           be called when a token is identified as an operator.
 * 
 * */
public class Operator implements Token {

	protected String readToken;
	protected String toBeAppended;
	private int currentOperatorPrecedence;

	public Operator(String read) {
		readToken = read;
		toBeAppended = "";
	}

	public String handle(Stack s) {
		toBeAppended = checkCases(s);
		s.push(readToken);
		return toBeAppended;
	}

	protected String checkCases(Stack s) {
		while (hasOneOfTheThreeConditionsHappened(s)) {
			popFromStackAndAppendToOutput(s);
		}
		return toBeAppended;
	}

	// ======================================
	// HELPER METHODS
	// ======================================
	/**
	 * This method checks the three conditions that are needed to be checked
	 * when the identified token is an operator.
	 */
	private boolean hasOneOfTheThreeConditionsHappened(Stack s) {
		return !isStackEmpty(s)
				&& !isTopLeftParen(s)
				&& !doesTopOperatorHaveLowerPrecedenceThanCurrentOne(s,
						currentOperatorPrecedence);
	}

	/**
	 * This method checks to see if the stack is empty.
	 * 
	 * @param s
	 *            , is the stack
	 * @return true if the stack is empty, false otherwise.
	 */
	private boolean isStackEmpty(Stack s) {
		return (s.getStackIncrementer() == 0);
	}

	/**
	 * This method checks if the token on top of stack is a left parenthesis.
	 * 
	 * @param stack
	 *            used to find the top token
	 * @return true if the top of stack is left parenthesis and false otherwise.
	 */
	private boolean isTopLeftParen(Stack s) {
		return (s.getStackTop().equals("("));
	}

	/**
	 * This method checks if the precedence of the operator on top of stack has
	 * lower precedence than the current read operator.
	 * 
	 * @param s
	 *            , the stack
	 * @return true if the operator on top of stack has lower precedence than
	 *         the current operator and false otherwise.
	 */
	private boolean doesTopOperatorHaveLowerPrecedenceThanCurrentOne(Stack s,
			int currentPrecedence) {
		findCurrentOperatorPrecedence();
		return (getPrecedenceOfTop(s) < currentOperatorPrecedence);
	}

	/**
	 * This method pops from stack and appends the popped token to the output.
	 * 
	 * @param s
	 *            , the stacked from which the token is popped from.
	 */
	private void popFromStackAndAppendToOutput(Stack s) {
		toBeAppended += s.pop();
	}

	/**
	 * This method finds the current operator precedence and sets the current
	 * operator precedence value accordingly.
	 */
	private void findCurrentOperatorPrecedence() {
		if (readToken.equals("+") || readToken.equals("-")) {
			currentOperatorPrecedence = 1;
		} else if (readToken.equals("*") || readToken.equals("/")) {
			currentOperatorPrecedence = 2;
		} else {
			currentOperatorPrecedence = 3;
		}
	}

	/**
	 * This method gets the precedence of the operator on top of the stack
	 * 
	 * @param s
	 *            is the stack
	 * @return topPrecedence, the precedence of the operator on top of stack
	 */
	private int getPrecedenceOfTop(Stack s) {
		int topPrecedence = 0;
		if (s.getStackTop().equals("+") || s.getStackTop().equals("-")) {
			topPrecedence = 1;
		} else if (s.getStackTop().equals("*") || s.getStackTop().equals("/")) {
			topPrecedence = 2;
		} else if (s.getStackTop().equals("^")) {
			topPrecedence = 3;
		}
		return topPrecedence;
	}
}
