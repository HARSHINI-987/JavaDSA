package DS;

public class InfixToPrefix {
	// Check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch=='^';
    }

    // Check the precedence of an operator
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1; // Lowest precedence
            case '*':
            case '/':
                return 2; // Higher precedence
            case '^':
            	return 3;
            default:
                return -1; // Invalid operator
        }
    }

    // Convert infix to postfix
    public static String infixToPostfix(String infix) {
        int n = infix.length();
        StackChar stack = new StackChar(n); // Create a stack for operators
        StringBuilder postfix = new StringBuilder(); // To build the postfix expression

        for (int i = 0; i < n; i++) {
            char ch = infix.charAt(i);

            // If the character is an operand, add it to the postfix expression
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            // If the character is an open parenthesis, push it onto the stack
            else if (ch == ')') {
                stack.push(ch);
            }
            // If the character is a close parenthesis
            else if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == ')') {
                    stack.pop(); // Remove the '(' from the stack
                }
            }
            // If the character is an operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch); // Push the current operator onto the stack
            }
        }

        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
    static String reverse(String st) {
    	String rev="";
    	for(int i=0;i<st.length();i++) {
    		rev=st.charAt(i)+rev;
    	}
    	System.out.println(rev);
    	return rev;
    }
    public static void main(String[] args) {
        String infixExpression = "K + L - M*N + (O^P) * W/U/V * T + Q";
        String Expression = reverse(infixExpression);
        Expression = infixToPostfix(Expression);
        Expression = reverse(Expression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + Expression);
    }
}
