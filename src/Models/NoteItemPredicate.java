package Models;

import Models.Items.NoteItem;

public interface NoteItemPredicate {
    boolean isEqual(NoteItem item);
}
