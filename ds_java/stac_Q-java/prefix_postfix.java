import java.util.*;

class prefix_postfix {
    static boolean alphanumeric(char c) {
        if (c == '/' || c == '*' || c == '+' || c == '-' || c == '^') {
            return false;
        }
        return true;
    }

    static String funti(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (alphanumeric(c)) {
                st.push(c + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                String temp = op1 + op2 + c;
                st.push(temp);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String exp = "+a-*b^-^cde+f*ghi";
        System.out.println(funti(exp));
    }
}