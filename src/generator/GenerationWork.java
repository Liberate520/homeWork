package generator;

import analizator.Analizer;
import analizator.StatWorker;
import classes.Person;
import dataBase.DataBase;

public class GenerationWork implements Analizer {
    private final DataBase mainDb;


    @Override
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
        line.addPosition("Current generation: " + generationCount + ". Population: " + mainDb.size());
        line.push();
        line.addPosition("Families with children: " + db.getFullFamilies().size() + ", general: " + mainDb.getFamiliesNumber());
        line.push();
        line.addPosition("Children: " + nextGeneration.size() + "\n");
        line.push();
        this.stats = line.toString();

        if (generationCount == count) {
            return;
        }
        createGeneration(count, nextGeneration);
    }
}
