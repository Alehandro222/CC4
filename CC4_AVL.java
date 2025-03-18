import java.util.Scanner;

class AVLNode {
    int key;
    AVLNode left, right;
    int height;

    public AVLNode(int key) {
        this.key = key;
        this.left = this.right = null;
        this.height = 1;
    }
}

class AVLTree {
    private AVLNode root;

    // Get the height of the node
    public int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get balance factor of node
    public int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotation
    public AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotation
    public AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a node
    public AVLNode insert(AVLNode node, int key) {
        if (node == null)
            return new AVLNode(key);

        // Perform normal BST insert
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys not allowed

        // Update height of this ancestor node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Get balance factor to check whether this node became unbalanced
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Preorder Traversal
    public void preorder(AVLNode node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder Traversal
    public void inorder(AVLNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    // Postorder Traversal
    public void postorder(AVLNode node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
    }

    // Function to print the 1-D array representation
    public void print1DArray(AVLNode node) {
        int[] result = new int[100];  // A large enough array to store the tree representation
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;  // Initialize with -1 for empty positions
        }
        fill1DArray(node, result, 0);
        System.out.print("| ");
        for (int i = 0; i < result.length; i++) {
            if (result[i] != -1) {
                System.out.print(result[i] + " | ");
            }
        }
        System.out.println();
    }

    private void fill1DArray(AVLNode node, int[] result, int index) {
        if (node == null)
            return;

        if (index < result.length) {
            result[index] = node.key;
            fill1DArray(node.left, result, 2 * index + 1);
            fill1DArray(node.right, result, 2 * index + 2);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public AVLNode getRoot() {
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTree tree = new AVLTree();

        while (true) {
            System.out.print("Enter a series of integers separated by spaces: ");
            String[] numbers = scanner.nextLine().split("\\s+");

            for (String num : numbers) {
                tree.insert(Integer.parseInt(num));
            }

            // Display the 1-D array representation
            System.out.println("\n1-D Array Representation:");
            tree.print1DArray(tree.getRoot());

            // Display the three tree traversals
            System.out.println("\nTree Traversals:");
            System.out.print("Preorder: ");
            tree.preorder(tree.getRoot());
            System.out.println();

            System.out.print("Inorder: ");
            tree.inorder(tree.getRoot());
            System.out.println();

            System.out.print("Postorder: ");
            tree.postorder(tree.getRoot());
            System.out.println();

            // Option to try again
            System.out.print("\nWould you like to try again (yes/no)? ");
            String retry = scanner.nextLine().toLowerCase();
            if (!retry.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
