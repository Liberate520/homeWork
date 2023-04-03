import java.io.IOException;

public interface Writeable {
    void saveHuman(Human human, String path);
    void load(FamilyTree familyTree, String path) throws Exception;

}
