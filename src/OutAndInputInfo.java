import java.io.*;

public class OutAndInputInfo {

    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;

    public void WriteInfo(Serializable inputObject){

        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(inputObject.toString()));
            objectOutputStream.writeObject(inputObject);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Human ReadInfo(String name){
        Human inputHupan = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(name));
            inputHupan = (Human) objectInputStream.readObject();
            objectInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return inputHupan;


    }
}
