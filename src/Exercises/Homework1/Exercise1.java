package Exercises.Homework1;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import Exercises.Exercise;

public class Exercise1 extends Exercise {
    public Exercise1(String description) {
        super(description);
    }

    @Override
    public boolean Solution() {
        Person anna = new Person("Анна", LocalDate.of(1970, 1, 1));
        Person roman = new Person("Рома", LocalDate.of(1994, 11, 14));
        Person liza = new Person("Елизавета", LocalDate.of(1997, 1, 12));
        Person danil = new Person("Даниил", LocalDate.of(2016, 1, 1));

        anna.AddChild(roman);
        anna.AddChild(liza);
        roman.AddChild(danil);

        FamilyTree familyTree = new FamilyTree(anna);

        cmdManager.PrintText("Потомки: " + anna + "\n");
        PrintTreeMap(familyTree.GetAllChildren());

        return false;
    }

    private void PrintTreeMap(Map<Integer, List<Person>> map) {
        for (int key : map.keySet()) {
            cmdManager.PrintText("Поколение " + key + ":");
            for (var person : map.get(key)) {
                cmdManager.PrintText("    " + person);
            }
        }
    }
}