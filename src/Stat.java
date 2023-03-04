package src;

import java.io.Serializable;

public class Stat implements Serializable {
    private static int idCounter = 0;

    public Stat(int startId) {
        idCounter = startId;
    }

    public static int getId() {
        idCounter++;
        return idCounter;
    }
}
