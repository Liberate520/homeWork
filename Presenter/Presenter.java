package Presenter;

import Model.GenTreeService;
import Model.GenealogicalTree.Sex;
import View.View;

public class Presenter {
    private View view;
    private GenTreeService genTreeService;
    

    public Presenter(View view, GenTreeService genTreeService) {
        this.view = view;
        this.genTreeService = genTreeService;
        view.setPresenter(this);
    }

    public void printTree() {
        view.print(genTreeService.toString());
    }

    public void addHuman() {
        genTreeService.addHuman(nameAddHuman(), sexAddHuman(), birthYearAddHuman());
        view.print(genTreeService.toString());
    }

    public String nameAddHuman() {
        return view.searchSetName();
    }
    
    public int birthYearAddHuman() {
        return view.birthAddHuman();
    }
    public Sex sexAddHuman() {
        int flag = view.addSetSex();
        if (flag == 1) {
            return Sex.Man;
        } else if (flag == 2) {
            return Sex.Woman;
        }
        return null;
    }

    public void searchHuman() {
        String nameSearch = view.searchSetName();
        view.print(genTreeService.search(nameSearch));
    }

    public void sortByName() {
        genTreeService.sortByName();
        view.print("Сортировка по имени");
        view.print(genTreeService.toString());
    }

    public void sortByAge() {
        genTreeService.sortByAge();
        view.print("Сортировка по возрасту");
        view.print(genTreeService.toString());
    }

    public void serialization() {
        view.print(genTreeService.serialization());
    }

    public void deserialization() {
        view.print(genTreeService.read());
    }
    
}
