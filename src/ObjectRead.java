import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ObjectRead 
{
    public static void Reader() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("text.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        FamilyTree familyTree1 = (FamilyTree) ois.readObject();
        ois.close();
        System.out.println("вывод 1: " + familyTree1);
    }    
}
