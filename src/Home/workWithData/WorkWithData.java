package Home.workWithData;

import Home.human.Human;

import java.io.IOException;

public interface WorkWithData {

    void familyTreeSave(Human human) throws IOException;
    Human familyTreeLoad(Human human) throws IOException, ClassNotFoundException;
}
