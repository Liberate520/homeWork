package Models.Comparators;

import java.util.Comparator;

import Models.Items.NoteItem;

public class ComparatorNoteItemByDateOfCreation<T extends NoteItem>  implements Comparator<T> {

    @Override
    public int compare(T item1, T item2) {
        return item1.getDateOfCreation().compareTo(item2.getDateOfCreation());
    }   
}
