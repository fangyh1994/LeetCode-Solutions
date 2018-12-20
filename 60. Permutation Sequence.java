/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/
class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        String res = "";
        
        //a list of numbers
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        //lookup list of factorial
        int temp = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            factorial[i] = temp;
        }
        
        k--;
        
        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n-i];
            res += Integer.toString(numbers.get(index));
            numbers.remove(index);
            k = k - index*factorial[n-i];
        }
        
        return res;
        
    }
}