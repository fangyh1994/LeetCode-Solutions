/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

class Solution {
    public String multiply(String num1, String num2) {
        String res = "";
        if (num1.length() == 0 || num2.length() == 0 || Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        String multi = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            String temp = "0";
            for (int j = 1; j <= Integer.parseInt(num1.substring(i,i+1)); j++ ) {
                temp = add(temp, num2);
            }
            
            temp = temp + multi;
            multi = multi + "0";
            res = add(res, temp);
        }
        return res;
    }
    
    public String add(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2.length() == 0  || Objects.equals(num2, "0")) {
            return num1;
        }
        String res = "";
        int length1 = num1.length();
        int length2 = num2.length();
        int carry = 0;
        for (int i = 0; i <= length2 - 1; i++) {
            int a = num1.charAt(length1-1-i) - '0';
            int b = num2.charAt(length2-1-i) - '0';
            int sum = a+b+carry;
            String s = Integer.toString(sum);
            if (sum >= 10) {
                carry = 1;
                s = s.substring(1,s.length());
            } else {
                carry = 0;
            }
            res = s+res;
        }
        if (carry == 0) {
            res = num1.substring(0, length1 - length2)+ res;
            return res;
        }
        for (int i = length2; i <= length1 - 1; i++) {
            int a = num1.charAt(length1-1-i) - '0';
            int sum = a + carry;
            String s = Integer.toString(sum);
            if (sum >= 10) {
                carry = 1;
                s = s.substring(1,s.length());
            } else {
                carry = 0;
            }
            res = s+res;
        }
        if (carry == 1){
            res= "1"+res;
        }
        return res;
    }
}