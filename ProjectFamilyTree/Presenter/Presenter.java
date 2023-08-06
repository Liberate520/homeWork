package homeWork.ProjectFamilyTree.Presenter;

import homeWork.ProjectFamilyTree.Model.Human;
import homeWork.ProjectFamilyTree.Model.Service;
import homeWork.ProjectFamilyTree.Model.Gender;
import homeWork.ProjectFamilyTree.View.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void addHuman(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender){
        service.addHuman(name, localDateOfBirth, localDateofDeath, gender);
    }
    public void setParentsAndChilds(int childId, int parent1Id, int parent2Id){
        service.setParentsAndChilds(childId, parent1Id, parent2Id);
        getFamilyTreeInfo();
    }
    public void siblings(int human1Id, int human2Id){
        service.siblings(human1Id, human2Id);
        getFamilyTreeInfo();
    }
    public void getFamilyTreeInfo(){
        String answer = service.getFamilyTree();
        view.printAnswer(answer);
    }
    public void sortByName(){
        service.sortByName();
        getFamilyTreeInfo();
    }
    public void sortByAge(){
        service.sortByAge();
        getFamilyTreeInfo();
    }
}
