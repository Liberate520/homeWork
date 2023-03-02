package src.presenter;

import src.*;
import src.ui.ConsoleForms;
import src.ui.View;

import java.io.IOException;


public class Presenter {
    private View view;

    private Services services;

    public Presenter(View view) {
        services = new Services();
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman() {
        services.creteHuman();
    }

    public boolean delHuman(int delId) {
        return services.delUnit(delId);
    }

    public String findHumans(ConsoleForms form) {
        return services.findHumans(form);
    }

    public String showTree(int num) {
        return services.showTree(num);
    }

    public String infoHuman(int num) {
        return services.infoHuman(num);
    }

    public String showHumans() {
        return services.showHumans();
    }

    public boolean saveTree(String path) {
        boolean flag = true;
        try {
            services.save(path);
        } catch (IOException e) {
            flag = false;
        }
        return flag;
    }

    public boolean loadTree(String path) {
        boolean flag = true;
        try {
            services.load(path);
        } catch (ClassNotFoundException | IOException e) {
            flag = false;
        }
        return flag;
    }

    public boolean addChild(int idChild, int idParent) {
        return services.addChild(idChild, idParent);
    }
}
