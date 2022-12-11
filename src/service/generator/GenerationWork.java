package service.generator;

import service.analizator.StatWorker;
import service.classes.Person;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;

import java.util.Date;

/*
Класс - генератор поколений
 */
public class GenerationWork {
    private final DBHandler mainDb;
    private String stats;
    StatWorker line = new StatWorker();
    private int generationCount = 0;

    /* стартовое поколение */
    public void generatePopulation(int startPopulation) {
        this.mainDb.fill(startPopulation);
    }

    public void startGenerator(int count) {
        createGeneration(count, mainDb);
        line.addPosition("Date of generation: " + mainDb.getCreationDate().toString());
        this.stats = line.toString();
    }

    /* генератор поколений */
    private void createGeneration(int count, DBHandler db) {
        long startTime = System.nanoTime();
        FamilyGenerator familyGeneration = new FamilyGenerator();
        ChildrenGenerator childrenGeneration = new ChildrenGenerator();
        familyGeneration.createFamilies(db);
        childrenGeneration.snusnuForEveryOne(db);

        DataBase nextGeneration = new DataBase();
        for (Person[] parents : db.getFullFamilies()) {
            for (Person child : parents[0].getChildren()) {
                nextGeneration.add(child);
            }
        }
        this.mainDb.includeDB(nextGeneration);
        this.mainDb.includeFamilies(db);
        this.generationCount++;
        line.addPosition("Current generation: " + generationCount
                + ". Population: " + mainDb.getSize() + "\n");
        line.addPosition("Families with children: " + db.getFullFamilies().size()
                + ", general: " + mainDb.getFamiliesNumber() + "\n");
        line.addPosition("Children: " + nextGeneration.getSize() + "\n");
        line.addPosition("Time for generation generation = "
                + (System.nanoTime() - startTime) + "ns" + "\n" + "\n");


        if (generationCount == count) {
            return;
        }
        createGeneration(count, nextGeneration);
        this.mainDb.setCreationDate(new Date());
    }

    public String getStats() {
        return this.stats;
    }

    public GenerationWork(DBHandler db) {
        this.mainDb = db;
    }
}
