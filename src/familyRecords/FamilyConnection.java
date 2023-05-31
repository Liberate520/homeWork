package familyRecords;

public enum FamilyConnection {
    PARENT,
    CHILD,
    HUSBAND,
    WIFE;

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
}
