import java.util.Scanner;
public class Queues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for queue size
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        EnqueAndDeque.Queue queue = new EnqueAndDeque.Queue(size);

        while (true) {
            // Menu
            System.out.println("\nChoose an operation:");
            System.out.println("1 - ENQUEUE");
            System.out.println("2 - DEQUEUE");
            System.out.println("3 - DISPLAY");
            System.out.println("4 - EXIT");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
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
