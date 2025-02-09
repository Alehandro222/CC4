import java.util.Scanner;
public class AddressCalculations {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Get user input for array type
                System.out.println("Select array type: 1 for 1D, 2 for 2D");
                int arrayType = scanner.nextInt();

                if (arrayType == 1) {
                    compute1DAddress(scanner);
                } else if (arrayType == 2) {
                    compute2DAddress(scanner);
                } else {
                    System.out.println("Invalid selection.");
                }

                scanner.close();
            }

            // Address calculation for 1D array
            private static void compute1DAddress(Scanner scanner) {
                System.out.print("Enter the base address: ");
                int baseAddress = scanner.nextInt();

                System.out.print("Enter the element size (in bytes): ");
                int elementSize = scanner.nextInt();

                System.out.print("Enter the number of elements in the array: ");
                int totalElements = scanner.nextInt();

                System.out.print("Enter the index you want to find the address for: ");
                int index = scanner.nextInt();

                if (index >= totalElements || index < 0) {
                    System.out.println("Invalid index!");
                    return;
                }

                // Formula: Address = Base Address + (Index * Element Size)
                int address = baseAddress + (index * elementSize);

                System.out.println("Total number of elements: " + totalElements);
                System.out.println("Address of element at index " + index + ": " + address);
            }

            // Address calculation for 2D array (Row-Major Order)
            private static void compute2DAddress(Scanner scanner) {
                System.out.print("Enter the base address: ");
                int baseAddress = scanner.nextInt();

                System.out.print("Enter the element size (in bytes): ");
                int elementSize = scanner.nextInt();

                System.out.print("Enter number of rows: ");
                int rows = scanner.nextInt();

                System.out.print("Enter number of columns: ");
                int cols = scanner.nextInt();

                System.out.print("Enter row index of element: ");
                int rowIndex = scanner.nextInt();

                System.out.print("Enter column index of element: ");
                int colIndex = scanner.nextInt();

                if (rowIndex >= rows || colIndex >= cols || rowIndex < 0 || colIndex < 0) {
                    System.out.println("Invalid index!");
                    return;
                }

                // Formula (Row-Major Order): Address = Base Address + [(Row Index * Columns) + Column Index] * Element Size
                int address = baseAddress + ((rowIndex * cols) + colIndex) * elementSize;

                System.out.println("Total number of elements: " + (rows * cols));
                System.out.println("Address of element at (" + rowIndex + ", " + colIndex + "): " + address);
            }
        }



