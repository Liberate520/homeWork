package src.presenter;

import src.FamilyTree;
import src.Human;
import src.It;
import src.ui.View;

public class Presenter {
    //каким образом закинем модель в презентер?
    private View view;
    private FamilyTree<Human> familyTree;
    public Presenter(View view, FamilyTree familyTree){
        this.view = view;
        this.familyTree = familyTree;
        view.setPresenter(this);
    }

    public void addHuman(){
        Human h = new Human();
        h.createUnit();
        familyTree.addToFamily(h);
    }
    public void delHuman(){
        System.out.println("Заглушка");
    }
    public void findHumans(){
        System.out.println("Заглушка");
    }
    public void showTree(){
        System.out.println("Заглушка");
    }
    public void showHuman(){
        System.out.println("Заглушка");
    }


}
