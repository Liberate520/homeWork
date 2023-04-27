package Home.workWithData;

import Home.human.Human;

import java.io.*;

public class DataHuman<E extends Human> implements WorkWithData <E>{


    @Override
    public void familyTreeSave(E e) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(e.getName().toLowerCase()+".out"));
        objectOutputStream.writeObject(e);
        objectOutputStream.flush();
    }

    @Override
    public E familyTreeLoad(E e) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(e.getName().toLowerCase()+".out"));
        return (E) objectInputStream.readObject();
    }


}
