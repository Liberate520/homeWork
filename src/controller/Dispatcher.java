package controller;

import analizator.FamilyAnalizer;
import analizator.Pair;
import analizator.StatWorker;
import analizator.TreeAnalizer;
import classes.Parent;
import dataBase.DataBase;
import generator.GenerationWork;

import java.util.Scanner;

public class Dispatcher {
    public void start() {
        Scanner input = new Scanner(System.in);
        DataBase db = new DataBase();
        System.out.println("Type your commands:");
        while (true) {
            switch (input.nextLine()) {
                case "stop", "exit":
                    System.out.println("Finishing tasks...");
                    System.exit(0);
                    break;
                case "generate":
                    System.out.println("How many people you want to start with?");
                    int startPopulation = input.nextInt();
                    System.out.println("How many generations will be?");
                    int generationCount = input.nextInt();
                    GenerationWork Gena = new GenerationWork(db);
                    Gena.generatePopulation(startPopulation);
                    Gena.startGenerator(generationCount);
                    break;
                case "children analyze":
                    TreeAnalizer analizer = new TreeAnalizer();
                    Parent randomPerson = db.getRandomParent();
                    System.out.println("Random parent generated.");
                    System.out.println("Do you want to analyze all generations? (Y/N)");
                    switch (input.next()) {
                        case "Y", "y" -> {
                            System.out.println("\n__________________________________Find children_______________________________");
                            String spacer = "";
                            analizer.showChildrenTree(randomPerson, spacer);
                        }
                        case "N", "n" -> analizer.showChildren(randomPerson);
                        default -> System.out.println("Wrong input. Return.");
                    }
                    break;
                case "siblings analyze":
                    analizer = new TreeAnalizer();
                    System.out.println("\n__________________________________Find siblings_______________________________");
                    Parent randomChild = db.getRandomChild();
                    analizer.showSiblings(randomChild);
                    break;
                case "parent analyze":
                    analizer = new TreeAnalizer();
                    randomChild = db.getRandomChild();
                    System.out.println("\n__________________________________Find parents________________________________");
                    analizer.showParents(randomChild);
                    break;
                case "family analyze":
                    analizer = new TreeAnalizer();
                    System.out.println("\n__________________________________All family members__________________________");
                    Parent[] randomFamily = db.getRandomFamily();
                    analizer.showFamilyMembers(randomFamily);
                    break;
                case "children statistics":
                    System.out.println("\n__________________________________Children statistics_________________________");
                    FamilyAnalizer familyAnalizer = new FamilyAnalizer(db);
                    familyAnalizer.getChildrenStatistics();
                    break;
                case "show families":
                    System.out.println("\n__________________________________All families________________________________");
                    familyAnalizer = new FamilyAnalizer(db);
                    familyAnalizer.sortByDescendants();
                    for (Pair family : familyAnalizer) {
                        System.out.println(family.toString());
                    }
                    break;
                case "people statistics":
                    StatWorker stats = new StatWorker();
                    stats.getStats(db);
                    System.out.printf(stats.toString());
                    break;
                case "save statistics":
                    String path = "src/dataBase/stats.txt";
                    stats = new StatWorker();
                    stats.getStats(db);
                    stats.save(path);
                    break;
                case "load statistics":
                    path = "src/dataBase/stats.txt";
                    stats = new StatWorker();
                    stats.load(path);
                    System.out.printf(stats.toString());
                    break;
                default:
                    break;
            }
        }
    }
}
