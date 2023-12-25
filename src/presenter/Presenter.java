package presenter;

import model.service.Service;
import model.writer.FileHandler;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler());
    }

    public void addHuman(String name, String genderStr, LocalDate birthDate) {
        service.addHuman(name, genderStr, birthDate);
    }

    public void addWedding(int id1, int id2) {
        service.addWedding(id1, id2);
    }

    public void addDivorce(int id1, int id2) {
        service.addDivorce(id1, id2);
    }

    public void getTreeInfo(){
        String answer = service.getTreeInfo();
        view.printAnswer(answer);
    }

    public void addHumanAndParents(String name, String genderStr, LocalDate birthDate, int id1, int id2) {
        service.addHumanAndParents(name, genderStr, birthDate, id1, id2);
    }

    public void saveTree() {
        service.saveTree();
    }

    public void loadSaveTree() {
        service.loadSaveTree();
    }
}
