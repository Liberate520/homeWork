package Exercises.Homework1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class FamilyTree {

    public FamilyTree(Person root) {
        this._root = root;
    }

    private Person _root;

    public Person getRootPerson() {
        return _root;
    }

    public Map<Integer, List<Person>> GetAllChildren() {
        Map<Integer, List<Person>> generationFiltered = new TreeMap<>();
        Queue<Person> queue = new LinkedList<>();
        Person earlyPerson = null;
        queue.offer(_root);
        int step = 0;
        while (!queue.isEmpty()) {
            Person currentPerson = queue.poll();
            if (earlyPerson != null && IsOneGeneration(earlyPerson, currentPerson)) {
                var children = generationFiltered.get(step);
                children.addAll(currentPerson.GetChildren());
                generationFiltered.replace(step, children);
            } else if (currentPerson.GetChildren().size() > 0) {
                generationFiltered.put(++step, currentPerson.GetChildren());

            }
            queue.addAll(currentPerson.GetChildren());
            earlyPerson = currentPerson;
        }
        return generationFiltered;

    }

    public static Boolean IsOneGeneration(Person person1, Person person2) {
        var parrents1 = person1.GetParrents();
        var parrents2 = person2.GetParrents();
        for (Person parrent1 : parrents1) {
            for (Person parrent2 : parrents2) {
                if (parrent1.equals(parrent2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
