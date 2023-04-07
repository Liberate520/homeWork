package human;

import java.io.Serializable;
import java.util.Iterator;

public abstract class Animal implements Serializable {

    public String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
