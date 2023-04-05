package tree;

import human.Human;

import java.util.List;

public interface Family extends Iterable<Human> {
    List<Human> getMembers();

}
