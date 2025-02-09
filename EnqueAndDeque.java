public class EnqueAndDeque {
    static class Queue {
        private int front, rear, maxSize;
        private int[] queueArray;

        // Constructor to initialize the queue
        public Queue(int size) {
            maxSize = size;
            queueArray = new int[maxSize];
            front = 0;  // Points to the first element
            rear = -1;  // Points to the last element
        }

        // ENQUEUE operation
        public void enqueue(int value) {
            if (rear == maxSize - 1) {
                System.out.println("Queue Overflow! Cannot enqueue " + value);
            } else {
                queueArray[++rear] = value;
                System.out.println("Enqueued " + value + " into the queue.");
            }
        }

        // DEQUEUE operation
        public int dequeue() {
            if (front > rear) {
                System.out.println("Queue Underflow! No elements to dequeue.");
                return -1;
            } else {
                int dequeuedValue = queueArray[front++];
                System.out.println("Dequeued " + dequeuedValue + " from the queue.");
                return dequeuedValue;
            }
        }

        // Display queue contents
        public void display() {
            if (front > rear) {
                System.out.println("Queue is empty.");
            } else {
                System.out.print("Queue contents: ");
                for (int i = front; i <= rear; i++) {
                    System.out.print(queueArray[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
