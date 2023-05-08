import java.io.IOException;

public interface WriterInterface {
    void saverObject(FamilyTree ft) throws IOException, ClassNotFoundException;
    void loaderObject(FamilyTree ft) throws IOException, ClassNotFoundException;
}
