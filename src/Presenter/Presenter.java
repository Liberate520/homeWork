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
    public String showAllPerson(){
        return service.showAllPerson();
    }
    public void sortByName(){
        service.sortByName();
    }
    public void sortByDateOfBirth(){
        service.sortByDateOfBirth();
    }
    public String showPerson(Integer cur){
        return service.showPerson(cur);
    }
    public String сhildrentoSring(Integer cur){
        return service.сhildrentoSring(cur);
    }

    public void addChild(Integer cur, Integer chil, Integer delChil){
        service.addChild(cur, chil, delChil);
    }
}
