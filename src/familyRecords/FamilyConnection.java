package familyRecords;

public enum FamilyConnection {
    PARENT("parent"),
    CHILD("child"),
    HUSBAND("husband"),
    WIFE("wife");

    private final String  name;
    FamilyConnection(String name) {this.name=name;}
    // borrowed from https://stackoverflow.com/questions/18883646/java-enum-methods-return-opposite-direction-enum/27023575#27023575

    /**
     * @return Opposite connection
     */
    public FamilyConnection opposite() {
        switch (this) {
            case WIFE: return HUSBAND;
            case HUSBAND: return WIFE;
            case PARENT: return CHILD;
            case CHILD: return PARENT;
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    public static FamilyConnection fromString(String name) {
        for (FamilyConnection connection:FamilyConnection.values()) {
            if (name.equals(connection.name)) return connection;
        }
        return null;
    }
}
