package Serializator;

import Homework_7.Designer_Human;

import java.io.InvalidObjectException;

public class WorkingFile implements InterfaseSave {


    @Override
    public boolean serializaSave(Designer_Human Human) { //для записи
        Serializator serializator = new Serializator();
        System.out.println(serializator.serializaSave(Human));
        return false;
    }

    @Override
    public Designer_Human DesSerializa(Designer_Human humans) throws InvalidObjectException { //для чтения
        Serializator serializator = new Serializator();
        try {
            Designer_Human human11 = serializator.DesSerializa(humans);
            System.out.println(human11.getName());
        } catch (InvalidObjectException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
