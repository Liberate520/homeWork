package Home.presenter;

import Home.model.human.Service;
import Home.ui.workWithData.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String firstName, int age){
        service.addHuman(firstName, age);
    }

    public void getHumanInfo(){
        view.print(service.getInfo());
    }
}
