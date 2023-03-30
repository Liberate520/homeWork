import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Slfamailytree implements Outinput {

    @Override
    public void save(FamilyTree ft) throws FileNotFoundException, IOException {
        ObjectOutputStream savetree = new ObjectOutputStream(new FileOutputStream("data.dat"));
        savetree.writeObject(ft);
        savetree.close();
    }

    @Override
    public void load(FamilyTree ft) throws ClassNotFoundException, IOException {
        ObjectInputStream ltree = new ObjectInputStream(new FileInputStream("data.dat"));
        ft = (FamilyTree) ltree.readObject();
        System.out.println(ft.toString());
        ltree.close();
    }
    
}
