package homeWork.src.presenter;

import homeWork.src.model.member.FamilyMember;
import homeWork.src.model.service.Service;
import homeWork.src.model.tree.FamilyTree;
import homeWork.src.model.tree.Gender;
import homeWork.src.view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class Presenter {
    private View view;
    private Service service;
    private Scanner scanner = new Scanner(System.in);

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

//    public void changeFamilyMember(long id, String name, String surname, String patronymicName){
//        service.changeFamilyMember(id, name, surname, patronymicName);
//        getFamilyTreeInfo();
//    }

    public Service getService() {
        return service;
    }

    public void addFamilyMember(String name, String surname, String patronymicName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        service.createFamilyMember(name, surname, patronymicName, gender, birthDate, deathDate, -1, -1);
        getFamilyTreeInfo();
    }

    public void addFamilyMember(String name, String surname, String patronymicName, Gender gender, LocalDate birthDate, LocalDate deathDate, int motherID, int fatherID) {
        service.createFamilyMember(name, surname, patronymicName, gender, birthDate, deathDate, motherID, fatherID);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.answer(answer);
    }

    public void sortBySurname() {
        service.sortBySurname();
        getFamilyTreeInfo();
    }

    public void sortByBirthdate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void save() {
        service.save();
    }

    public void loadFamilyTree() {
        service.loadTree();
        getFamilyTreeInfo();
    }

    public String getName(FamilyMember member) {
        return service.getName(member);
    }

    public FamilyMember getFamilyMember(long id) {
        return service.getFamilyMember(id);
    }

    public void addChild(){
        System.out.println("Enter the ID of a member to add a child: ");
        long memberID = Long.parseLong(scanner.nextLine());
        System.out.println("Enter the ID of a child: ");
        long childID = Long.parseLong(scanner.nextLine());
        service.addChild(memberID, childID);
        getFamilyTreeInfo();
    }
}
