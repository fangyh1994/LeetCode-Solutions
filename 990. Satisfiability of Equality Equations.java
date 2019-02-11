/*
Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

 

Example 1:

Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
Example 2:

Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
Example 3:

Input: ["a==b","b==c","a==c"]
Output: true
Example 4:

Input: ["a==b","b!=c","c==a"]
Output: false
Example 5:

Input: ["c==c","b==d","x!=z"]
Output: true
 

Note:

1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] and equations[i][3] are lowercase letters
equations[i][1] is either '=' or '!'
equations[i][2] is '='
 */
class Solution {
    private Map<Character, Character> map = new HashMap<>();
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                if (!connected(equations[i].charAt(0), equations[i].charAt(3)) ) {
                    union(equations[i].charAt(0), equations[i].charAt(3));
                }
            }
        }
        
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                if (connected(equations[i].charAt(0), equations[i].charAt(3))) {
                    return false;
                }
            }
        }
        return true;
    }

    private char root(char i){
        if (map.get(i) == null) {
            map.put(i, i);
        }
        while(i != map.get(i)){
            i = map.get(i);//i和id[i] 一起更新
        }
        return i;
    }

    /**
     * 判断p和q是否是连接的
     */
    public boolean connected(char p,char q){
        return root(p) == root(q);
    }

    /**
     * 将p的根节点设为q的根节点(p=>q p的根节点指向q)。
     */
    public void union(char p,char q){
        char qroot = root(q);//找到q的根节点
        char proot = root(p);
        map.put(proot, qroot);
    }

}