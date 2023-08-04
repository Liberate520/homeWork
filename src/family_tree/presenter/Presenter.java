package family_tree.presenter;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.model.writer.FileHandler;
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
    }

    public void wedding(long idHusband, long idWife) {
        service.wedding(idHusband, idWife);
    }

    public void addChildren(long idChildren, long idFather, long idMother) {
        service.addChildren(idChildren, idFather, idMother);
    }

    public void addParents(long idChildren, long idFather, long idMother) {
        service.addParent(idChildren, idFather, idMother);
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void readFile() {
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read("src/family_tree/model/data/tree.out");
        service.setTree(tree);
    }

    public void saveFile() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(service.getTree(), "src/family_tree/model/data/tree.out");
    }
}
