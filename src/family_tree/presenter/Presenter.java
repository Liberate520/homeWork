package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate localDate) {
        service.addHuman(name, gender, localDate);
        view.printAnswer(service.getText());//sout
    }

    public void wedding(long idHusband, long idWife) {
        service.wedding(idHusband, idWife);
    }

    public void addChildren(long idChildren, long idFather, long idMother) {
        service.addChildren(idChildren, idFather, idMother);
        view.printAnswer(service.getText());
    }

    public void addParents(long idChildren, long idFather, long idMother) {
        service.addParent(idChildren, idFather, idMother);
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void readFile() {
        service.readFile();
    }

    public void saveFile() {
        service.saveFile();
    }
}
