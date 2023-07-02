import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.io.File;

import FamilyTree.FamilyTree;
import FamilyTree.Person;
import FamilyTree.PersonIdGenerator;
import FamilyTree.Structs.Gender;

public class Main {
    public static void main(String[] args) {
        String folderPath = "src\\Data";
        String fileName = "person.out";
        String filePath = folderPath + "\\" + fileName;

        ConsoleManager cmdManager = new ConsoleManager();

        Person anna;
        FamilyTree familyBeta;
        FamilyTree familyTest;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("person.out"));
            familyBeta = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();

            anna = familyBeta.getPersonById(0);
            familyTest = familyBeta.getPersonById(5).getFamilyTree();
        } catch (Exception e) {
            var idGenerator = new PersonIdGenerator();
            anna = new Person(idGenerator.GetNewId(), "Анна", Gender.FEMALE, LocalDate.of(1970, 1, 1));
            Person roman = new Person(idGenerator.GetNewId(), "Рома", Gender.MALE, LocalDate.of(1994, 11, 14));
            Person liza = new Person(idGenerator.GetNewId(), "Елизавета", Gender.FEMALE, LocalDate.of(1997, 1, 12));
            Person danil = new Person(idGenerator.GetNewId(), "Даниил", Gender.MALE, LocalDate.of(2016, 1, 1));
            Person daria = new Person(idGenerator.GetNewId(), "Даша", Gender.FEMALE, LocalDate.of(2016, 1, 1));

            anna.addChild(roman);
            anna.addChild(liza);
            roman.addChild(danil);
            roman.addChild(daria);

            Person maria = new Person(idGenerator.GetNewId(), "Маша", Gender.FEMALE, LocalDate.of(1971, 4, 1));
            Person ivan = new Person(idGenerator.GetNewId(), "Иван", Gender.MALE, LocalDate.of(1996, 12, 15));
            Person alan = new Person(idGenerator.GetNewId(), "Алан", Gender.MALE, LocalDate.of(2017, 3, 16));

            maria.addChild(ivan);
            ivan.addChild(alan);

            Person katia = new Person(idGenerator.GetNewId(), "Катя", Gender.FEMALE, LocalDate.of(2022, 2, 17));

            familyBeta = new FamilyTree("Бетта");
            familyBeta.addPersonAndRelatives(liza);

            familyTest = new FamilyTree("Тестенюк");
            familyTest.addPersonAndRelatives(ivan);
            ivan.addSpouse(liza, LocalDate.of(2021, 1, 25));
            ivan.addChild(katia);
        }

        cmdManager.PrintText("Потомки: " + anna + "\n");
        var map = familyTest.getAllChildren(anna);
        for (int key : map.keySet()) {
            cmdManager.PrintText("Поколение " + key + ":");
            for (var person : map.get(key)) {
                cmdManager.PrintText("    " + person);
            }
        }

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream(filePath));
                objectOutputStream.writeObject(familyBeta);
                objectOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}