import java.io.IOException;

public interface Writable {
    void output() throws IOException;
    FamilyTree input() throws IOException, ClassNotFoundException;
}