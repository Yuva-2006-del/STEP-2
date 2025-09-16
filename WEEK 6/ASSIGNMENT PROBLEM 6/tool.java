class Tool {
    private String secret = "Private Data";
    protected String usage = "Cutting/Building";
    public String name = "Generic Tool";

    public String getSecret() {
        return secret; // getter for private field
    }
}

class Hammer extends Tool {
    void showAccess() {
        // System.out.println(secret); ❌ private not accessible
        System.out.println("Protected: " + usage); // ✅ accessible
        System.out.println("Public: " + name);     // ✅ accessible
        System.out.println("Private via getter: " + getSecret()); // ✅
    }
}

public class HW2 {
    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
