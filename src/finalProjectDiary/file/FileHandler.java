package homeWork.src.finalProjectDiary.file;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    private final String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }


    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(serializable);
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        return ois.readObject();
    }
}
