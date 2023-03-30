package storage;

import data.Note;
import storage.storageInterface.ReadNote;
import storage.storageInterface.WriteNote;

public class FileNoteStorage extends FileStorage implements ReadNote, WriteNote {

    @Override
    public void writeNote(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeNote'");
    }

    @Override
    public Note readNote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readNote'");
    }

}
