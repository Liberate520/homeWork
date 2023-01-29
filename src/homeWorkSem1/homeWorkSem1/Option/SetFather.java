package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;

public class SetFather<T extends Human> implements Serializable, Option {

    @Override
    public void execute(FamilyTree<Human> tree, Presenter presenter) {
        String getName = presenter.getInfoFromUser("Enter Name of human: ");
        List<Human> res = tree.getHumanbyName(getName);
        String nameFather = presenter.getInfoFromUser("Enter Father's name: ");
        List<Human> res2 = tree.getHumanbyName(nameFather); 
        for (Human human : res) {
            for (Human hum : res2) {
                human.setFather(hum);
                hum.setChildren(res); //одновременно отцу добавится ребенок
            }      
        }
        for (Human element : res) {
            for (Human el : res2) {
                presenter.answerToUser("добавились дети: " + el.getChildren());
                System.out.printf("добавился отец: " + element.getFather());
            }    
        }      
    }

    @Override
    public String description() {
        return String.format("Set Father of Human");
    }
}
