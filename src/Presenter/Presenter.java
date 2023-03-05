package src.Presenter;

import src.FamilyTree.FTService;
import src.UI.View;

public class Presenter {
    private View view;
    private FTService ftService;

    public Presenter(View view, FTService ftService) {
        this.view = view;
        this.ftService = ftService;
        view.setPresenter(this);
    }

    public void printingListOfPersons(){
        view.print(ftService.printingListOfPersons());
    }

    public void yearsOfTheReignOfPersons() {
        view.print(ftService.yearsOfTheReignOfPersons());
    }

    public void findSpouse(String name){
        view.print(ftService.findSpouse(name));
    }

    public void getPersonByName(String name){
        view.print(ftService.getPersonByName(name));
    }

    public void load() {
        ftService.load();
    }

    public void save() {
        ftService.save();
    }
}