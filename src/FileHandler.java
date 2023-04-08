import TreeFamily.Writable;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void save(Object object) throws IOException {
//        try (FileWriter fw = new FileWriter("file.txt", false)) {
//            fw.append(object.toString());
//            fw.flush();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.txt"));
        objectOutputStream.writeObject(object);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

    }

    @Override
    public Object read() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.txt"));
        Object read = objectInputStream.readObject();
        objectInputStream.close();
        return read;

    }

//    public void read(){
//        try {
//                BufferedReader br = new BufferedReader(new FileReader("file.txt"));
//            String str;
//            while ((str = br.readLine()) != null) {
//                System.out.printf("== %s ==\n", str);
//            }
//            br.close();
//        }
//        catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}

