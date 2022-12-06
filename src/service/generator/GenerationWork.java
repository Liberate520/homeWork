package service.generator;

import service.analizator.Analizer;
import service.analizator.StatWorker;
import service.classes.Person;
import service.dataBase.DBHandler;
import service.dataBase.DataBase;

import java.util.Date;

public class GenerationWork implements Analizer {
    private final DBHandler mainDb;


    @Override
    public String getStats() {
        return this.stats;
    }

    private String stats;

    StatWorker line = new StatWorker();
    private int generationCount = 0;

    public GenerationWork(DBHandler db) {
        this.mainDb = db;
    }

    public GenerationWork() {
        this(new DataBase());
    }

    /* стартовое наполнение */
    public void generatePopulation(int startPopulation) {
        this.mainDb.fill(startPopulation);
    }

    public void startGenerator(int count) {
        createGeneration(count, mainDb);
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
        this.generationCount++;
        line.addPosition("Current generation: " + generationCount
                + ". Population: " + mainDb.getSize() + "\n");
        line.addPosition("Families with children: " + db.getFullFamilies().size()
                + ", general: " + mainDb.getFamiliesNumber() + "\n");
        line.addPosition("Children: " + nextGeneration.getSize() + "\n");
        line.addPosition("Time for generation = " + (System.nanoTime() - startTime) + "ms" + "\n" + "\n");
        this.stats = line.toString();

        if (generationCount == count) {
            return;
        }
        createGeneration(count, nextGeneration);
        this.mainDb.setCreationDate(new Date());
//        line.addPosition("Generation Date for this DB - " + mainDb.getCreationDate() + "\n");
//        this.stats += line.toString();
    }
}
