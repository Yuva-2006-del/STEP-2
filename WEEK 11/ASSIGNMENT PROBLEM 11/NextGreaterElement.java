import java.util.*;

public class NextGreaterElement {
    public static void findNextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        System.out.println("Next Greater Elements:");
        for (int val : result) System.out.print(val + " ");
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        System.out.println("Input: " + Arrays.toString(arr));
        findNextGreater(arr);
    }
}
