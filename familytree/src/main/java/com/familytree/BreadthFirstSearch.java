package com.familytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Queue;

public class BreadthFirstSearch {
    public static Optional<List<Person>> search(String name, Person root) {
        Queue<List<Person>> queue = new ArrayDeque<>();
        Set<Person> visited = new HashSet<>();

        List<Person> pathToPerson = new ArrayList<>();
        pathToPerson.add(root);

        queue.add(pathToPerson);

        Person currentPerson;

        while (!queue.isEmpty()) {
            pathToPerson = queue.poll();
            currentPerson = pathToPerson.get(pathToPerson.size() - 1);

            if (currentPerson.getName().equals(name)) {
                return Optional.of(pathToPerson);
            } else {
                Set<Person> neighbors = currentPerson.getNeighbors();
                for (Person n : neighbors) {
                    if (!visited.contains(n)) {
                        visited.add(n);

                        List<Person> pathToNextPerson = new ArrayList<>(pathToPerson);
                        pathToNextPerson.add(n);

                        queue.add(pathToNextPerson);
                    }
                }
            }
        }

        return Optional.empty();
    }
}
