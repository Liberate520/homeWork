package Tree;

import java.io.*;

public class Serializator {


    public boolean serialization(Family fam){
        Boolean flag = false;
        File file = new File("fm.txt");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            if(fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(fam);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return flag;

    }
    public Family deserialization()  {
        Family family = null;
        try {
            FileInputStream in = new FileInputStream("fm.txt");
            ObjectInputStream obj = new ObjectInputStream(in);
            family = (Family) obj.readObject();
            obj.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return family;
    }


}
