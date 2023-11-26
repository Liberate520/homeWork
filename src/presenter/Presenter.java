package homeWork.src.presenter;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.service.Service;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addFamilyMember(String name, String surname, String patronymicName, Gender gender, LocalDate birthDate) {
        service.createFamilyMember(name, surname, patronymicName, gender, birthDate, null, -1, -1);
        getFamilyTreeInfo();
    }

    public void addFamilyMember(String name, String surname, String patronymicName, Gender gender, LocalDate birthDate, int motherID, int fatherID) {
        service.createFamilyMember(name, surname, patronymicName, gender, birthDate, null, -1, -1);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
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
        service.save();
    }

    public void loadFamilyTree() {
        service.loadTree();
        getFamilyTreeInfo();
    }
}
