package src.Presenter;

import src.FamilyTree.FTService;
import src.FamilyTree.FamilyTree;
import src.FamilyTree.Sex;
import src.UI.View;

public class Presenter {

    private View view;
    private FTService ftService;
    private FamilyTree family;

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
        ftService.save((FamilyTree) family);
    }

    public boolean addPersonToTree(String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        return ftService.addPersonToTree( name, birthDay, deathDay, sex, additionalField);
    }

    public boolean addWifeToHusband(String husbandName, String name, Integer birthDay, Integer deathDay, Sex sex, String additionalField) {
        return ftService.addWifeToHusband(husbandName, name, birthDay, deathDay, sex, additionalField);
    }

    public boolean addChildToMother(String motherName, String name, Integer birthDay, Integer deathDay,
                                    Sex sex, String additionalField) {
        return ftService.addChildToMother(motherName, name, birthDay, deathDay, sex, additionalField);
    }
}