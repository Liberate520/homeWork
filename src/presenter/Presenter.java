package presenter;

import java.io.FileNotFoundException;
import java.io.IOException;

import human.Human;
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

    public void taskfind(String st) {
        Human humanf = service.find(st);
        if (humanf == null)
            System.out.printf("Человека с именем %s в этом фамильном дереве нет.\n", st);
        else
            System.out.println(humanf);
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

    public void addh(String str) {
        view.print(service.addhuman(str));
    }

    public void showt() {
        view.print(service.showtr());
    }
    public void savefile() throws FileNotFoundException, IOException {
        service.savetree();
    }
}
