/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        if (s == null ||s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        String current = "";
        int sign = 1;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                current += s.charAt(i);
            } else if (s.charAt(i) == '+') {
                result += trans(current) * sign;
                current = "";
                sign = 1;
            } else if (s.charAt(i) == '-') {
                result += trans(current) * sign;
                current = "";
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                current = "";
            } else if (s.charAt(i) == ')') {
                result += trans(current) * sign;
                result = result * stack.pop();
                result += stack.pop();
                current = "";
            } 
        }
        return result + trans(current) * sign;
    }
    public int trans (String s){
        if (s.equals("")){
            return 0;
        } else {
            return Integer.parseInt(s);
        }
    }

/* better solution
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res +stack.pop();
            }
        }
        return res;
    }

}

*/
}