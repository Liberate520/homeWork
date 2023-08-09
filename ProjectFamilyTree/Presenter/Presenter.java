package homeWork.ProjectFamilyTree.Presenter;

import homeWork.ProjectFamilyTree.Model.*;
import homeWork.ProjectFamilyTree.Model.Services.*;
import homeWork.ProjectFamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    private Family_ties familyTies;
    private PrintFamilyTree printFamilyTree;
    private Sorting sorting;
    public SaveObject saveObject;
    public LoadObject loadObject;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        familyTies = new Family_ties();
        printFamilyTree = new PrintFamilyTree();
        sorting = new Sorting();
        saveObject = new SaveObject();
        loadObject = new LoadObject();
    }
    public void addHuman(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender){
        service.addHuman(name, localDateOfBirth, localDateofDeath, gender);
    }
    public void setParentsAndChilds(int childId, int parent1Id, int parent2Id){
        familyTies.setParentsAndChilds(childId, parent1Id, parent2Id);
        getFamilyTreeInfo();
    }
    public void siblings(int human1Id, int human2Id){
        familyTies.siblings(human1Id, human2Id);
        getFamilyTreeInfo();
    }
    public void getFamilyTreeInfo(){
        String answer = printFamilyTree.getFamilyTree();
        view.printAnswer(answer);
    }
    public void sortByName(){
        sorting.sortByName();
        getFamilyTreeInfo();
    }
    public void sortByAge(){
        sorting.sortByAge();
        getFamilyTreeInfo();
    }
    public void Save() throws IOException {
        SaveObject.Save();
    }
    public void Load() throws IOException, ClassNotFoundException {
        LoadObject.Load();
        getFamilyTreeInfo();
    }
}
