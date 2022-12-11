package service;

import presenter.Presenter;
import service.IO.FileWork;
import service.IO.IO;
import service.IO.StreamWork;
import service.analizator.Analizer;
import service.analizator.DBAnalizer;
import service.analizator.ExtendedPersonAnalizer;
import service.analizator.PersonAnalizer;
import service.analizator.factory.AnalizerFactory;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;
import service.generator.GenerationWork;
import service.generator.GetRandom;

import java.util.Scanner;

/*
Класс - обработчик команд. Задействует нужные сервисы и возвращает результат их работы.
 */
public class Service {
    private final Presenter presenter;
    private final DBHandler db;


    public Service(Presenter presenter, DataBase db) {
        this.presenter = presenter;
        this.db = db;
    }

    public void receive(String command) {
        Scanner input = new Scanner(System.in);
        Analizer analizer;
        IO ioWork;
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
            case "person analyze":
                sentToPrint("Random person generated.");
                sentToPrint("Do you want to analyze children tree? (Y/N)");
                switch (input.next()) {
                    case "Y", "y" -> {
                        analizer = AnalizerFactory.giveAnalizer("ExPerson");
                        analizer.analyze();
                        this.sentToPrint(analizer.getStats());
                    }
                    case "N", "n" -> {
                        analizer = AnalizerFactory.giveAnalizer("Person");
                        analizer.analyze();
                        this.sentToPrint(analizer.getStats());
                    }
                    default -> sentToPrint("Wrong input. Return.");
                }
                break;
            case "db analyze":
                analizer = AnalizerFactory.giveAnalizer("DB");
                analizer.analyze();
                sentToPrint(analizer.getStats());
                break;
            case "save statistics":
                String path = "src/service/dataBase/stats.txt";
                ioWork = new FileWork();
                analizer = new DBAnalizer(db);
                analizer.analyze();
                String data = analizer.getStats();
                sentToPrint(data);
                sentToPrint(data);
                try {
                    ioWork.toFile(data, path);
                } catch (Exception e) {
                    sentToPrint(e.getMessage());
                }
                break;
            case "load statistics":
                path = "src/service/dataBase/stats.txt";
                analizer = new DBAnalizer(db);
                IO loader = new FileWork();
                analizer.getStats();
                try {
                    sentToPrint(loader.fromFile(path).toString());
                } catch (Exception e) {
                    sentToPrint(e.getMessage());
                }
                break;
            case "save db":
                path = "src/service/dataBase/db.dat";
                ioWork = new StreamWork();
                try {
                    ioWork.toFile(db, path);
                } catch (Exception e) {
                    sentToPrint(e.getMessage());
                }
                break;
            case "load db":
                path = "src/service/dataBase/db.dat";
                ioWork = new StreamWork();
                try {
                    db.cloneDB((DBHandler) ioWork.fromFile(path));
                } catch(Exception e) {
                    sentToPrint(e.getMessage());
                }
                break;
            // для тестов.
            case "test":
                Gena = new GenerationWork(db);
                Gena.generatePopulation(5000);
                Gena.startGenerator(15);
                sentToPrint("TesDB generated 5000/15.");
                break;
            default:
                sentToPrint("Wrong command!");
                break;
        }
    }

    public void sentToPrint(String data) {
        presenter.toPrint(data);
    }
}
