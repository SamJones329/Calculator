package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Calculator {

    
    /**
     * Creates a calculator.
     * @param args 
     */
    public static void main(String[] args) {
        new Calculator();
    }
    
    
    /**
     * Creates a Calculator, constructing the GUI.
     */
    public Calculator(){
        new GUI();
    }
    
    
    /**
     * Evaluates infix statements into values.
     * @param infix - The infix string to be evaluated.
     * @return - A string representation of the double value the infix statement
     * evaluates to.
     */
    public static String evaluate(String infix) {
        ArrayList<String> args = infixToPostfix(infix);
        Stack<Double> s = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        
        String element;
        for(int i = 0; i < args.size(); i++) {
            element = args.get(i);
            if(operators.contains(element)) {
                //Right operand is higher in stack
                double right = s.pop();
                double left = s.pop();
                s.push(calculate(left, right, element));
            } else {
                s.push(Double.parseDouble(element));
            }
        }
        
        return Double.toString(s.pop());
    }
    
    
    /**
     * A helper method for evaluate used to calculate individual operations.
     * @param left - The operand left of the operator.
     * @param right - The operand right of the operator.
     * @param operand - a String containing the operand.
     * @return - the double value resulting from the calculation.
     */
    public static double calculate(double left, double right, String operand) {
        switch(operand) {
            case "+":
                return left+right;
            case "-":
                return left-right;
            case "*":
                return left*right;
            case "/":
                return left/right;
            default:
                throw new IllegalArgumentException("Invalid Operator");
        }
    }
    
    
    /**
     * Takes an input String in infix notation and converts it to an ArrayList
     * of postfix or reverse polish notation elements.
     * @param input - The string to be converted.
     * @return - an ArrayList of Strings which can be joined to get a String in
     * postfix notation.
     */
    public static ArrayList<String> infixToPostfix(String input) {
        ArrayList<String> inputArr = infixToArrayList(input);
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("/", 5);
        precedence.put("*", 5);
        precedence.put("-", 4);
        precedence.put("+", 4);
        precedence.put("(", 0);
        ArrayList<String> q = new ArrayList<>(); 
        Stack<String> s = new Stack<>();
        
        for(int i = 0; i < inputArr.size(); i++) {
            String element = inputArr.get(i);
            try {
                Double.parseDouble(element);
                q.add(element);
            } catch(NumberFormatException e) {
                if(element.equals("("))
                    s.push(inputArr.get(i));
                else if(element.equals(")")) {
                    while(!s.peek().equals("("))
                        q.add(s.pop());
                    s.pop();
                } else {
                    while(!s.empty() && precedence.get(s.peek()) >= precedence.get(element))
                        q.add(s.pop());
                    s.push(element);
                }
            }
        }
        
        while(!s.empty())
            q.add(s.pop());
        
        return q;
    }
    
    
    /**
     * Converts a String in infix notation to an ArrayList of the individual 
     * elements of the String (i.e. {2, +, 2})
     * @param input - The String to be converted to an ArrayList
     * @return - The ArrayList containing the infix 
     */
    public static ArrayList<String> infixToArrayList(String input) {
        ArrayList<String> result = new ArrayList<>();
        int length;
        for(int i = 0; i < input.length(); i++) {
            try{
                Integer.parseInt(Character.toString(input.charAt(i)));
                length = getNumberLength(input, i);
                result.add(input.substring(i, i+length));
                i+=length-1;
            } catch(NumberFormatException e){
                result.add(Character.toString(input.charAt(i)));
            }
        }
        return result;
    }
    
    
    /**
     * A helper method to get the length of a number within a String.
     * @param input - The String containing the number.
     * @param startIndex - The index at which the number starts.
     * @return - The length of the number.
     */
    public static int getNumberLength(String input, int startIndex) {
        startIndex++;
        try {
            char c = input.charAt(startIndex);
            if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || 
                    c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '.'){
                return 1+getNumberLength(input, startIndex);
            } else 
                return 1;
        } catch(Exception e){
            return 1;}
    }
}
