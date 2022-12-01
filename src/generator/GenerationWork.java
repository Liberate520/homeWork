package generator;

import analizator.StatWorker;
import classes.Person;
import dataBase.DataBase;

public class GenerationWork {
    private final DataBase mainDb;

    public String getStats() {
        return this.stats;
    }

    private String stats;

    StatWorker line = new StatWorker();
    private int generationCount = 0;

    public GenerationWork(DataBase db) {
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
    private void createGeneration(int count, DataBase db) {
        Family generation = new Family();
        generation.createFamilies(db);
        generation.snusnuForEveryOne(db);

        DataBase nextGeneration = new DataBase();
        for (Person[] parents : db.getFullFamilies()) {
            for (Person child : parents[0].getChildren()) {
                nextGeneration.add(child);
            }
        }
        this.mainDb.includeDB(nextGeneration);
        this.mainDb.includeFamilies(db);
        this.generationCount++;
        line.addPosition("Current generation: ");
        line.addPosition(generationCount);
        line.addPosition(". Population: ");
        line.addPosition(mainDb.size());
        line.push();
        line.addPosition("Families with children: ");
        line.addPosition(db.getFullFamilies().size());
        line.addPosition(", general: ");
        line.addPosition(mainDb.getFamiliesNumber());
        line.push();
        line.addPosition("Children: ");
        line.addPosition(nextGeneration.size());
        line.addPosition("\n");
        line.push();
        this.stats = line.toString();
        if (generationCount == count) {
            return;
        }
        createGeneration(count, nextGeneration);
    }
}
