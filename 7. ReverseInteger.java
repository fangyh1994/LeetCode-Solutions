/*
Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
*/
class Solution {
    public int reverse(int x) {
        try {
            boolean rev = (x < 0);
            if (rev) {
                x = Math.abs(x);
            }
            int result = 0;
            while (x != 0)
            {
                int pop = x % 10;
                x = x/10;
                if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
                if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
                result = result*10 + pop;
            }
            if (rev){
                result = -result;
            }
            return result;
        }
        catch (Exception e){
            return 0;
        }
    }
}