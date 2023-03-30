package storage;

import data.Note;

public interface Storage {
    void save(String userString);

    String read();

    Note readNote();
}
