import java.util.Stack;

public class prefix_infix {
    static boolean isOperator(char ch) {
        if (ch == '*' || ch == '^' || ch == '+' || ch == '-' || ch == '/') {
            return true;
        } else {
            return false;
        }
    }

    static void preToInfix(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char c = pre_exp.charAt(i);
            if (isOperator(c)) {
                String op1 = st.pop();
                String op2 = st.pop();
                String temp = "(" + op1 + c + op2 + ")";
                st.push(temp);
            } else {
                st.push(c + "");
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        preToInfix("*-A/BC-/AKL");
    }
}