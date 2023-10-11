package presenter;

import model.familyThree.FamilyThree;
import view.View;

public class Presenter {
    private View view;
    private FamilyThree familyThree;
    public Presenter( View view )
    {
        this.view = view;
    }

    public void sortByName() {
    }
}
