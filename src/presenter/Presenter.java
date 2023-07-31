package presenter;

import module.genealogicalTree.GenealogicalTree;
import module.human.Human;
import view.View;
import module.Service.*;

public class Presenter {
    private View view;
    private GenealogicalTree gTree;


    public Presenter(View view) {
        this.view = view;
        GenealogicalTree<Human> gTree;
        gTree = new GenealogicalTree<>();

    }

    public void addHuman(String name, String lastName) {
   //TODO создание нового человека, как определять родственные связи (можно через id)
        Human human = new Human();
        gTree.addHuman(human);
    }

    public void getInfo() {
        view.printAnswer(gTree.getInfo());
    }

    public void sortByAge() {
        gTree.sortByAge();
    }

    public void sortByName() {
        gTree.sortByName();
    }
}
