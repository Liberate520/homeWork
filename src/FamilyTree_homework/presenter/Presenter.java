package FamilyTree_homework.presenter;


import FamilyTree_homework.model.FamilyTreeService;
import FamilyTree_homework.view.View;


public class Presenter{
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        service = new FamilyTreeService();
        this.view = view;
    }
    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }
    public void addHuman(String name, String gender, String birthDate, String deathDate, long idFather, long idMother) {
        String answer = service.addHuman(name, gender, birthDate,deathDate, idFather, idMother);
        view.print(answer);
    }
    public void sortByAge() {
        FamilyTreeService.sortByAge();
    }
    public void sortByName(){
        FamilyTreeService.sortByName();
    }
    public void sortByDeathDate(){
        FamilyTreeService.sortByDeathDate();
    }
    public  void load(){
        service.load();
    }
    public  void save() {
        service.save();
    }
}
