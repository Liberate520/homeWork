package model.saving.serialization;

import java.io.Serializable;

public interface Writable {
    void writeObject(Serializable serializable, String fileLink);
    Object readObject(String fileLink);
}
