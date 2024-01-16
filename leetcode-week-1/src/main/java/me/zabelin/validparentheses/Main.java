package me.zabelin.validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
20. Valid Parentheses https://leetcode.com/problems/valid-parentheses/description/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.



Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false



Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

my - O(n)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    static public boolean isValid(String s) {
        Map<String, String> openToCloseBracket = new HashMap<>();
        openToCloseBracket.put("(", ")");
        openToCloseBracket.put("[", "]");
        openToCloseBracket.put("{", "}");

        Stack<String> openBrackets = new Stack<>();
        for (var bracket: s.toCharArray()) {
            if (isOpenBracket(bracket)) {
                openBrackets.push(String.valueOf(bracket));
            } else {
                if (openBrackets.isEmpty()) {
                    return false;
                }
                var lastOpenBracket = openBrackets.pop();
                if (!String.valueOf(bracket).equals(openToCloseBracket.get(lastOpenBracket))) {
                    return false;
                }
            }
        }

        return openBrackets.isEmpty();
    }

    private static boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

}
