package com.myworks;

import java.util.EmptyStackException;
import java.util.Stack;

public class Validation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Validation v = new Validation();
		System.out.println(v.isValidExpression("(]"));
		System.out.println(v.isValidOperator("1*6/4+9"));

	}
	
	/* Check for the valid expression 
	   all square braces should be in between () and 
	   each open should have a close */
	
	private boolean isValidExpression(String instr) {
		char[] in = instr.toCharArray(); // Convert String into char array
		Stack<Character> t = new Stack<Character>(); // Stack stores all braces
		for (int i=0;i<in.length;i++) {
			switch (in[i]) {
			case '(':
				if(t.contains('('))  // 
					return false;
				t.push('(');
				break;
			case '[':
				if(t.contains('[')) 
					return false;
				t.push('[');
				break;
			case ']':
				if(t.isEmpty() || !(t.pop().equals('[')))  // if empty return false or pop topStack to see if it has corresponding open braces
					return false;
				break;
			case ')':
				if(t.isEmpty() || !(t.pop().equals('('))) // if empty return false or pop topStack to see if it has corresponding open braces
					return false;
				break;
			}
		}
		return t.isEmpty();
		
	}
	
	/* Check for Valid operator valid in sense with operator precedence, */
	private boolean isValidOperator(String instr) {
		char[] in = instr.toCharArray();        // Convert given string to char array
		Stack<Character> operator = new Stack<Character>();  // 2 Stacks, 1 for operands and 1 for operator
		Stack<Integer> operand = new Stack<Integer>();
		try {
		for(int i=0;i<in.length;i++){
			if(in[i]=='+' || in[i] =='-') {
				if(!operator.isEmpty()) {       // if empty just push on topStack else 
 					while(!(operator.isEmpty())) {
                        operand.push(doCalculations(operand.pop(), operator.pop(), operand.pop())); // Pop operands and operator, do calculation, push result on operands
					}
				}
				operator.push(in[i]); // push operator
				
			}
			else if(in[i]=='*' || in[i] == '/'){
				if(!operator.isEmpty()) {
					if(operator.peek()=='*' || operator.peek()=='/'){
						operand.push(doCalculations(operand.pop(),operator.pop(),operand.pop()));
					}
				}
				operator.push(in[i]);
			}
				
			else 
				operand.push(Integer.parseInt(String.valueOf(in[i])));
			//postfix.append(in[i]);
		}
		while(!(operator.isEmpty())) {
            operand.push(doCalculations(operand.pop(), operator.pop(), operand.pop()));     
		}
		System.out.println(operand.pop());
		}
		catch (EmptyStackException e) {
			return false;
		}
		
		return true;
	}
	
	private int doCalculations(Integer i, Character k, Integer j) {
		int result=0;
		switch (k) {
		case '*':
			result=j*i;
			break;
		case '/':
			if(i!=0)
				result=j/i;
			break;
		case '+':
			result=j+i;
			break;
		case '-':
			result=j-i;
			break;
		}
		return result;
		
	}

}
