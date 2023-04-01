import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class ObjectWrite {
    
    public static void Writer(FamilyTree familyTree) throws IOException, ClassNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("text.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(familyTree);
        fos.close();
    }
}
