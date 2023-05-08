import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriterFile implements WriterInterface{ 
    private ByteArrayOutputStream writerObject;

    @Override
    public void saverObject(FamilyTree ft) throws IOException, ClassNotFoundException {
        writerObject = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(writerObject);
        objectOutputStream2.writeObject(ft);
        objectOutputStream2.flush();
        System.out.println("Дерево успешно сохранено!");
    }

    
    public void loaderObject(FamilyTree ft) throws IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(writerObject.toByteArray()));
        FamilyTree RestoredFromByte = (FamilyTree) objectInputStream2.readObject();
        objectInputStream2.close();
        System.out.println(RestoredFromByte);
        System.out.println("Дерево успешно загружено!");
    }
}
