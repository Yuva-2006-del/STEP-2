import java.util.Arrays;
import java.util.UUID;

public class VirtualPetApp {
    public static void main(String[] args) {
        PetSpecies defaultSpecies = new PetSpecies("Cat",
                new String[]{"Kitten", "Teen", "Adult"},
                20,
                "Home");

        VirtualPet pet = new VirtualPet("Whiskers", defaultSpecies);

        pet.feedPet("fish");
        pet.playWithPet("yarn");

        System.out.println(pet);
    }
}

// Immutable class
final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || evolutionStages == null || evolutionStages.length == 0 || maxLifespan <= 0 || habitat == null) {
            throw new IllegalArgumentException("Invalid species parameters");
        }
        this.speciesName = speciesName;
        this.evolutionStages = Arrays.copyOf(evolutionStages, evolutionStages.length);
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public String[] getEvolutionStages() {
        return Arrays.copyOf(evolutionStages, evolutionStages.length);
    }

    public int getMaxLifespan() {
        return maxLifespan;
    }

    public String getHabitat() {
        return habitat;
    }

    @Override
    public String toString() {
        return speciesName + " (" + habitat + ")";
    }
}

// Main Pet Class
class VirtualPet {
    // Immutable core
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    // Mutable state
    private String petName;
    private int age;
    private int happiness;
    private int health;

    // Constants
    public static final String PET_SYSTEM_VERSION = "2.0";
    private static final int MAX_STAT = 100;

    // Constructor chaining
    public VirtualPet() {
        this("Pet_" + System.currentTimeMillis(), new PetSpecies("Default", new String[]{"Baby", "Adult"}, 50, "Wild"));
    }

    public VirtualPet(String name) {
        this(name, new PetSpecies("Default", new String[]{"Baby", "Adult"}, 50, "Wild"));
    }

    public VirtualPet(String name, PetSpecies species) {
        this.petId = UUID.randomUUID().toString();
        this.birthTimestamp = System.currentTimeMillis();
        this.petName = name;
        this.species = species;
        this.age = 0;
        this.happiness = 50;
        this.health = 50;
    }

    // JavaBean-style getters/setters
    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }

    public int getAge() { return age; }
    public void setAge(int age) {
        this.age = Math.max(0, age);
        checkEvolution();
    }

    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) {
        this.happiness = clampStat(happiness);
    }

    public int getHealth() { return health; }
    public void setHealth(int health) {
        this.health = clampStat(health);
    }

    // Pet actions
    public void feedPet(String food) {
        int bonus = food.equalsIgnoreCase("fish") ? 10 : 5;
        modifyHealth(bonus);
        System.out.println(petName + " was fed " + food + " and gained health!");
    }

    public void playWithPet(String toy) {
        int bonus = toy.equalsIgnoreCase("yarn") ? 15 : 5;
        modifyHappiness(bonus);
        System.out.println(petName + " played with " + toy + " and became happier!");
    }

    // Internal logic
    private void modifyHappiness(int delta) {
        this.happiness = clampStat(this.happiness + delta);
    }

    private void modifyHealth(int delta) {
        this.health = clampStat(this.health + delta);
    }

    private int clampStat(int stat) {
        return Math.max(0, Math.min(stat, MAX_STAT));
    }

    private void checkEvolution() {
        if (age >= 10) {
            System.out.println(petName + " has evolved!");
        }
    }

    @Override
    public String toString() {
        return "VirtualPet{" +
                "petId='" + petId + '\'' +
                ", name='" + petName + '\'' +
                ", species=" + species +
                ", age=" + age +
                ", happiness=" + happiness +
                ", health=" + health +
                '}';
    }
}
