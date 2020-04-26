/*

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].

*/

class Solution {
   public boolean checkValidString(String s) {
        int a=0,b=0,p=0,q=0,n=s.length();
        char c;
        for(int i=0;i<n;i++){
            c=s.charAt(i);
            if(c=='(')
                a++;
            else if(c=='*')
                b++;
            else{
                if(a>0)
                    a--;
                else if(b>0)
                    b--;
                else
                    return false;
            }
            c=s.charAt(n-1-i);
            if(c==')')
                p++;
            else if(c=='*')
                q++;
            else{
                if(p>0)
                    p--;
                else if(q>0)
                    q--;
                else
                    return false;
            }
        }        
        return true;
    }
}
