/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length()-9; i++){
            String sequence = s.substring(i,i+10);
            if (map.containsKey(sequence) && (map.get(sequence) == 1)) {
                map.put(sequence, 2);
                result.add(sequence);
            } else if (map.containsKey(sequence) && (map.get(sequence) == 2)){   
            } else {
                map.put(sequence, 1);
            }
        }
        return result;
    }
}