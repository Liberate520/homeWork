package model;

import model.familyTree.FamilyTree;
import model.familyTree.HumanComaratorByFamily;
import model.familyTree.HumanComparatorByName;
import model.human.Human;
import model.save.Writable;
import presenter.Presenter;
import java.util.List;

public class Service <E extends Human> {

    private Writable writable;
    private FamilyTree<E> humanLIST;

    public Service(FamilyTree<E> humanLIST){
        this.humanLIST=humanLIST;
    }



    public void sortByName() {

        humanLIST.getHumanList().sort(new HumanComparatorByName());

    }

    public void sortByFamily() {

        humanLIST.getHumanList().sort(new HumanComaratorByFamily());

    }

    public void  addNewHuman(String name, String family, String dateBirth, String father, Object mother){

        //humanLIST.addNewHuman((E) new Human(name, family, dateBirth, humanLIST.getByName(father), humanLIST.getByName(mother)), null);

        humanLIST.addNewHuman((E) new Human(name, family, dateBirth), null);

    }


    public void printListHuman() {

        System.out.println(humanLIST.getInfo());
    }


    public E searchHuman(String name) {



//            if (name == null || name.trim().isEmpty()) {
//                throw new IllegalArgumentException("Заполните имя!");
//            }

        if (name == null ) {
            throw new IllegalArgumentException("Заполните имя!");
        }


            for (E item : humanLIST.getHumanList()) {
                if (item.getName().equalsIgnoreCase(name.trim())) {
                    return item;
                }
            }
            throw new IllegalArgumentException("Человек  не найден.");
        }




}



