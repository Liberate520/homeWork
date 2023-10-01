import java.io.*;

public class FileWork implements Save{






    @Override
    public boolean write(Serializable serial, String path) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(serial);
            return true;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public Object read(String path) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
           return ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;

        }
    }
}
