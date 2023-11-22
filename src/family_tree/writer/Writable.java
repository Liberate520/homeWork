package family_tree.writer;

import family_tree.model.family_tree.Family_tree;
import family_tree.model.family_tree.human.Human;

import java.io.IOException;

public interface Writable {
    void SaveFamily_tree(Object familyTree) throws IOException, ClassNotFoundException;
    Family_tree LoadFamily_tree() throws IOException, ClassNotFoundException;

    void SaveHuman(Human human) throws IOException, ClassNotFoundException;

    Human LoadHuman() throws IOException, ClassNotFoundException;
}
