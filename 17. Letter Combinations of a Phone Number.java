/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	
Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
.*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List <String> result = new ArrayList<>();
        String mobileDigit[] = {"e","e","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        if (digits.length()>1){
            int firstDigit = Integer.parseInt(digits.substring(0,1));
            digits = digits.substring(1,digits.length());
            result = letterCombinations(digits);
            {
                List <String> temp = new ArrayList<>();
                for (int j = 0; j < result.size(); j++){
                    for (int i = 0;i < mobileDigit[firstDigit].length();i++){
                        String element = "";
                        element = mobileDigit[firstDigit].substring(i,i+1) + result.get(j);
                        temp.add(element);
                    } 
                }
                result = temp;
                return result;   
            }
        } else if(digits.length() == 1){
            int firstDigit = Integer.parseInt(digits.substring(0,1));
            for (int i = 0;i < mobileDigit[firstDigit].length();i++){
                result.add(mobileDigit[firstDigit].substring(i,i+1));
            }
            return result;
        } else{
            return result;
        }
    }
}