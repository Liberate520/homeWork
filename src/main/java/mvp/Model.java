package mvp;

import data.Note;
import storage.FileNoteStorage;
import storage.FileStorage;
import storage.Storage;

public class Model {
    private Storage storage = new FileNoteStorage();

    public Model() {
    }

    public String readData() {
        return storage.read();
    }

    public Note readNote() {
        return storage.readNote();
    }

    public void writeData(String userString) {
        storage.save(userString);
    }
}
