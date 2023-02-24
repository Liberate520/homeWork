package src;

import org.jetbrains.annotations.NotNull;

import java.util.*;

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
