package MyNote;

import java.util.ArrayList;

public interface FileHandler {
    public void save(ArrayList<Record> records);
    public ArrayList<Record> load();
}
