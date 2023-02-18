import java.io.*;

public class FileHandler implements Writable, Serializable {

    /*
     * (non-Javadoc)
     * 
     * @see Writable#save(java.io.Serializable)
     */
    @Override
    public void save(Serializable serializable) throws FileNotFoundException {
        try (FileOutputStream outputStream = new FileOutputStream("FamTree.out")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(serializable);

            try {
                objectOutputStream.writeObject(objectOutputStream);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            objectOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Сохранили");
    }

    @Override
    public Object read() {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("FamTree.out"));
        Person renatRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();

        return null;
    }

    public void test() {
    }

}