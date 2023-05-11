package OOP_Prodject;

import java.util.Iterator;
import java.util.List;

public class PartyIterator<T extends Character> implements Iterator<T> {
    List<T> party;
    private int index;

    public PartyIterator(List<T> party) {
        this.party = party;
    }

    @Override
    public boolean hasNext() {
        return index < party.size();
    }

    @Override
    public T next() {
        return party.get(index++);
    }

}
