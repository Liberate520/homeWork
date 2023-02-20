import java.io.*;

public class FileHandler implements Writable {
    
    @Override
    public void save(Serializable serializable) throws FileNotFoundException {
        try (FileOutputStream outputStream = new FileOutputStream("FamTree.data")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializable);

            try {
                objectOutputStream.writeObject(serializable);
            } catch (IOException e) {
                e.printStackTrace();
            }
            objectOutputStream.close();            
        } catch (IOException e) {            
            e.printStackTrace();
        }
        System.out.println("Сохранили");
    }

    @Override
    public Object read() throws FileNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("FamTree.data"));
                try {
                    Writable renatRestored = (Writable) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        objectInputStream.close();

        return null;
    }

    
    public void test() {
    }
}