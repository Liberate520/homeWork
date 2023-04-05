import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad  {

    public static void write(FamilyTree familytree, String fileName) {

        StringBuilder sb = new StringBuilder();
        for (Person person: familytree){
            sb.append(person);
            sb.append("\n"); 
        }

        File file = new File(fileName);
        try{
            FileWriter fr = new FileWriter(file,false);
            fr.write(sb.toString());
            // fr.write("\n");
    
            fr.close();
        }
        catch(IOException e) {
            System.out.println("ERROR");
        }

    }   

    // Нерабочие методы !!!
    
    public static  void save(FamilyTree familytree, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(familytree);
        objectOutputStream.close();
    }
    
    public static FamilyTree load(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        FamilyTree RestoredFamily = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return RestoredFamily;
    }
    
}
