package OOP_DZ.DZ5.notebook.storage;

import OOP_DZ.DZ5.notebook.records.RecordsList;


public interface Storage {
    RecordsList read();
    void write();
}
