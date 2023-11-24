import java.io.Serializable;

public interface Serialize {
    public void writeToFile(Serializable toWrite);
    public Serializable readFromFile();
}