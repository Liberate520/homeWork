package com.familytree;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

import java.util.Scanner;

public class Parser {
    public static Map<String, Person> parse(Path CSVPath) throws FileNotFoundException {
        Map<String, Person> record = new TreeMap<String, Person>();

        Scanner scanner = new Scanner(CSVPath.toFile());

        if (!scanner.hasNextLine()) {
            throw new IllegalArgumentException("Empty CSV file!");
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split("\\s*,\\s*");
            final int field_count = fields.length;

            String name = fields[0];

            if (field_count == 2) {
                Gender gender;
                if (fields[1].equalsIgnoreCase("man")) {
                    gender = Gender.MALE;
                } else if (fields[1].equalsIgnoreCase("woman")) {
                    gender = Gender.FEMALE;
                } else {
                    throw new IllegalArgumentException("Invalid gender CSV field!");
                }

                if (record.containsKey(name)) {
                    record.get(name).setGender(gender);
                } else {
                    Person currentPerson = new Person(name, gender);
                    record.put(name, currentPerson);
                }

            } else if (field_count == 3) {
                if (!record.containsKey(name)) {
                    Person currentPerson = new Person(name);
                    record.put(name, currentPerson);
                }

                String nameB = fields[2];
                if (!record.containsKey(nameB)) {
                    Person currentPerson = new Person(nameB);
                    record.put(nameB, currentPerson);
                }

                Person person = record.get(name);
                Person personB = record.get(nameB);

                person.connect(personB);
                personB.connect(person);

                String relationship = fields[1];
                if (relationship.equalsIgnoreCase("father") || relationship.equalsIgnoreCase("mother")) {
                    person.getRelationships().put(nameB, RelationshipType.PARENT);
                } else if (relationship.equalsIgnoreCase("spouse")) {
                    person.getRelationships().put(nameB, RelationshipType.SPOUSE);
                    personB.getRelationships().put(name, RelationshipType.SPOUSE);
                } else {
                    throw new IllegalArgumentException("Invalid relationship type CSV field!");
                }

            } else {
                throw new IllegalArgumentException("Invalid number of CSV fields in line!");
            }
        }

        return record;
    }
}
