package service.human;

import java.io.Serializable;

public class IdGenerator implements Serializable {
    int id;

    public IdGenerator() {
        this.id = 0;
    }

    public int getId() {
        return id++;
    }

    public int idLast() {
        return this.id;
    }
}
