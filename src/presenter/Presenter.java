package src.presenter;

import src.*;
import src.comparator.SortBy;
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
        return services.getFamilyTree().delUnit(delId);
    }

    public String findHumans(ConsoleForms form) {
        return services.getFamilyTree().getString(services.getFamilyTree().unPackArgsFindHumans(form.findForm()));
    }

    public String showTree(int num) {
        return services.getFamilyTree().displayTree(services.getFamilyTree().getUnitById(num));
    }

    public String infoHuman(int num) {
        return services.getFamilyTree().getStatistics(services.getFamilyTree().getUnitById(num));
    }

    public String showHumans() {
        services.getFamilyTree().sort(SortBy.DATE_OF_BIRTH);
        return services.getFamilyTree().getString(services.getFamilyTree().getFamily());
    }

    public boolean saveTree(String path) {
        boolean flag = true;
        try {
            services.getFamilyTree().save(path);
        } catch (IOException e) {
            flag = false;
        }
        return flag;
    }

    public boolean loadTree(String path) {
        boolean flag = true;
        try {
            services.getFamilyTree().load(path);
        } catch (ClassNotFoundException | IOException e) {
            flag = false;
        }
        return flag;
    }

    public boolean addChild(int idChild, int idParent) {
        boolean flag = true;
        services.getFamilyTree().getUnitById(idParent).addChild(services.getFamilyTree().getUnitById(idChild));

        return flag;
    }
}
