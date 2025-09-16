import java.util.Objects;

class Game {
    String title;

    Game(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game: " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game g = (Game) obj;
        return Objects.equals(this.title, g.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

class CardGame extends Game {
    int numberOfCards;

    CardGame(String title, int numberOfCards) {
        super(title);
        this.numberOfCards = numberOfCards;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cards: " + numberOfCards;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CardGame)) return false;
        CardGame cg = (CardGame) obj;
        return this.numberOfCards == cg.numberOfCards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfCards);
    }
}

public class HW3 {
    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 52);
        CardGame c2 = new CardGame("Poker", 52);

        System.out.println(c1);
        System.out.println("Equal? " + c1.equals(c2));
    }
}
