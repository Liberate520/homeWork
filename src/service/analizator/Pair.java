package service.analizator;

import service.classes.Person;
import service.dataBase.DBHandler;

import java.util.Arrays;
import java.util.Objects;

/*
Класс для подсчёта отомков семьи
 */
public class Pair {

    private final Person[] pair;
    private final DBHandler db;
    private int descendants = 0;

    public int getDescendants() {
        return descendants;
    }

    public Person[] getPair() {
        return pair;
    }

    private void descendantsCount(Person person) {
        int count = person.getChildrenCount();
        if (count == 0) {
            return;
        }
        this.descendants += count;
        for (Integer childIndex : person.getChildren()) {
            descendantsCount(db.getPerson(childIndex));
        }
    }

    @Override
    public String toString() {
        return "Family has " + this.descendants + " descendants\n" +
                pair[0].toString() +
                pair[1].toString();
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

    public Pair(Person[] pair, DBHandler db) {
        this.pair = pair;
        this.db = db;
        descendantsCount(pair[0]);
    }
}
