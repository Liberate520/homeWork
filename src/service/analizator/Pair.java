package service.analizator;

import service.classes.Person;

import java.util.Arrays;
import java.util.Objects;

public class Pair{
    private final Person[] pair;
    private int descendants = 0;

    public int getDescendants() {
        return descendants;
    }

    public Person[] getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "Family has " + this.descendants + " descendants\n" +
                pair[0].toString() +
                pair[1].toString();
    }

    public Pair(Person[] pair) {
        this.pair = pair;
        descendantsCount(pair[0]);
    }

    private void descendantsCount(Person person) {
        int count = person.getChildrenCount();
        if (count == 0) {
            return;
        }
        this.descendants += count;
        for (Person child : person.getChildren()) {
            descendantsCount(child);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair1 = (Pair) o;
        return descendants == pair1.descendants && Arrays.equals(pair, pair1.pair);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(descendants);
        result = 31 * result + Arrays.hashCode(pair);
        return result;
    }
}
