package familyTree;


import java.io.IOException;

public interface SerializableWriter {
    <T> void writeObject(T object, String filename) throws IOException;
}