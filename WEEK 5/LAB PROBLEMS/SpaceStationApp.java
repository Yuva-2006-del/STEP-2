import java.util.*;

public class SpaceStationApp {
    public static void main(String[] args) {
        // Create security clearance
        SecurityClearance clearance = new SecurityClearance(
            "SC-1001",
            "Top Secret",
            new String[]{"Bridge", "Engine Room", "Armory"},
            System.currentTimeMillis() + 1000000000
        );

        // Create initial rank
        CrewRank rank = CrewRank.createOfficer();

        // Recruit a new crew member
        SpaceCrew crew = new SpaceCrew("John Doe", "Earth", rank, clearance);

        System.out.println(crew.getCrewIdentification());
        System.out.println("Can access Bridge? " + crew.canAccessSection("Bridge"));
        System.out.println("Security Rating: " + crew.calculateSecurityRating());

        // Register crew to registry
        SpaceStationRegistry.registerCrew(crew);

        System.out.println("Crew Registry: " + SpaceStationRegistry.getCrewByType("SpaceCrew"));
    }
}

// a. Immutable SecurityClearance class
final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;

    public SecurityClearance(String clearanceId, String level, String[] authorizedSections, long expirationDate) {
        if (clearanceId == null || level == null || authorizedSections == null || expirationDate <= 0) {
            throw new IllegalArgumentException("Invalid security clearance data.");
        }
        this.clearanceId = clearanceId;
        this.level = level;
        this.authorizedSections = Arrays.copyOf(authorizedSections, authorizedSections.length);
        this.expirationDate = expirationDate;
    }

    public final boolean canAccess(String section) {
        for (String s : authorizedSections) {
            if (s.equalsIgnoreCase(section)) return true;
        }
        return false;
    }

    public final boolean isExpired() {
        return System.currentTimeMillis() > expirationDate;
    }

    public final int getAccessHash() {
        return Arrays.hashCode(authorizedSections) + level.hashCode();
    }

    public String getClearanceId() { return clearanceId; }
    public String getLevel() { return level; }
    public String[] getAuthorizedSections() {
        return Arrays.copyOf(authorizedSections, authorizedSections.length);
    }
    public long getExpirationDate() { return expirationDate; }
}

// b. CrewRank class with immutable structure
final class CrewRank {
    private final String rankName;
    private final int level;
    private final String[] permissions;

    private CrewRank(String rankName, int level, String[] permissions) {
        this.rankName = rankName;
        this.level = level;
        this.permissions = Arrays.copyOf(permissions, permissions.length);
    }

    public static CrewRank createCadet() {
        return new CrewRank("Cadet", 1, new String[]{"Basic Access"});
    }

    public static CrewRank createOfficer() {
        return new CrewRank("Officer", 2, new String[]{"Bridge Access", "Reports"});
    }

    public static CrewRank createCommander() {
        return new CrewRank("Commander", 3, new String[]{"Bridge", "Mission Control"});
    }

    public static CrewRank createCaptain() {
        return new CrewRank("Captain", 4, new String[]{"Full Access"});
    }

    public static CrewRank createAdmiral() {
        return new CrewRank("Admiral", 5, new String[]{"Top Secret Access"});
    }

    public String getRankName() { return rankName; }
    public int getLevel() { return level; }
    public String[] getPermissions() {
        return Arrays.copyOf(permissions, permissions.length);
    }
}

// c. SpaceCrew class
class SpaceCrew {
    private final String crewId;
    private final String homePlanet;
    private final SecurityClearance clearance;
    private final CrewRank initialRank;

    private CrewRank currentRank;
    private int missionCount;
    private double spaceHours;

    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;

    // Emergency recruitment
    public SpaceCrew(String name) {
        this(name, "Unknown", CrewRank.createCadet(), new SecurityClearance("EMG-CL", "Low", new String[]{"Quarters"}, System.currentTimeMillis() + 100000));
    }

    // Standard recruitment
    public SpaceCrew(String name, String homePlanet, CrewRank rank) {
        this(name, homePlanet, rank, new SecurityClearance("STD-CL", "Standard", new String[]{"Bridge", "Quarters"}, System.currentTimeMillis() + 100000000));
    }

    // Full constructor
    public SpaceCrew(String name, String homePlanet, CrewRank rank, SecurityClearance clearance) {
        this.crewId = UUID.randomUUID().toString();
        this.homePlanet = homePlanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.clearance = clearance;
        this.missionCount = 0;
        this.spaceHours = 0.0;
    }

    public String getCrewId() { return crewId; }
    public String getHomePlanet() { return homePlanet; }
    public CrewRank getInitialRank() { return initialRank; }
    public CrewRank getCurrentRank() { return currentRank; }
    public void setCurrentRank(CrewRank rank) { this.currentRank = rank; }

    public int getMissionCount() { return missionCount; }
    public void setMissionCount(int count) {
        if (count >= 0) this.missionCount = count;
    }

    public double getSpaceHours() { return spaceHours; }
    public void setSpaceHours(double hours) {
        if (hours >= 0) this.spaceHours = hours;
    }

    // Access control
    public boolean canAccessSection(String section) {
        return clearance.canAccess(section);
    }

    // Security-related methods
    public final String getCrewIdentification() {
        return crewId + " - " + initialRank.getRankName() + " from " + homePlanet;
    }

    public final boolean canBePromoted() {
        return missionCount > 5 && currentRank.getLevel() < 5;
    }

    public final int calculateSecurityRating() {
        return currentRank.getLevel() * 100 + clearance.getAccessHash();
    }

    private final boolean validateClearanceLevel() {
        return !clearance.isExpired();
    }

    @Override
    public String toString() {
        return getCrewIdentification();
    }
}

// e. Specialized crew classes
final class CommandCrew {
    private final Set<String> commandCertifications;

    public CommandCrew(Set<String> certifications) {
        this.commandCertifications = Collections.unmodifiableSet(new HashSet<>(certifications));
    }

    public Set<String> getCertifications() {
        return commandCertifications;
    }
}

final class PilotCrew {
    private final Set<String> flightCertifications;

    public PilotCrew(Set<String> certifications) {
        this.flightCertifications = Collections.unmodifiableSet(new HashSet<>(certifications));
    }

    public Set<String> getCertifications() {
        return flightCertifications;
    }
}

final class ScienceCrew {
    private final String researchSpecialty;

    public ScienceCrew(String researchSpecialty) {
        this.researchSpecialty = researchSpecialty;
    }

    public String getResearchSpecialty() {
        return researchSpecialty;
    }
}

final class EngineerCrew {
    private final String engineeringType;

    public EngineerCrew(String engineeringType) {
        this.engineeringType = engineeringType;
    }

    public String getEngineeringType() {
        return engineeringType;
    }
}

// g. SpaceStationRegistry
final class SpaceStationRegistry {
    private static final Map<String, List<Object>> crewRegistry = new HashMap<>();

    public static boolean registerCrew(Object crew) {
        String type = crew.getClass().getSimpleName();
        crewRegistry.putIfAbsent(type, new ArrayList<>());
        crewRegistry.get(type).add(crew);
        return true;
    }

    public static List<Object> getCrewByType(String type) {
        return crewRegistry.getOrDefault(type, Collections.emptyList());
    }
}
