package presenter;

import model.Animal;
import model.Service.FileHandler;
import model.Service.GenTreeService;
import view.View;

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

    public void onClick(int choice) {
        if (choice == 0) {
            view.print(genTreeService.toString());
        } else if (choice == 1) {
            System.out.println("-------");
            String nameSearch = view.searchSetName();
            view.print(genTreeService.search(nameSearch));
            System.out.println("-------");
        } else if (choice == 2) {
            System.out.println("-------");
            genTreeService.sortByName();
            System.out.println("Сортировка по алфавиту");
            view.print(genTreeService.toString());
            System.out.println("-------");
        } else if (choice == 3) {
            System.out.println("-------");
            genTreeService.sortByAge();
            System.out.println("Сортировка по году рождения");
            view.print(genTreeService.toString());
            System.out.println("-------");
        } else if (choice == 4) {
            System.out.println("-------");
            fileHandler.save(genTreeService);
            System.out.println("-------");
        } else {
            System.out.println("-------");
            fileHandler.read();
            System.out.println("-------");
        } 
    }
}
