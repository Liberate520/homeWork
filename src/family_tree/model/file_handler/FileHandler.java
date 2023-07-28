package family_tree.model.file_handler;

import family_tree.model.tree.Group;
import family_tree.model.tree.SentientEntity;
import family_tree.model.tree.Tree;

public interface FileHandler<E extends SentientEntity<E>> {
    boolean save(Group<E> family, String familyName);

    Group<E> read(String path);
}
