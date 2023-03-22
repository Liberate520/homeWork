package Notebook.Core.MVP.Models;
import java.util.Iterator;
import java.util.List;
import Notebook.Core.Infrastructure.Notebook;
import Notebook.Core.Models.Recording;
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
        List<Recording> recordings = FileReader.read(path);
        for (Recording recording : recordings) {
            NB.add(recording);
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

    public void set(int index, Recording rec){
        if (index < 0 || index >= size) {
            System.out.println("The index is invalid!");
            return;
        }
        NB.set(index, rec);
    }

    public void save() throws Exception {
        FileWriterr.writeToFile(path, NB);
    } 
}
