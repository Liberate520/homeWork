package generator;

import java.io.IOException;

import dataBase.DataBase;
import classes.Human;
import classes.Parent;

public class GenerationWork {
    private DataBase mainDb;
    private int generationCount = 0;

    public GenerationWork(DataBase db) {
        this.mainDb = db;
    }

    public GenerationWork() {
        this(new DataBase());
    }

    /* стартовое наполнение */
    public void generatePopulation(int startPopulation) throws IOException {
        this.mainDb.fill(startPopulation);
    }

    public void startGenerator(int count) throws IOException {
        createGeneration(count, mainDb);
    }

    /* генератор поколений */
    private void createGeneration(int count, DataBase db) throws IOException {
        Family.createFamily(db);
        Family.snusnuForEveryOne(db);

        DataBase nextGeneration = new DataBase();
        for (Human[] human : db.getFullFamilies()) {
            for (Human child : (((Parent) human[0]).getChildren())) {
                nextGeneration.add(child);
            }
        }
        this.mainDb.includeDB(nextGeneration);
        this.mainDb.includeFamilies(db);
        this.generationCount++;
        System.out.println(String.format("Current generation: %d. Population: %d", generationCount, mainDb.size()));
        System.out.println(String.format("Number of families: %d, general: %d", (db.getFullFamilies()).size(), mainDb.getFamiliesNumber()));
        System.out.println(String.format("Children: %d\n", nextGeneration.size()));

        if (generationCount == count) {
            return;
        }
        createGeneration(count, nextGeneration);
    }
////////////////////////////////////////////////////////////
    private void createGenerationTwo(int count, DataBase db) throws IOException {
        Family.createFamily(db);
        Family.snusnuForEveryOne(db);

        DataBase nextGeneration = new DataBase();
        for (Human[] human : db.getFullFamilies()) {
            for (Human child : (((Parent) human[0]).getChildren())) {
                nextGeneration.add(child);
            }
        }
        this.mainDb.includeDB(nextGeneration);
        this.mainDb.includeFamilies(db);
        this.generationCount++;
        System.out.println(String.format("Current generation: %d. Population: %d", generationCount, mainDb.size()));
        System.out.println(String.format("Number of families: %d, general: %d", (db.getFullFamilies()).size(), mainDb.getFamiliesNumber()));
        System.out.println(String.format("Children: %d\n", nextGeneration.size()));

        if (generationCount == count) {
            return;
        }
        createGenerationThree(count, nextGeneration);
    }

    private void createGenerationThree(int count, DataBase db) throws IOException {
        Family.createFamily(db);
        Family.snusnuForEveryOne(db);

        DataBase nextGeneration = new DataBase();
        for (Human[] human : db.getFullFamilies()) {
            for (Human child : (((Parent) human[0]).getChildren())) {
                nextGeneration.add(child);
            }
        }
        this.mainDb.includeDB(nextGeneration);
        this.mainDb.includeFamilies(db);
        this.generationCount++;
        System.out.println(String.format("Current generation: %d. Population: %d", generationCount, mainDb.size()));
        System.out.println(String.format("Number of families: %d, general: %d", (db.getFullFamilies()).size(), mainDb.getFamiliesNumber()));
        System.out.println(String.format("Children: %d\n", nextGeneration.size()));

        if (generationCount == count) {
            return;
        }
        // createGeneration(count, nextGeneration);
    }
}
