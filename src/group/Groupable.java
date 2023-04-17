package group;

import java.util.List;

import human.Human;

public interface Groupable {
    public void addHuman(Human human);

    public Human getHumanByName(String name);

    public void findHuman();

    List<Human> getHumanList();
}
