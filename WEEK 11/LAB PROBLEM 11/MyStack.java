import java.util.*;

class MyStack {
    private List<Integer> list = new ArrayList<>();

    public void push(int item) {
        list.add(item);
        System.out.println("Pushed: " + item);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println("Stack: " + list);
    }
}

public class StackUsingList {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        stack.display();
    }
}
