package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CheckFullParentheses checkFullParentheses = new CheckFullParentheses();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Insert parentheses: ");
            String checkedParentheses = checkFullParentheses.checkFullParentheses(scanner.next());
            System.out.println("Output: " + checkedParentheses);
        }
    }
}
