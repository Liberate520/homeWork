package service;

import presenter.Presenter;
import service.IO.IO;
import service.analizator.DBAnalizer;
import service.analizator.FamilyAnalizer;
import service.analizator.TreeAnalizer;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;
import service.generator.GenerationWork;

import java.util.Scanner;

public class Service {
    private final Presenter presenter;
    private final DBHandler db;

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
                sentToPrint("Date of generation: " + db.getCreationDate().toString());
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
//            case "show families":
//                sentToPrint("\n__________________________________All families________________________________");
//                familyAnalizer = new FamilyAnalizer(db);
//                familyAnalizer.sortByDescendants();
//                for (Pair family : familyAnalizer) {
//                    System.out.println(family.toString());
//                }
//                break;
            case "people statistics":
                DBAnalizer DBStats = new DBAnalizer(db);
                DBStats.getDBStats();
                sentToPrint(DBStats.getStats());
                break;
            case "save statistics":
                String path = "src/service/dataBase/stats.txt";
                DBStats = new DBAnalizer(db);
                IO saver = new IO();
                DBStats.getDBStats();
                saver.toFile(DBStats.toString(), path);
                break;
            case "load statistics":
//                path = "src/service/dataBase/stats.txt";
//                IO loader = new IO();

                break;
            default:
                break;
        }
    }

    public void sentToPrint(String data) {
        presenter.toPrint(data);
    }
}
