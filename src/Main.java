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
        genTreeService.addIndividual("Федор", Sex.Man, 1947);
        genTreeService.addIndividual("Анна", Sex.Woman, 1949);
        genTreeService.addIndividual("Александр", Sex.Man, 1999);
        genTreeService.addIndividual("Мария", Sex.Man, 2003);
        genTreeService.addIndividual("Юрий", Sex.Man, 2022);
        genTreeService.addIndividual("Инна", Sex.Woman, 1999);
        
        genTreeService.searchGetHuman("Федор").addChild(
            genTreeService.searchGetHuman("Александр"));
        genTreeService.searchGetHuman("Федор").addChild(
            genTreeService.searchGetHuman("Мария"));
        genTreeService.searchGetHuman("Александр").addChild(
            genTreeService.searchGetHuman("Юрий"));
        
        FileHandler<Pet> petsFileHandler = new FileHandler<>();
        GenealogicalTree<Pet> pets = new GenealogicalTree<>(petsFileHandler);
        pets.addIndividual(new Pet(0, "Кошка", Sex.Woman, 2016));
        pets.addIndividual(new Pet(1, "Собака", Sex.Man, 2019));
        System.out.println("Питомцы:");
        pets.printGenTree();
        System.out.println("-------");
        
        Scanner iScanner = new Scanner(System.in, "Cp866");
        View view = new Console<>(iScanner);
        new Presenter<Human>(view, genTreeService, fileHandler);

        // View view = new Console();
        // new Presenter(view);
        // view.start();
        view.start();
    }
}