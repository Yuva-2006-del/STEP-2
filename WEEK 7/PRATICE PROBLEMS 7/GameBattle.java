public class GameBattle {

  
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
          
            attack(damage, weapon);
        }
    }


    public void attack(int damage, String[] teammates) {
        int totalDamage = damage * teammates.length;
        String names = String.join(", ", teammates);
        System.out.println("Team attack with " + names + " for " + totalDamage + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle game = new GameBattle();

        
        game.attack(50); 
        game.attack(75, "Sword"); 
        game.attack(60, "Bow", true); 
        game.attack(40, new String[]{"Alice", "Bob"}); 
    }
}
