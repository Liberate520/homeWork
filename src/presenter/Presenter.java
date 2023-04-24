package src.presenter;

import src.ui.View;
import src.treeApi.*;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onClick1() {
        String answer = service.get();
        view.print(answer);
    }

    public void onClick2(String name) {
        service.add(name);
    }

    public String onClick3(String name) {
        return service.find(name);
    }

    public String onClick4() {
        return service.getInfo();
    }
}
