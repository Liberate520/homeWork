package presenter;

import tree.Service;
import tree.human.Human;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service){
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String gender, String name, Integer age){
        service.addHuman(gender, name, age);
    }

    public void addChild(String human1, String human2){
        service.addChild(human1, human2);
    }

    public void getHumanList(){
        view.print(service.getHumanList());
    }

    public void saveChanges() {
        service.saveChanges();
    }

    public Human getHumanByName(String name){
        return service.getHumanByName(name);
    }
}
