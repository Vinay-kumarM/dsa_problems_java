
/*Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.
Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:Digit 8 is inside of 3 nested parentheses in the string. */
import java.util.Stack;

public class maximumdepth_parenthis {
    static int funct(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        // it checks maximum depth updates count everytime we get new depth
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (s.charAt(i) == ')') {
                if (count < st.size()) {
                    count = st.size();
                }
                st.pop();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";// 3
        String s2 = "(1)+((2))+(((3)))";// 3
        String s3 = "()(())((()()))";// 3
        System.out.println(funct(s1));
        System.out.println(funct(s2));
        System.out.println(funct(s3));
    }
}
