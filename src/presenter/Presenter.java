package presenter;

import model.Service;
import ui.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view, Service service){
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(String gender, String firstName, String lastName){
        service.addHuman(gender, firstName, lastName);
    }

    public void getMarried(String humanName1, String humanName2){
        service.getMarried(humanName1, humanName2);
    }

    public void addChild(String parentName, String gen, String name){
        service.addChild(parentName, gen, name);
    }

    public String getInfo(){
        return service.getInfo();
    }

    public void save(String path){
        service.save(path);
    }

    public void upload(String path){
        service.upload(path);
    }
}
