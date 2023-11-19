package homeWork.src.presenter;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.service.Service;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service<FamilyMember> service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addFamilyMember(String name, String surname, String patronymicName, Gender gender, LocalDate birthDate) {
        service.createFamilyMember(name, surname, patronymicName, gender, birthDate, null, null, null);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        FamilyTree<FamilyMember> tree = service.getFamilyTree();
        String answer = service.getFamilyTreeInfo(tree);
        view.answer(answer);
    }

    public void sortBySurname() {
        FamilyTree<FamilyMember> tree = service.getFamilyTree();
        service.sortBySurname(tree);
        getFamilyTreeInfo();
    }

    public void sortByBirthdate() {
        FamilyTree<FamilyMember> tree = service.getFamilyTree();
        service.sortByBirthDate(tree);
        getFamilyTreeInfo();
    }

    public void save() {
        FamilyTree<FamilyMember> tree = service.getFamilyTree();
        service.save(tree);
    }

    public void loadFamilyTree() {
        FamilyTree<FamilyMember> tree = service.loadFamilyTree();
        String answer = service.getFamilyTreeInfo(tree);
        view.answer(answer);
    }
}
