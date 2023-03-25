package notebook.core.mvp.models;

import java.io.IOException;
import java.util.Iterator;

import notebook.core.essence.Recording;
import notebook.core.infrastructure.Notebook;
import notebook.core.mvp.models.file.TextFileHandler;

public class Model implements Iterable<Recording> {

    private Notebook NB;
    private int size;
    private String path;

    public Model(String path) {
        NB = new Notebook();
        this.path = path;
    }

    public void append(String title, String text) {
        NB.add(new Recording(title, text));
    }

    public void showAll() {
        int i = 1;
        for (Recording recording : NB) {
            System.out.println("Index: " + i++);
            recording.printRecord();
        }
    }

    public void load() {
        try {
           NB.addAll(new TextFileHandler().read(path));
        } catch (IOException e) {
            e.printStackTrace();
        }    
        size = NB.size();
    }

    public Iterator<Recording> iterator() {
        Iterator<Recording> it = new Iterator<Recording>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < NB.size();
            }

            @Override
            public Recording next() {
                return NB.get(i++);
            }
        };
        return it;
    }

    public Recording get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("The index is invalid!");
            return null;
        }
        return NB.get(index);
    }

    public void remove(int index) {
        NB.remove(index);
    }

    public void set(int index, Recording rec) {
        if (index < 0 || index >= size) {
            System.out.println("The index is invalid!");
            return;
        }
        NB.set(index, rec);
    }

    public void save() throws Exception {  
        try {
            new TextFileHandler().write(path, NB);
        } catch (Exception e) {          
        }
    }
}
