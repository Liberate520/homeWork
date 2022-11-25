package analizator;

import classes.Parent;

public class Pair{
    private final Parent[] pair;
    private int descendants = 0;

    public int getDescendants() {
        return descendants;
    }

    public Parent[] getPair() {
        return pair;
    }

    @Override
    public String toString() {
        return "Family has " + this.descendants + " descendants\n" +
                pair[0].toString() +
                pair[1].toString();
    }

    public Pair(Parent[] pair) {
        this.pair = pair;
        descendantsCount(pair[0]);
    }

    private void descendantsCount(Parent person) {
        int count = person.getChildrenCount();
        if (count == 0) {
            return;
        }
        this.descendants += count;
        for (Parent child : person.getChildren()) {
            descendantsCount(child);
        }
    }
}
