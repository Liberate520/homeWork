package family_tree.presenter;

import family_tree.model.creatures.enums.Gender;
import family_tree.model.file_handler.interfaces.ReadAndWrite;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath){
        service.addHuman(firstName,lastName,gender,dateOfBirth,dateOfDeath);
    }

    public void addMother(int idChild, int idMother){
        service.addMother(idChild, idMother);
    }

    public void addFather(int idChild, int idFather){
        service.addFather(idChild, idFather);
    }

    public void loadFamilyTreeFromFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        service.loadFamilyTreeFromFile(readAndWrite, path);
    }

    public void saveFamilyTreeInFile(ReadAndWrite readAndWrite, String path) throws IOException, ClassNotFoundException {
        service.saveFamilyTreeInFile(readAndWrite,path);
    }

    public void getFamilyTreeInfo() {
        String treeInfo = service.getFamilyTreeInfo();
        view.printAnswer(treeInfo);
    }

    public void viewAllFamily(int id){
        String allFamilyInfo = service.viewAllFamily(id);
        view.printAnswer(allFamilyInfo);
    }

    public void sortById() {
        service.sortById();
        getFamilyTreeInfo();
    }
    public void sortByDateOfBirth() {
        service.sortByDateOfBirth();
        getFamilyTreeInfo();
    }
    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }
    public LocalDate getDate(String date){
        return service.getDate(date);
    }
    public void listOfGenders(){
        service.listOfGenders();
    }
    public Gender getGender(int idGender){
        return service.getGender(idGender);
    }
}
