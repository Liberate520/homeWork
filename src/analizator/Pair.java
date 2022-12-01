package analizator;

import classes.Person;

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
}
