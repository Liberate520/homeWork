package FamTree.Presenter;

import FamTree.*;
import FamTree.UI.View;
public class Presenter {
    private View view;
    private FamilyTree<Human>famTHuman;

    public Presenter(View view, FamilyTree<Human> famTHuman, Searching searching) {
        this.view = view;
        this.famTHuman = famTHuman;
        view.setPresenter(this);
    }

    public void familyPrint(){
        String family = famTHuman.toString();
        view.Print(family);
    }

}
