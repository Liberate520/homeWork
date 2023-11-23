package presenter;

import model.FamilyTree;
import model.FileHandler;
import model.Gender;
import model.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        FamilyTree familyTree = new FamilyTree();
        service = new Service(new FileHandler(familyTree));
    }

    public void addHuman(int id, String name, Gender gender, LocalDate birthday) {
        service.addHuman(id, name, gender, birthday);
        getAllHuman();
    }

    public void getAllHuman() {
        String info = service.getAllHuman();
        view.printAnswer(info);
    }

    public void sortByBirthDay() {
        service.sortByBirthDay();
        getAllHuman();
    }

    public void sortByName() {
        service.sortByName();
        getAllHuman();
    }

    public void download() {
        service.download();
        getAllHuman();
    }

    public String  save() {
        service.save();
        return "Данные сохранены";
    }

    public String setParent(int idChild, int idParent) {
        service.setParent(idChild, idParent);
        return "Данные сохранены";
    }
}
