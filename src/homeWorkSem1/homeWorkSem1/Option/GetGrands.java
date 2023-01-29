package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;

public class GetGrands<T extends Human> implements Serializable, Option {

    @Override
    public void execute(FamilyTree<Human> tree, Presenter presenter) {

        String findByName = presenter.getInfoFromUser("Enter name of Human, to find Grands: ");
        List<Human> list = new ArrayList<>();
        List<Human> humans = tree.getHumans();
        try {
            for (Human human : humans ) {
                if (findByName.equals(human.getName())) {
                    list.add(human.getFather().getFather());
                    list.add(human.getFather().getMother());
                    list.add(human.getMother().getFather());
                    list.add(human.getMother().getMother());
                    if (human.getFather().getFather() == null) {
                        presenter.answerToUser("дедушки по папиной линии нет");
                    }
                    else if (human.getFather().getMother() == null) {
                        presenter.answerToUser("бабушки по папиной линии нет");
                    }
                    else if (human.getMother().getFather() == null) {
                        presenter.answerToUser("дедушки по маминой линии нет");
                    }
                    else if (human.getMother().getMother() == null) {
                        presenter.answerToUser("бабушки по маминой линии нет");
                    }
                
                }
            }
        }
        catch (Exception e) {
            System.out.println("ошибка");
        }
        presenter.answerToUser("Grands are: "+ list);    
    }

    @Override
    public String description() {
        return String.format("Get Grands of Human");
    }
    
}
