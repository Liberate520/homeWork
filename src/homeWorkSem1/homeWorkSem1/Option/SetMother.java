package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;

public class SetMother<T extends Human> implements Serializable, Option {

    @Override
    public void execute(FamilyTree<Human> tree, Presenter presenter) {
        String getName = presenter.getInfoFromUser("Enter Name of human: ");
        List<Human> res = tree.getHumanbyName(getName);
        String nameMother = presenter.getInfoFromUser("Enter Mothers's name: ");
        List<Human> res2 = tree.getHumanbyName(nameMother);
        for (Human human : res) {
            for (Human hum : res2) {
                human.setMother(hum);
                hum.setChildren(res);// одновременно матери добавится ребенок
            }
        }
        for (Human element : res) {
            for (Human el : res2) {
                presenter.answerToUser("добавились дети: " + el.getChildren());
                presenter.answerToUser("добавилась мать: " + element.getMother());
            }
        }
    }

    @Override
    public String description() {
        return String.format("Set Mother of Human");
    }
}
