import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Model.FileHandler;
import Model.GenTreeService;
import Model.GenealogicalTree.GenealogicalTree;
import Model.GenealogicalTree.Human;
import Model.GenealogicalTree.Pet;
import Model.GenealogicalTree.Sex;
import Presenter.Presenter;
import View.Console;
import View.View;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileHandler<Human> fileHandler = new FileHandler<>();
        GenealogicalTree<Human> bigFamily = new GenealogicalTree<>(fileHandler);
        GenTreeService genTreeService = new GenTreeService(bigFamily);
        genTreeService.addHuman("Федор", Sex.Man, 1947);
        genTreeService.addHuman("Анна", Sex.Woman, 1949);
        genTreeService.getMarried(genTreeService.searchGetHuman("Федор"),
            genTreeService.searchGetHuman("Анна"));

        genTreeService.addHuman("Александр", Sex.Man, 1999, 
            genTreeService.searchGetHuman("Федор"),
            genTreeService.searchGetHuman("Анна"));
        genTreeService.addHuman("Мария", Sex.Man, 2003,
            genTreeService.searchGetHuman("Федор"),
            genTreeService.searchGetHuman("Анна"));

        genTreeService.addHuman("Юрий", Sex.Man, 2022);
        genTreeService.addHuman("Инна", Sex.Woman, 1999);
        genTreeService.getMarried(genTreeService.searchGetHuman("Александр"),
            genTreeService.searchGetHuman("Инна"));

        genTreeService.addHuman("Андрей", Sex.Man, 1997);
        genTreeService.getMarried(genTreeService.searchGetHuman("Мария"),
            genTreeService.searchGetHuman("Андрей"));
        
        genTreeService.searchGetHuman("Александр").addChild(
            genTreeService.searchGetHuman("Юрий"));
        
        Scanner iScanner = new Scanner(System.in, "Cp866");
        View view = new Console<>(iScanner);
        new Presenter<Human>(view, genTreeService, fileHandler);
        view.start();
        iScanner.close();
    }
}