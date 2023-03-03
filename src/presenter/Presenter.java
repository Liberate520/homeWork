package Presenter;

import Model.FileHandler;
import Model.GenTreeService;
import Model.GenealogicalTree.Animal;
import Model.GenealogicalTree.Sex;
import View.View;

public class Presenter<T extends Animal> {
    private View<T> view;
    private GenTreeService genTreeService;
    private FileHandler<T> fileHandler;

    public Presenter(View<T> view, GenTreeService genTreeService, FileHandler<T> fileHandler) {
        this.view = view;
        this.genTreeService = genTreeService;
        this.fileHandler = fileHandler;
        view.setPresenter(this);
    }

    public void printTree() {
        view.print(genTreeService.toString());
    }

    public void addHuman() {
        genTreeService.addHuman(nameAddHuman(), sexAddHuman(), birthYearAddHuman());
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
        fileHandler.save(genTreeService);
    }

    public void deserialization() {
        fileHandler.read();
    }
    
}
