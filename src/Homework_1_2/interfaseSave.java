package Homework_1_2;

import java.io.InvalidObjectException;

public interface interfaseSave {
//    void serializaSave();

    boolean serializaSave(Designer_Human Human);

    Designer_Human DesSerializa(Designer_Human human1) throws InvalidObjectException;

}

