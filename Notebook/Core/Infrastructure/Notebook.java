package Notebook.Core.Infrastructure;

import java.util.ArrayList;
import java.util.List;

import Notebook.Core.Models.Recording;

public class Notebook {
    private List<Recording> records;

    public Notebook() {
        records = new ArrayList<>();
    }

    // read
    public Recording getRecording(int index) {
        return contains(index) ? records.get(index) : null;
    }

    private boolean contains(int index) {
        return records != null
                && records.size() > index;
    }

    public List<Recording> getRecordings() {

        return records;
    }

    // create
    public boolean add(Recording record) {
        boolean flag = false;
        if (!records.contains(record)) {
            records.add(record);
            flag = true;
        }
        return flag;
    }

    public int count() {
        return records.size();
    }
        // delete
        public boolean remove(Recording record) {
            boolean flag = false;
            if (records.indexOf(record) != -1) {
                records.remove(record);
                flag = true;
            }
            return flag;
        }
}
