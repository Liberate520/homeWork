import human.Human;
import tree.FamilyTree;

public interface Writeable {
    void saveHuman(Human human, java.lang.String s);

    FamilyTree load(FamilyTree familyTree, java.lang.String s) throws java.lang.Exception;
}
