/*
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); //eliminates leading and trailing spaces
        // split string before and after "e" if there is "e"     
        int ePosition = -1;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                count++;
                ePosition = i;
            }
        }
        if (count >= 2) {
            return false;
        } else if (count == 1) {
            if (ePosition == 0 || ePosition == s.length()) {
                return false;
            } else {
                return isValidNumber(s.substring(0,ePosition)) && isValidWithoutPoint(s.substring(ePosition+1));
            }
        } else {
            return isValidNumber(s);
        }
    }
    
    private boolean isValidNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        if ((s.charAt(0) == '-' || s.charAt(0) == '+') && !hasTwoOrMoreMinusSign(s)) {
            return isValidNumber(s.substring(1));
        }
        
        int pointCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            } else if (s.charAt(i) == '.'){
                pointCount++;
                continue;
            } else {
                return false;
            }
        }
        if (pointCount > 1 || pointCount == s.length()) {
            return false;
        }
        return true;
    }
    
    private boolean isValidWithoutPoint(String s) {
        if (s.length() == 0) {
            return false;
        }
        if ((s.charAt(0) == '-' || s.charAt(0) == '+') && !hasTwoOrMoreMinusSign(s)) {
            return isValidNumber(s.substring(1));
        }
        
        int pointCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasTwoOrMoreMinusSign (String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                count++;
            }
        }
        return count >= 2;
    }
}

