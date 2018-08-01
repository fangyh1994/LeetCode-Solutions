/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
*/

//time complexityO(n^2)
class Solution {
    public String convert(String s, int numRows) {
        String output= "";
        if (numRows == 1){
            return s;
        }
        for (int j = 1; j <= numRows; j++){
            //first row and last row 
            if ((j==1)||(j == numRows)){
                for (int i = 0; i < s.length();i++){
                    if (  ( (i-(j-1)) % (2*(numRows-1)) ) == 0)  {
                        output = output + s.charAt(i);
                    }
                }   
            } else{
                //middle rows
                for (int i = 0; i < s.length();i++){
                    if ( (( (i-(j-1)) % (2*(numRows-1)) ) == 0)  ||   ((i+1 - (2*numRows-j) )% (2*(numRows-1))  == 0)   ){
                        output = output + s.charAt(i);
                    }
                }  
            }
                 
        }
                    //||(i-3*j+1) % (2*(numRows-1)) == 0  )
        return output;
    }
}