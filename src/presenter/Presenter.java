package presenter;

import model.familyThree.FamilyThree;
import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;
    public Presenter( View view )
    {
        this.view = view;
        service = new Service();
    }

    public void getFamilyMembers() {
        view.printAnswer( service.getFamilyMembers() );
    }
}
