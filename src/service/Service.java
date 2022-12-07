package service;

import presenter.Presenter;
import service.IO.IO;
import service.analizator.Analizer;
import service.analizator.DBAnalizer;
import service.analizator.ExtendedPersonAnalizer;
import service.analizator.PersonAnalizer;
import service.dataBase.DBHandler;
import service.dataBase.DBToSave;
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
                Analizer analizer;
                sentToPrint("Random person generated.");
                sentToPrint("Do you want to analyze children tree? (Y/N)");
                switch (input.next()) {
                    case "Y", "y" -> {
                        analizer = new ExtendedPersonAnalizer(GetRandom.getRandomPerson(db));
                        analizer.analyze();
                        this.sentToPrint(analizer.getStats());
                    }
                    case "N", "n" -> {
                        analizer = new PersonAnalizer(GetRandom.getRandomPerson(db));
                        analizer.analyze();
                        this.sentToPrint(analizer.getStats());
                    }
                    default -> sentToPrint("Wrong input. Return.");
                }
                break;
            case "db analyze":
                DBAnalizer DBStats = new DBAnalizer(db);
                DBStats.analyze();
                sentToPrint(DBStats.getStats());
                break;
            case "save statistics":
                String path = "src/service/dataBase/stats.txt";
                DBStats = new DBAnalizer(db);
                IO saver = new IO();
                DBStats.getDBStats();
                saver.toFile(DBStats.toString(), path);
                break;
            case "save db":
                path = "src/service/dataBase/db.dat";
                saver = new IO();
                DBToSave converter = new DBToSave(db);
                converter.prepare();
                saver.toFile(converter.getDbBytes(), path);
                break;
            // для тестов записи.
            case "test":
                Gena = new GenerationWork(db);
                Gena.generatePopulation(100); // изменить аргумент >200 для StackOverFlowError
                Gena.startGenerator(5);
                path = "src/service/dataBase/db.dat";
                saver = new IO();
                converter = new DBToSave(db);
                converter.prepare();
                saver.toFile(converter.getDbBytes(), path);
                break;
            default:
                break;
        }
    }

    public void sentToPrint(String data) {
        presenter.toPrint(data);
    }
}
