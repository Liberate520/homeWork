package Serializator;

import Homework_6.Designer_Human;

import java.io.InvalidObjectException;

public interface InterfaseSave {
//

    boolean serializaSave(Designer_Human Human);

    Designer_Human DesSerializa(Designer_Human humans) throws InvalidObjectException;

}

