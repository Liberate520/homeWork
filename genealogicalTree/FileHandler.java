package genealogicalTree;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements Writable {
    
    GenealogicalTree savingTree;

    public FileHandler(GenealogicalTree savingTree) {
        this.savingTree = savingTree;
    }
    
    @Override
    public void write() {
        
        
    }

    
}
