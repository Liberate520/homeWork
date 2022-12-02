package controller;

import IO.IO;
import analizator.*;
import dataBase.DataBase;
import generator.GenerationWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Dispatcher {
    public void start() {
//        System.out.print("\033[H\033[J");
        Scanner input = new Scanner(System.in);
        DataBase db = new DataBase();
        GenerationWork Gena;
        TreeAnalizer analizer;
        FamilyAnalizer familyAnalizer;
        System.out.println("Type your commands:");
        while (true) {
//            System.out.print("\033[H\033[J");
            switch (input.nextLine()) {
                case "stop", "exit":
                    System.out.println("Finishing tasks...");
                    System.exit(0);
                    break;
                case "generate":
//                    System.out.print("\033[H\033[J");
                    System.out.println("How many people you want to start with?");
                    int startPopulation = input.nextInt();
                    System.out.println("How many generations will be?");
                    int generationCount = input.nextInt();
                    Gena = new GenerationWork(db);
                    Gena.generatePopulation(startPopulation);
                    Gena.startGenerator(generationCount);
                    System.out.println(Gena.sendStats());
                    break;
                case "children analyze":
//                    System.out.print("\033[H\033[J");
                    analizer = new TreeAnalizer(db);
                    System.out.println("Random parent generated.");
                    System.out.println("Do you want to analyze all generations? (Y/N)");
                    switch (input.next()) {
                        case "Y", "y" -> {
                            System.out.println("\n__________________________________Find children_______________________________");
                            String spacer = "";
                            analizer.showChildrenTree(spacer);
                        }
                        case "N", "n" -> analizer.showChildren();
                        default -> System.out.println("Wrong input. Return.");
                    }
                    break;
                case "siblings analyze":
                    analizer = new TreeAnalizer(db);
                    System.out.println("\n__________________________________Find siblings_______________________________");
                    analizer.showSiblings();
                    break;
                case "parent analyze":
                    analizer = new TreeAnalizer(db);
                    System.out.println("\n__________________________________Find parents________________________________");
                    analizer.showParents();
                    break;
                case "family analyze":
                    analizer = new TreeAnalizer(db);
                    System.out.println("\n__________________________________All family members__________________________");
                    analizer.showFamilyMembers();
                    break;
                case "children statistics":
                    System.out.println("\n__________________________________Children statistics_________________________");
                    familyAnalizer = new FamilyAnalizer(db);
                    familyAnalizer.getChildrenStatistics();
                    System.out.println(familyAnalizer.sendStats());
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
                    StatWorker stats = new StatWorker(db);
                    stats.getDBStats();
                    System.out.printf(stats.toString());
                    break;
                case "save statistics":
                    String path = "src/dataBase/stats.txt";
                    stats = new StatWorker(db);
                    IO saver = new IO();
                    saver.toFile(stats.toString(), path);
                    break;
                case "load statistics":
                    path = "src/dataBase/stats.txt";
                    IO loader = new IO();
                    stats = new StatWorker((ArrayList<String>) loader.fromFile(path), db);
                    System.out.printf(stats.toString());
                    break;
                default:
                    break;
            }
        }
    }
}
