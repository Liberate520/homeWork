package com.familytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Generator {
    public static Optional<List<String>> generateRecordText(Map<String, Person> record) {
        if (record.isEmpty()) {
            return Optional.empty();
        }

        List<String> linesToWrite = new ArrayList<>();

        for (Map.Entry<String, Person> entry : record.entrySet()) {
            String toWrite = entry.getKey() + ", " + entry.getValue().getGender().name() + "\n";
            linesToWrite.add(toWrite);
        }
        return Optional.of(linesToWrite);
    }

    public static Optional<List<String>> generateDOTText(Map<String, Person> record) {
        if (record.isEmpty()) {
            return Optional.empty();
        }

        List<String> linesToWrite = new ArrayList<>();

        final String DOTHeader = "digraph GoT {\n" + "rankdir=LR;\n" + "size=\"8,5\"\n"
                + "node [shape = rectangle] [color = black];\n";
        linesToWrite.add(DOTHeader);

        for (Map.Entry<String, Person> recordEntry : record.entrySet()) {
            Person currentPerson = recordEntry.getValue();
            Map<String, RelationshipType> currentRelationships = currentPerson.getRelationships();

            if (!currentRelationships.isEmpty()) {
                for (Map.Entry<String, RelationshipType> relationshipEntry : currentRelationships.entrySet()) {
                    RelationshipType currentRelationship = relationshipEntry.getValue();

                    if (currentRelationship.equals(RelationshipType.PARENT)) {
                        String relatedPersonName = relationshipEntry.getKey();

                        String toWrite = "\"" + currentPerson.getName() + "\" -> \"" + relatedPersonName
                                + "\" [label=\""
                                + (currentPerson.getGender().equals(Gender.MALE) ? "father" : "mother")
                                + "\"];\n";

                        linesToWrite.add(toWrite);
                    }
                }
            }
        }

        linesToWrite.add("}\n");

        return Optional.of(linesToWrite);
    }
}
