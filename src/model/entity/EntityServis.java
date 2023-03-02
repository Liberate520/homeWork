package model.entity;

public class EntityServis {
    private static int incrementalID = 1;

    public static int assignID() {
        return incrementalID++;
    }
}
