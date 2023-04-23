package presenter;

import essence.Human;
import service.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service<Human> service;

    public Presenter(View view, Service<Human> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onClick(String text){
        StringBuilder answer = service.getFamily();
        view.print(String.valueOf(answer));
    }
}

