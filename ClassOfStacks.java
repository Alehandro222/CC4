public class ClassOfStacks {
    static class Stack {
        private int top;
        private int maxSize;
        private int[] stackArray;

        // Constructor to initialize stack
        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1; // Stack is initially empty
        }

        // PUSH operation
        public void push(int value) {
            if (top == maxSize - 1) {
                System.out.println("Stack Overflow! Cannot push " + value);
            } else {
                stackArray[++top] = value;
                System.out.println("Pushed " + value + " onto the stack.");
            }
        }

        // POP operation
        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow! No elements to pop.");
                return -1;
            } else {
                int poppedValue = stackArray[top--];
                System.out.println("Popped " + poppedValue + " from the stack.");
                return poppedValue;
            }
        }

        // Display stack contents
        public void display() {
            if (top == -1) {
                System.out.println("Stack is empty.");
            } else {
                System.out.print("Stack contents: ");
                for (int i = top; i >= 0; i--) {
                    System.out.print(stackArray[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
