package family;

import human.Human;

import java.util.List;

public interface Family {
    void add(int id, Human human);

    String showTree(Integer id);

    List<Human> getHumanList();
}
