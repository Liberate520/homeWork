package writer;

import java.io.Serializable;

public interface Writable{

    boolean writeObject(Object o, String fileName);
    Object readObject(String fileName);
    boolean close();

}
