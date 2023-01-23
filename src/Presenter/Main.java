package Seminars_OOP.HW_5.src.Presenter;
;
import java.io.Serializable;
import Seminars_OOP.HW_5.src.Model.FamilyTree;
import Seminars_OOP.HW_5.src.View.View;
import Seminars_OOP.HW_5.src.Presenter.Presenter;

public class Main implements Serializable{
    public static void main(String[] args){
        View view = new View();
        FamilyTree familyTree = new FamilyTree();
        Presenter presenter = new Presenter(view, familyTree);
        view.setPresenter(presenter);
        view.view();
    }
}
