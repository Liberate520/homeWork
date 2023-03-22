package model;

public class Model {
    FileOperations fileOperations;
    Notebook notebook;

    public Model(String path) {
        this.notebook = new Notebook();
        fileOperations = new FileOperations(path, this.notebook);
    }

    public void addRec(String text, String deadline) {
        notebook.addRec(text, deadline);
    }

    public void delRec(Integer index) {
        notebook.delRec(index);
    }

    public String toString() {
        return notebook.toString();
    }

    public void load() {
        fileOperations.load();
    }

    public void save() {
        fileOperations.save();
    }
}
