/*

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

*/

class Solution {
    
     public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
    
    /*
    public boolean backspaceCompare(String S, String T) {
        
        Stack<Character> stacks = new Stack<>();
        Stack<Character> stackt = new Stack<>();
        
        for(int i=0; i<S.length(); ++i){
            char c = S.charAt(i);
            if(c == '#' && !stacks.isEmpty()){
                stacks.pop();
            }else if(c != '#'){
                stacks.push(c);
            }
        }
        
         for(int i=0; i<T.length(); ++i){
            char c = T.charAt(i);
            if(c == '#' && !stackt.isEmpty()){
                stackt.pop();
            }else if(c != '#'){
                stackt.push(c);
            }
        }
        
        if(stacks.size() != stackt.size())
            return false;
        
        
        while(!stacks.isEmpty() && !stackt.isEmpty()){
            if(stacks.pop() != stackt.pop()){
                return false;
            }
        }
        
        return true;
        
    }
    */
}
