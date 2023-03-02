package src;


public class Stat {
    private static int idCounter = 0;
    private FamilyTree<It> familyTree;

    public Stat(int startId) {
        idCounter = startId;
    }

    public static int getId() {
        idCounter++;
        return idCounter;
    }
}
