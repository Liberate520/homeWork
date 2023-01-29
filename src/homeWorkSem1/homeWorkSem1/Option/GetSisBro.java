package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;

public class GetSisBro<T extends Human> implements Serializable, Option {

    @Override
    public void execute(FamilyTree<Human> tree, Presenter presenter) {
        String getName = presenter.getInfoFromUser("Enter Name of human: ");
        List<Human> res = tree.getHumanbyName(getName);
        List<Human> sisBro = new ArrayList<>();
        for (Human human : res) {
            sisBro = human.getSisBro();
        }
        presenter.answerToUser("Sister/Brother are: "+ sisBro);
    }

    @Override
    public String description() {
        return String.format("Get Sisters/Brothers of Human");
    }
}
