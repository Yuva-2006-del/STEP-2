abstract class Character {
    public abstract void attack();
}

class Warrior extends Character {
    public void attack() {
        System.out.println("⚔️ Warrior attacks with sword! High defense.");
    }
}

class Mage extends Character {
    public void attack() {
        System.out.println("🪄 Mage casts a fireball! Uses mana.");
    }
}

class Archer extends Character {
    public void attack() {
        System.out.println("🏹 Archer shoots an arrow! Long-range damage.");
    }
}

public class BattleSystem {
    public static void main(String[] args) {
        Character[] army = { new Warrior(), new Mage(), new Archer() };

        for (Character c : army) {
            c.attack(); // Runtime decides which attack to call
        }
    }
}
