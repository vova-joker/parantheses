package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CheckFullParenthesesTest extends TestCase {

    @Test
    public void testCheckFullParentheses() {
        String expected0 = "2 - ()";
        String expected1 = "4 - ()()";
        String expected2 = "6 - (()())";
        String expected3 = "0";
        String expected4 = "10 - ()(()())()";
        String expected5 = "0";
        CheckFullParentheses checkFullParentheses = new CheckFullParentheses();
        String actual0 = checkFullParentheses.checkFullParentheses("(()");
        String actual1 = checkFullParentheses.checkFullParentheses(")()())");
        String actual2 = checkFullParentheses.checkFullParentheses(")(()())");
        String actual3 = checkFullParentheses.checkFullParentheses(")(");
        String actual4 = checkFullParentheses.checkFullParentheses("())(()())(()");
        String actual5 = checkFullParentheses.checkFullParentheses(")");
        Assert.assertEquals(expected0, actual0);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
        Assert.assertEquals(expected5, actual5);
    }

}