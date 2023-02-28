import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.GenealogicalTree;
import model.Human;
import model.Pet;
import model.Sex;
import model.Service.FileHandler;
import model.Service.GenTreeService;
import presenter.Presenter;
import view.Console;
import view.View;

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
        View<Human> view = new Console<>(iScanner);
        Presenter<Human> presenter = new Presenter<>(view, genTreeService, fileHandler);

        view.start();
    }
}