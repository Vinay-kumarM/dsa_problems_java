import java.util.*;

public class infixtopostfix {
    static int prec(char c) {
        if (c == '^') {
            return 3;
        }
        if (c == '*' || c == '/') {
            return 2;
        }
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    static void infix_postfix(String s)

    {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && prec(c) < prec(st.peek())) {
                    sb.append(st.pop());
                }
                st.push(c);
            }

        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // infixtopostfix gfg = new infixtopostfix();
        String exp = "a+b*(c^d-e)^(f+g*h)-i";// abcd^e-fgh*+^*+i-
        infix_postfix(exp);
    }
}
