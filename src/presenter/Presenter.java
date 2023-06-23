package presenter;

import familytree.TreeService;
import human.Human;
import ui.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter implements Serializable {
    private final View view;
    private final TreeService treeService;

    public Presenter(View view, TreeService treeService){
        this.view = view;
        this.treeService = treeService;
        view.setPresenter(this);
    }

    public void getInfo() {
        view.print(treeService.getInfoHuman());
    }

    public void add(String name, String gender, Human father, Human mother, LocalDate dateOfBirth, LocalDate deathDate){
        treeService.add(name,gender,father,mother,dateOfBirth,deathDate);
    }

    public void saveFile() {
        treeService.save();
    }

    public void loadFile() {
        this.treeService.load();
    }
}
