package Presenter;

import Interface.Service;
// import model.FamilyTree;
import ui.View;

public class Presenter {
    private View view;
    private Service service;
    


    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        // view.setPresenter(this);
    }

    public void save() {
        service.save();
    }
    public void load(){
        service.load();
    }
    public String ShowAllPerson(){
        return service.ShowAllPerson();
    }
    public void addFater(Integer cur, Integer fat){
        service.addFater(cur, fat);
    }
}
