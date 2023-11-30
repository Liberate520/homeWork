package presenter;

import model.group.FamilyTree;
import model.group.TreeItem;
import model.human.Human;
import view.View;
import model.service.Service;
import model.human.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(int human_Id, int parent_Id, String name, LocalDate birthday, Gender gender, String second_parent) {
        service.addHuman(human_Id, parent_Id, name, birthday, gender, second_parent);
        getHumanInfo();
    }

    public void getHumanInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        String info = service.getHumanInfo();
    }


    public void sortByName() {
        service.sortByName();
        String info = service.getHumanInfo();
    }

   public void importTree() {
        service.importTree();
   }

    public void load() {
        service.load();
    }

    public void save() {
        service.save();
    }

    public void addFP(int humanId, int parentId) {
        service.addFP(humanId, parentId);
    }
}
