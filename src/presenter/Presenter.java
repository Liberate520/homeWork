package presenter;

import service.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addNote(String nextLine) {
        System.out.println("человек добавлен");
    }
}