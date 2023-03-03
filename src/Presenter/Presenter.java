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

    public void PrintingListOfPersons(){
        view.print(ftService.PrintingListOfPersons());
    }

    public void YearsOfTheReignOfPersons(){
        view.print(ftService.YearsOfTheReignOfPersons());
    }
    public void load() {
        ftService.load();
    }

    public void save() {
        ftService.save();
    }
}