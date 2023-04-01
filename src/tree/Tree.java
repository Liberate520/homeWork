package tree;
import java.util.List;

import human.Human;

public interface Tree extends Iterable<Human> {
    void addpeople(Human h, Human mh, Human fh);

    Human findHuman(String str, Human nl);

    List<Human> getPeople();
}
