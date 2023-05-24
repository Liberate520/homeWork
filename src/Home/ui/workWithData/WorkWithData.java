package Home.ui.workWithData;

import Home.model.human.Human;

import java.io.IOException;

public interface WorkWithData<E extends Human> {

    void familyTreeSave(E e) throws IOException;
    E familyTreeLoad(E e) throws IOException, ClassNotFoundException;

}
