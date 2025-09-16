class Tool {
    private String secret = "Private Data";
    protected String usage = "Cutting/Building";
    public String name = "Generic Tool";

    public String getSecret() {
        return secret; 
    }
}

class Hammer extends Tool {
    void showAccess() {

        System.out.println("Protected: " + usage); 
        System.out.println("Public: " + name);   
        System.out.println("Private via getter: " + getSecret()); 
    }
}

public class HW2 {
    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
