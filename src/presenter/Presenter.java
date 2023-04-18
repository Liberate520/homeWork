package presenter;

import model.FamilyTree;
import model.Service;
import view.View;

import java.io.IOException;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String dateOfBirth, String dateOfDeath, String sex, String firstName, String lastName) {
        service.addHuman(dateOfBirth, dateOfDeath, sex, firstName, lastName);
    }

    public void getFamilyTree() {

        String answer = service.getFamilyTree();
        view.print(answer);
    }

    public void findByName(String record) {
        String answer = service.findByName(record);
        view.print(answer);
    }

    public void sortByName(){
        service.sortByName();
    }
    public void sortBySex(){
        service.sortBySex();
    }
    public void save(String path) throws IOException {
        service.save(path);
    }
    public void load(String path) throws IOException, ClassNotFoundException {
        String answer = service.load(path);
        view.print(answer);
    }
}
