package presenter;

import java.io.IOException;

import service.Service;
import ui.View;

public class Presenter<E> {
    private View<E> view;
    private Service<E> service;

    public Presenter(View<E> view, Service<E> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public E taskfind(String st) throws ClassNotFoundException, IOException {
        E humanf = service.find(st);
        return humanf;
    }

    public void sbyname() {
        view.print(service.sortname());
    }

    public void sbyyear() {
        view.print(service.sortbirthyear());
    }

    public void sbychild() {
        view.print(service.sortchild());
    }

    public void sbyid() {
        view.print(service.sortid());
    }

    public void addh(E human, E motherh, E fatherh) {
        view.print(service.addhuman(human, motherh, fatherh));
    }
}
