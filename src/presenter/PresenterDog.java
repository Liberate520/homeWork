package presenter;

import model.Services.ServiceDog;
import ui.View.ViewDog;

public class PresenterDog {
    private ServiceDog serviceDog;
    private ViewDog viewDog;

    public PresenterDog(ViewDog viewDog, ServiceDog serviceDog){
        this.serviceDog = serviceDog;
        this.viewDog = viewDog;
        viewDog.setPresenter(this);
    }

    public String getInfo(){
        return serviceDog.getInfo();
    }

    public void save(String path){
        serviceDog.save(path);
    }

    public void upload(String path){
        serviceDog.upload(path);
    }

    public void addMember(String gender, String firstName){
        serviceDog.addMember(gender, firstName);
    }

    public void addChild(String parentName, String gen, String name){
        serviceDog.addChild(parentName, gen, name);
    }
}

