import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Serializable,Writable {
    private List<Buffer> list = new ArrayList<>();

    public List<Buffer> getList() {
        return list;
    }
    public void save(List<Buffer> list) throws Exception {
        ObjectOutputStream objectOutputStream;
        try (FileOutputStream outputStream = new FileOutputStream("D:/GeekBrains/Java/JavaOOP/homeWork/list.txt"))
        {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
        }
    }


    public List<Buffer> load() throws Exception {

        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream("D:/GeekBrains/Java/JavaOOP/homeWork/list.txt")
        ){
            objectInputStream = new ObjectInputStream(fileInputStream);

            list = (List<Buffer>) objectInputStream.readObject();

            for (Buffer b : list) {
                System.out.println(b.getName() + " " + b.getBirthDate() + " " +
                        b.getDeathDate()
                        + " " + b.getGender());
            }
        }
        return getList();
    }
}