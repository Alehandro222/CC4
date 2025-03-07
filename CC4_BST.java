package CC4;
import java.util.*;
public class CC4_BST {
    static class AVLTree {
        static class Node {
            int key, height;
            Node left, right;

            Node(int d) {
                key = d;
                height = 1;
            }
        }

        Node root;

        int height(Node N) {
            return (N == null) ? 0 : N.height;
        }

        int getBalance(Node N) {
            return (N == null) ? 0 : height(N.left) - height(N.right);
        }

        Node rightRotate(Node y) {
            Node x = y.left;
            Node T2 = x.right;
            x.right = y;
            y.left = T2;
            updateHeight(y);
            updateHeight(x);
            return x;
        }

        Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;
            y.left = x;
            x.right = T2;
            updateHeight(x);
            updateHeight(y);
            return y;
        }

        void updateHeight(Node node) {
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }

        Node insert(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);
            else
                return node;

            updateHeight(node);
            return rebalance(node);
        }

        Node deleteNode(Node root, int key) {
            if (root == null) return root;

            if (key < root.key)
                root.left = deleteNode(root.left, key);
            else if (key > root.key)
                root.right = deleteNode(root.right, key);
            else {
                if (root.left == null || root.right == null) {
                    root = (root.left != null) ? root.left : root.right;
                } else {
                    Node temp = minValueNode(root.right);
                    root.key = temp.key;
                    root.right = deleteNode(root.right, temp.key);
                }
            }

            if (root == null) return root;

            updateHeight(root);
            return rebalance(root);
        }

        Node minValueNode(Node node) {
            while (node.left != null)
                node = node.left;
            return node;
        }

        Node rebalance(Node A) {
            int balance = getBalance(A);

            if (balance > 1) {
                if (getBalance(A.left) >= 0) return rightRotate(A);
                else {
                    A.left = leftRotate(A.left);
                    return rightRotate(A);
                }
            }
            if (balance < -1) {
                if (getBalance(A.right) <= 0) return leftRotate(A);
                else {
                    A.right = rightRotate(A.right);
                    return leftRotate(A);
                }
            }

            return A;
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
            System.out.print("int AVL[" + arr.size() + "] = {");
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
            AVLTree tree = new AVLTree();
            char choice;

            do {
                System.out.println("\nAVL Tree Operations:");
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
                        System.out.println("AVL Tree after insertion:");
                        tree.printTreeData();
                        break;
                    case 2:
                        System.out.print("Enter number to delete: ");
                        int deleteVal = scanner.nextInt();
                        tree.root = tree.deleteNode(tree.root, deleteVal);
                        System.out.println("AVL Tree after deletion:");
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