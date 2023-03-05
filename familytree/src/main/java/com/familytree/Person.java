package com.familytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Person {
    private String name;
    private Gender gender;

    private Set<Person> neighbors = new HashSet<>();

    private Map<String, RelationshipType> relationships = new HashMap<>();

    private Map<StringPair, Integer> distance = new HashMap<>();

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender newGender) {
        this.gender = newGender;
    }

    public Set<Person> getNeighbors() {
        return neighbors;
    }

    public Map<String, RelationshipType> getRelationships() {
        return relationships;
    }

    public Optional<Integer> getDistance(StringPair sp) {
        if (distance.containsKey(sp)) {
            return Optional.of(distance.get(sp));
        }
        return Optional.empty();
    }

    public void setDistance(StringPair sp, int newDistance) {
        this.distance.put(sp, newDistance);
    }

    public void connect(Person person) {
        if (person.getName().equals(this.name)) {
            throw new IllegalArgumentException("Can't connect person to itself");
        }
        this.neighbors.add(person);
    }
}