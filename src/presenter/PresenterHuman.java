package presenter;

import model.Services.ServiceHuman;
import ui.View.ViewHuman;

public class PresenterHuman{
    private ServiceHuman serviceHuman;
    private ViewHuman viewHuman;

    public PresenterHuman(ViewHuman viewHuman, ServiceHuman serviceHuman){
        this.serviceHuman = serviceHuman;
        this.viewHuman = viewHuman;
        viewHuman.setPresenter(this);
    }

    public String getInfo(){
        return serviceHuman.getInfo();
    }

    public void save(String path){
        serviceHuman.save(path);
    }

    public void upload(String path){
        serviceHuman.upload(path);
    }

    public void addMember(String gender, String firstName, String lastName){
        serviceHuman.addMember(gender, firstName, lastName);
    }

    public void getMarried(String humanName1, String humanName2){
        serviceHuman.getMarried(humanName1, humanName2);
    }

    public void addChild(String parentName, String gen, String name){
        serviceHuman.addChild(parentName, gen, name);
    }
}
