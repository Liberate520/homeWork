package Package.Presenter;

import Package.Model.Tree.Service;
import Package.View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void showTree(){
        service.showTree();
    }
    public void addPerson(){

    }
    public void deletePerson(){

    }
    public void exit(){

    }
}
