import java.util.Scanner;
public class Stacks {

    public static class StackOperations {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ask for stack size
            System.out.print("Enter the size of the stack: ");
            int size = scanner.nextInt();

            ClassOfStacks.Stack stack = new ClassOfStacks.Stack(size);

            while (true) {
                // Menu
                System.out.println("\nChoose an operation:");
                System.out.println("1 - PUSH");
                System.out.println("2 - POP");
                System.out.println("3 - DISPLAY");
                System.out.println("4 - EXIT");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        int value = scanner.nextInt();
                        stack.push(value);
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        stack.display();
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        }
    }

}
