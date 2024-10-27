import java.util.*;

//we need to rverse infix string and then to postfix;then instead we pop inverse of precedence pop unlike postfix and than we inverse it; 
public class infixtoprefix {
    static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        return sb.toString();
    }

    static int prec(char ch) {
        if (ch == '^') {
            return 3;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    static void infix_prefix(String exp) {
        String ss = rev(exp);
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length(); i++) {
            char ch = ss.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());

                }
                st.pop();
            } else {
                while (!st.isEmpty() && prec(st.peek()) >= prec(ch)) {
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(rev(sb.toString()));
    }

    public static void main(String[] args) {
        // infixtopostfix gfg = new infixtopostfix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";// abcd^e-fgh*+^*+i-
        infix_prefix(exp);
    }
}
