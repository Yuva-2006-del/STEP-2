import java.util.*;

public class UndoFeature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> actions = new Stack<>();

        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                actions.push(word);
            } else if (cmd.equalsIgnoreCase("UNDO")) {
                if (!actions.isEmpty()) {
                    System.out.println("Undo: " + actions.pop());
                } else {
                    System.out.println("Nothing to undo!");
                }
            } else if (cmd.equalsIgnoreCase("PRINT")) {
                System.out.println("Text: " + String.join(" ", actions));
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                break;
            }
        }
    }
}
