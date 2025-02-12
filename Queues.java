import java.util.Scanner;
public class Queues {
    static class StringQueue {
        private int front, rear, maxSize;
        private String[] queueArray;

        // Constructor to initialize the queue
        public StringQueue(int size) {
            maxSize = size;
            queueArray = new String[maxSize];
            front = 0;  // Points to the first element
            rear = -1;  // Points to the last element
        }

        // ENQUEUE operation (Insertion)
        public void enqueue(String value) {
            if (rear == maxSize - 1) {
                System.out.println("Queue Overflow! Cannot enqueue \"" + value + "\".");
            } else {
                queueArray[++rear] = value;
                System.out.println("Enqueued \"" + value + "\" into the queue.");
                display(); // Show queue after insertion
            }
        }

        // DEQUEUE operation (Deletion)
        public String dequeue() {
            if (front > rear) {
                System.out.println("Queue Underflow! No elements to dequeue.");
                return null;
            } else {
                String dequeuedValue = queueArray[front++];
                System.out.println("Dequeued \"" + dequeuedValue + "\" from the queue.");
                display(); // Show queue after deletion
                return dequeuedValue;
            }
        }

        // Display queue contents
        public void display() {
            if (front > rear) {
                System.out.println("Queue is empty.");
            } else {
                System.out.print("Queue contents (front to rear): ");
                for (int i = front; i <= rear; i++) {
                    System.out.print("\"" + queueArray[i] + "\" ");
                }
                System.out.println();
            }
        }
    }

    public static class StringQueueSimulation {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ask for queue size
            System.out.print("Enter the size of the queue: ");
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            StringQueue queue = new StringQueue(size);

            while (true) {
                // Menu
                System.out.println("\nChoose an operation:");
                System.out.println("1 - ENQUEUE (Insert)");
                System.out.println("2 - DEQUEUE (Delete)");
                System.out.println("3 - DISPLAY");
                System.out.println("4 - EXIT");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter string to enqueue: ");
                        String value = scanner.nextLine();
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
}
