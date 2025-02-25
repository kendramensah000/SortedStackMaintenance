import java.util.*;

/**
 * This program reads a list of integer numbers from user input,
 * sorts them in ascending order, and stores them in a Stack.
 * The user must type numbers continuously, pressing enter after each number,
 * and type 'done' to finish input.
 *
 * @author Kendra Mensah
 */
public class SortedStackMaintenance {
    public static void main(String[] args) {
        // Code reuse: Method to handle user input
        List<Integer> numbers = readUserInput();

        // Sort numbers in ascending order
        // Code reuse: Java's built-in Collections.sort() method 
        Collections.sort(numbers);
        System.out.println("Numbers sorted in ascending order.");

        // Use a Stack to store sorted numbers
        // Code reuse to handle Stack operations
        Stack<Integer> stack = fillStack(numbers);

        // Print elements in sorted order (Smallest to Largest)
        printStack(stack);
    }

    /**
     * Reads integer input from the user and stores it in a list.
     * Uses Scanner for input handling and exception handling.
     *
     * Code reuse: Java's scanner for input handling and built-in exception handling 
     * @return List of user-provided integers.
     */
    private static List<Integer> readUserInput() {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter your integers (type 'done' to finish):");

            while (true) {
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("done")) {
                    break; // Exit loop when user types 'done'
                }

                try {
                    // Code reuse: Java's built-in Integer.parseInt() instead of manual conversion
                    int number = Integer.parseInt(input);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer or 'done' to finish.");
                }
            }
        }
        return numbers;
    }

    /**
     * Pushes sorted numbers into a Stack.
     * Code reuse: Java's Stack class instead of custom class 
     * 
     * @param numbers Sorted list of integers.
     * @return Stack<Integer> containing numbers in sorted order.
     */
    private static Stack<Integer> fillStack(List<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int num : numbers) {
            stack.push(num);
        }
        System.out.println("Using Stack to maintain order.");
        return stack;
    }

    /**
     * Prints stack contents in sorted order (Smallest to Largest).
     * This is achieved by using another stack to reverse the order.
     *
     * @param stack Stack containing sorted numbers.
     */
    private static void printStack(Stack<Integer> stack) {
        System.out.println("Printing elements from stack (Smallest to Largest):");

        // Use a temporary stack to print in sorted order
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.pop() + " ");
        }
        System.out.println();
    }
}



