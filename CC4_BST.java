import java.util.*;
public class CC4_BST {

    static class BST {
        static class Node {
            int key;
            Node left, right;

            Node(int d) {
                key = d;
                left = right = null;
            }
        }

        Node root;

        Node insert(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);
            return node;
        }

        Node deleteNode(Node root, int key) {
            if (root == null) return root;

            if (key < root.key)
                root.left = deleteNode(root.left, key);
            else if (key > root.key)
                root.right = deleteNode(root.right, key);
            else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
            return root;
        }

        Node minValueNode(Node node) {
            while (node.left != null)
                node = node.left;
            return node;
        }

        void preorder(Node node) {
            if (node != null) {
                System.out.print(node.key + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }

        void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.key + " ");
                inorder(node.right);
            }
        }

        void postorder(Node node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.key + " ");
            }
        }

        void print1DArray() {
            List<Integer> arr = new ArrayList<>();
            fillArray(root, 0, arr);
            while (!arr.isEmpty() && arr.get(arr.size() - 1) == 0) {
                arr.remove(arr.size() - 1);
            }
            System.out.print("int BST[" + arr.size() + "] = {");
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                if (i < arr.size() - 1) System.out.print(", ");
            }
            System.out.println("};");
        }

        void fillArray(Node node, int index, List<Integer> arr) {
            while (arr.size() <= index) {
                arr.add(0);
            }

            if (node != null) {
                arr.set(index, node.key);
                fillArray(node.left, 2 * index + 1, arr);
                fillArray(node.right, 2 * index + 2, arr);
            }
        }

        void printTreeData() {
            System.out.print("Inorder: ");
            inorder(root);
            System.out.println();

            System.out.print("Preorder: ");
            preorder(root);
            System.out.println();

            System.out.print("Postorder: ");
            postorder(root);
            System.out.println();

            print1DArray();
            System.out.println();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BST tree = new BST();
            char choice;

            do {
                System.out.println("\nBST Operations:");
                System.out.println("1. Insert");
                System.out.println("2. Delete");
                System.out.println("3. Exit");

                System.out.print("\nEnter choice: ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter number to insert: ");
                        int insertVal = scanner.nextInt();
                        tree.root = tree.insert(tree.root, insertVal);
                        System.out.println("BST after insertion:");
                        tree.printTreeData();
                        break;
                    case 2:
                        System.out.print("Enter number to delete: ");
                        int deleteVal = scanner.nextInt();
                        tree.root = tree.deleteNode(tree.root, deleteVal);
                        System.out.println("BST after deletion:");
                        tree.printTreeData();
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }

                System.out.print("\nTry again? (y/n): ");
                choice = scanner.next().charAt(0);

            } while (choice == 'y' || choice == 'Y');

            scanner.close();
        }
    }
}
