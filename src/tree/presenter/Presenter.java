package tree.presenter;

import tree.human.Human;
import tree.service.Service;
import tree.ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void print(String text){
        System.out.println(text);
    }

    public void getInfo() {
        String info = service.getInfo();
        view.print(info);

    }
}
