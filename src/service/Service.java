package service;

import presenter.Presenter;
import service.IO.IO;
import service.analizator.FamilyAnalizer;
import service.analizator.Pair;
import service.analizator.StatWorker;
import service.analizator.TreeAnalizer;
import service.dataBase.DataBase;
import service.generator.GenerationWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private final Presenter presenter;
    private final DataBase db;

    public Service(Presenter presenter, DataBase db) {
        this.presenter = presenter;
        this.db = db;
    }

    public void receive(String command) {
        Scanner input = new Scanner(System.in);
        switch (command) {
            case "exit", "stop":
                sentToPrint("Finishing tasks...");
                System.exit(0);
            case "generate":
                sentToPrint("How many people you want to start with?");
                int startPopulation = input.nextInt();
                sentToPrint("How many generations will be?");
                int generationCount = input.nextInt();
                GenerationWork Gena = new GenerationWork(db);
                Gena.generatePopulation(startPopulation);
                Gena.startGenerator(generationCount);
                sentToPrint(Gena.getStats());
                break;
            case "children analyze":
                TreeAnalizer analizer = new TreeAnalizer(db);
                sentToPrint("Random parent generated.");
                sentToPrint("Do you want to analyze all generations? (Y/N)");
                switch (input.next()) {
                    case "Y", "y" -> {
                        sentToPrint("\n__________________________________Find children_______________________________");
                        String spacer = "";
                        analizer.showChildrenTree(spacer);
                        this.sentToPrint(analizer.getStats());
                    }
                    case "N", "n" -> {
                        analizer.showChildren();
                        this.sentToPrint(analizer.getStats());
                    }
                    default -> sentToPrint("Wrong input. Return.");
                }
                break;
            case "siblings analyze":
                analizer = new TreeAnalizer(db);
                sentToPrint("\n__________________________________Find siblings_______________________________");
                analizer.showSiblings();
                sentToPrint(analizer.getStats());
                break;
            case "parent analyze":
                analizer = new TreeAnalizer(db);
                sentToPrint("\n__________________________________Find parents________________________________");
                analizer.showParents();
                sentToPrint(analizer.getStats());
                break;
            case "family analyze":
                analizer = new TreeAnalizer(db);
                sentToPrint("\n__________________________________All family members__________________________");
                analizer.showFamilyMembers();
                sentToPrint(analizer.getStats());
                break;
            case "children statistics":
                sentToPrint("\n__________________________________Children statistics_________________________");
                FamilyAnalizer familyAnalizer = new FamilyAnalizer(db);
                familyAnalizer.getChildrenStatistics();
                sentToPrint(familyAnalizer.getStats());
                break;
            case "show families":
                sentToPrint("\n__________________________________All families________________________________");
                familyAnalizer = new FamilyAnalizer(db);
                familyAnalizer.sortByDescendants();
                for (Pair family : familyAnalizer) {
                    System.out.println(family.toString());
                }
                break;
            case "people statistics":
                StatWorker stats = new StatWorker(db);
                stats.getDBStats();
                sentToPrint(stats.toString());
                break;
            case "save statistics":
                String path = "src/service.dataBase/stats.txt";
                stats = new StatWorker(db);
                IO saver = new IO();
                stats.getDBStats();
                saver.toFile(stats.toString(), path);
                break;
            case "load statistics":
                path = "src/service.dataBase/stats.txt";
                IO loader = new IO();
                stats = new StatWorker((ArrayList<String>) loader.fromFile(path), db);
                sentToPrint(stats.toString());
                break;
            default:
                break;
        }
    }

    public void sentToPrint(String data) {
        presenter.toPrint(data);
    }
}
