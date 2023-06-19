package Models.Comparators;

import java.util.Comparator;

import Models.Items.NoteItem;

public class ComparatorNoteItemById<T extends NoteItem>  implements Comparator<T> {

    @Override
    public int compare(T item1, T item2) {
        return item1.getId().compareTo(item2.getId());
    }   
}
