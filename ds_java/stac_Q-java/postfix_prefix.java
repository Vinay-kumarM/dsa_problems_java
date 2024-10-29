import java.util.*;

public class postfix_prefix {
    static boolean isOperator(char ch) {
        if (ch == '*' || ch == '^' || ch == '+' || ch == '-' || ch == '/') {
            return true;
        } else {
            return false;
        }
    }

    static void funtic(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOperator(c)) {
                String s1 = st.pop();
                String s2 = st.pop();
                String temp = c + s2 + s1;
                st.push(temp);
            } else {
                st.push(c + "");
            }
        }
        System.out.println(st.pop());
    }

    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";// "abcd^e-fgh*+^*i-+";
        funtic(exp);
    }

}
