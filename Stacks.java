import java.util.Scanner;
public class Stacks {

    public static class StackOperations {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ask for stack size
            System.out.print("Enter the size of the stack: ");
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            ClassOfStacks.StringStack stack = new ClassOfStacks.StringStack(size);

            while (true) {
                // Menu
                System.out.println("\nChoose an operation:");
                System.out.println("1 - PUSH (Insert)");
                System.out.println("2 - POP (Delete)");
                System.out.println("3 - DISPLAY");
                System.out.println("4 - EXIT");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter string to push: ");
                        String value = scanner.nextLine();
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
