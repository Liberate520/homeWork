package src.presenter;

import src.*;
import src.ui.View;

import java.io.IOException;
import java.util.HashMap;


public class Presenter {
    private View view;

    private Service service;

    public Presenter(View view) {
        this.service = new Service();
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(HashMap<String, String> data) {
        service.creteHuman(data);
    }

    public boolean delHuman(int delId) {
        return service.delUnit(delId);
    }

    public String findHumans(HashMap<String, String> form) {
        return service.findHumans(form);
    }

    public String showTree(int num) {
        return service.showTree(num);
    }

    public String infoHuman(int num) {
        return service.infoHuman(num);
    }

    public String showHumans() {
        return service.showHumans();
    }

    public boolean saveTree(String path) {
        boolean flag = true;
        try {
            service.save(path);
        } catch (IOException e) {
            flag = false;
        }
        return flag;
    }

    public boolean loadTree(String path) {
        boolean flag = true;
        try {
            service.load(path);
        } catch (ClassNotFoundException | IOException e) {
            flag = false;
        }
        return flag;
    }

    public boolean addChild(int idChild, int idParent) {
        return service.addChild(idChild, idParent);
    }
}
