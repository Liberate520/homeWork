package family_tree.human_family;

import java.util.List;

public interface IFamilyTree<T> {
    void addHuman(T human);

    void removeHuman(T human);

    void updateHuman(T human);

    List<T> getAllHumans();
}