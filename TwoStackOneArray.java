package dsa_linked_list;

import java.util.Scanner;

public class TwoStackOneArray {
    private static final int MAX_SIZE = 10;
    private int[] array = new int[MAX_SIZE];
    private int top1 = -1;
    private int top2 = MAX_SIZE;
    private Scanner scanner = new Scanner(System.in);

    // Push element into Stack 1
    public void pushStack1(int value) {
        if (top1 + 1 == top2) {
            System.out.println("Stack Overflow: Cannot push " + value + " into Stack 1");
        } else {
            array[++top1] = value;
            System.out.println("Pushed " + value + " into Stack 1");
        }
    }

    // Push element into Stack 2
    public void pushStack2(int value) {
        if (top2 - 1 == top1) {
            System.out.println("Stack Overflow: Cannot push " + value + " into Stack 2");
        } else {
            array[--top2] = value;
            System.out.println("Pushed " + value + " into Stack 2");
        }
    }

    // Pop element from Stack 1
    public void popStack1() {
        if (top1 == -1) {
            System.out.println("Stack Underflow: Stack 1 is empty");
        } else {
            int value = array[top1--];
            System.out.println("Popped " + value + " from Stack 1");
        }
    }

    // Pop element from Stack 2
    public void popStack2() {
        if (top2 == MAX_SIZE) {
            System.out.println("Stack Underflow: Stack 2 is empty");
        } else {
            int value = array[top2++];
            System.out.println("Popped " + value + " from Stack 2");
        }
    }

    // Display Stack 1
    public void displayStack1() {
        if (top1 == -1) {
            System.out.println("Stack 1 is empty");
        } else {
            System.out.print("Stack 1 elements: ");
            for (int i = 0; i <= top1; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    // Display Stack 2
    public void displayStack2() {
        if (top2 == MAX_SIZE) {
            System.out.println("Stack 2 is empty");
        } else {
            System.out.print("Stack 2 elements: ");
            for (int i = top2; i < MAX_SIZE; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    // Display Complete Array
    public void displayCompleteArray() {
        System.out.print("Complete Array: ");
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Main method to run the program
    public static void main(String[] args) {
        TwoStackOneArray twoStacks = new TwoStackOneArray();
        Scanner scanner = new Scanner(System.in);
        int choice, value;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Push element into Stack 1");
            System.out.println("2. Push element into Stack 2");
            System.out.println("3. Pop element from Stack 1");
            System.out.println("4. Pop element from Stack 2");
            System.out.println("5. Display Stack 1");
            System.out.println("6. Display Stack 2");
            System.out.println("7. Display Complete Array");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push into Stack 1: ");
                    value = scanner.nextInt();
                    twoStacks.pushStack1(value);
                    break;
                case 2:
                    System.out.print("Enter value to push into Stack 2: ");
                    value = scanner.nextInt();
                    twoStacks.pushStack2(value);
                    break;
                case 3:
                    twoStacks.popStack1();
                    break;
                case 4:
                    twoStacks.popStack2();
                    break;
                case 5:
                    twoStacks.displayStack1();
                    break;
                case 6:
                    twoStacks.displayStack2();
                    break;
                case 7:
                    twoStacks.displayCompleteArray();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
