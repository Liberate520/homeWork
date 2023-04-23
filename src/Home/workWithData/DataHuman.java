package Home.workWithData;

import Home.human.Human;

import java.io.*;

public class DataHuman implements WorkWithData {
    @Override
    public void familyTreeSave(Human human) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(human.getName().toLowerCase()+".out"));
        objectOutputStream.writeObject(human);
        objectOutputStream.flush();

    }

    @Override
    public Human familyTreeLoad(Human human) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(human.getName().toLowerCase()+".out"));
        return (Human) objectInputStream.readObject();
    }


}
