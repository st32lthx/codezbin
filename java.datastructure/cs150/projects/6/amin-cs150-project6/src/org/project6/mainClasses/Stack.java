package org.project6.mainClasses;

/**
 * @author Amin Meyghani
 * @version Feb.19.2011
 * Data Structures project 6
 * @purpose This class creates a stack using array and contains
 * all the operations needed to use the stack.
 */

//======================================
public class Stack {

	private String[] stack;
	private int stackIncrementer;
	private String poped;

	public Stack(){
	stack = new String [50];	
	stackIncrementer = 0;	
	poped = "";
	}

//======================================
/**
 * This method checks if the stack is empty
 * @return true if and only if the top of the stack is empty.
 */
	public boolean isEmpty(){
		  return (stackIncrementer==-1);
		}
//======================================
/**
 * This is the push method that pushes an item to the top of 
 * the stack.
 * @param X is the item pushed to the stack.
 */
	public void push(String readToken){
	
		  stack[stackIncrementer]=readToken;
		  stackIncrementer++;
		
		}
//======================================
/**
 * This is the pop method that pops an item from the stack 
 * and returns it.
 * @return the popped item from the stack.
 */
	public String pop(){
		  if(!isEmpty()) {
			  poped= stack[stackIncrementer-1];
			  stack[stackIncrementer-1]=null;
			  stackIncrementer--;
		  }
		  else{
			  System.out.println("Stack is empty!!");
		  }
		return poped;
		 
		}
	
//======================================
/**
 * This method returns the StackIncrementer.
 * @return the StackIncrementer of the stack.
 */public int  getStackIncrementer(){
	  return stackIncrementer;
	}
//======================================
 /**
  * This method returns the top of the stack.
  * @return the top of the stack if the stack is not empty.
  */public String  getStackTop(){
	  String message = "";
	  if(stackIncrementer!=0){
		  return stack[stackIncrementer-1];
	  }
	  else{
	 	  return message ;
	  }
 	}
}
