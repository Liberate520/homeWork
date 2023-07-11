import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.io.File;

import FamilyTree.FamilySerialize;
import FamilyTree.FamilyTree;
import FamilyTree.Person;
import FamilyTree.PersonIdGenerator;
import FamilyTree.Comparators.PersonComparatorByAge;
import FamilyTree.Structs.Gender;

public class Main {
    public static void main(String[] args) {

        ConsoleManager cmdManager = new ConsoleManager();

        Person anna;
        FamilyTree familyBeta;
        FamilyTree familyTest = new FamilyTree("Тестенюк");

        try {
            familyBeta = FamilySerialize.deserialize();
            anna = familyBeta.getPersonById(0);
        } catch (Exception e) {
            var idGenerator = new PersonIdGenerator();
            anna = new Person(idGenerator.GetNewId(), "Анна", Gender.FEMALE, LocalDate.of(1970, 1, 1));
            Person roman = new Person(idGenerator.GetNewId(), "Рома", Gender.MALE, LocalDate.of(1994, 11, 14));
            Person liza = new Person(idGenerator.GetNewId(), "Елизавета", Gender.FEMALE, LocalDate.of(1997, 1, 12));
            Person danil = new Person(idGenerator.GetNewId(), "Даниил", Gender.MALE, LocalDate.of(2017, 3, 13));
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

            familyTest.addPersonAndRelatives(ivan);
            ivan.addSpouse(liza, LocalDate.of(2021, 1, 25));
            ivan.addChild(katia);
        }

        cmdManager.PrintText("Потомки: " + anna + "\n");
        var map = familyTest.getAllChildren(anna);
        for (int key : map.keySet()) {
            cmdManager.PrintText("Поколение " + key + ":");
            var thisPersons = map.get(key);
            Collections.sort(thisPersons, new PersonComparatorByAge());
            Collections.reverse(thisPersons);
            for (var person : thisPersons) {
                cmdManager.PrintText("    " + person);
            }
        }

        try {
            File file = new File(FamilySerialize.FILE_PATH);
            if (!file.exists()) {
                FamilySerialize.serialize(familyBeta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}