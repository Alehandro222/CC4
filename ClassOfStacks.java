public class ClassOfStacks {
    static class StringStack {
        private int top;
        private int maxSize;
        private String[] stackArray;

        // Constructor to initialize the stack
        public StringStack(int size) {
            maxSize = size;
            stackArray = new String[maxSize];
            top = -1; // Stack is initially empty
        }

        // PUSH operation (Insertion)
        public void push(String value) {
            if (top == maxSize - 1) {
                System.out.println("Stack Overflow! Cannot push \"" + value + "\".");
            } else {
                stackArray[++top] = value;
                System.out.println("Pushed \"" + value + "\" onto the stack.");
                display(); // Show stack after insertion
            }
        }

        // POP operation (Deletion)
        public String pop() {
            if (top == -1) {
                System.out.println("Stack Underflow! No elements to pop.");
                return null;
            } else {
                String poppedValue = stackArray[top--];
                System.out.println("Popped \"" + poppedValue + "\" from the stack.");
                display(); // Show stack after deletion
                return poppedValue;
            }
        }

        // Display stack contents
        public void display() {
            if (top == -1) {
                System.out.println("Stack is empty.");
            } else {
                System.out.print("Stack contents (top to bottom): ");
                for (int i = top; i >= 0; i--) {
                    System.out.print("\"" + stackArray[i] + "\" ");
                }
                System.out.println();
            }
        }
    }
}
