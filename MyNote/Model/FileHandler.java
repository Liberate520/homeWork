package MyNote.Model;

import MyNote.Notebook;

public interface FileHandler {
    public void save(Notebook records);
    public Notebook load();
}
