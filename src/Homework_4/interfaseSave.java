package Homework_4;

import java.io.InvalidObjectException;

public interface interfaseSave {
//    void serializaSave();

    boolean serializaSave(Designer_Human Human);

    Designer_Human DesSerializa(Designer_Human human1) throws InvalidObjectException;

}

