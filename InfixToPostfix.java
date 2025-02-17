import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    // Method to determine precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }

    // Method to convert infix expression to postfix
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        System.out.println("Derivation Steps:");

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If character is an operand, add it to result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If character is '(', push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop and output from the stack until '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop '(' from stack
            }
            // If an operator is encountered
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }

            // Print the current status of result and stack
            System.out.printf("%-10s Stack: %s\n", result.toString(), stack);
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            System.out.printf("%-10s Stack: %s\n", result.toString(), stack);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;

        while (repeat) {
            System.out.print("Enter infix expression: ");
            String infixExpression = scanner.nextLine();

            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("Final Postfix Expression: " + postfixExpression);

            System.out.print("Try again? (y/n): ");
            repeat = scanner.nextLine().trim().equalsIgnoreCase("y");
        }

        scanner.close();
    }
}

