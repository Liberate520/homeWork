package homeWorkSem1.Option;

import java.io.Serializable;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;
import homeWorkSem1.Service.Gender;

public class Add <T extends Human> implements Serializable, Option {

    int index;
    Gender gend;
    
    @Override
    public void execute(FamilyTree<Human> tree, Presenter presenter) {
        String name = presenter.getInfoFromUser("Введите имя: ");
        int age = presenter.getIntFromUser("Возраст: ");
        Gender gender1 = presenter.getGender("Введите пол Male или Female: ");
        Human human9 = new Human(name, age, gender1,null, null, index++);
        tree.add(human9);
        presenter.answerToUser("New Human is created and added to FamilyTree");
    }

    @Override
    public String description() {
        return String.format("Create New Human and add to FamilyTree");
    }
    
}
