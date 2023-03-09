package model.entity;

public class EntityService {
    private static int incrementalID = 1;

    public static int assignID() {
        return incrementalID++;
    }
}
