package com.familytree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

public class FTree {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, Person> record = new TreeMap<String, Person>();
        Map<StringPair, List<Person>> BFSRecord = new HashMap<>();
        Optional<List<String>> lines;

        final Path resourcesPath = Paths.get("familytree", "src", "main", "resources");

        final String helpMessage = """
                Enter 0 to print this help message
                Enter 1 to parse the CSV file
                Enter 2 to populate the record file with all person names and respective gender
                Enter 3 to determine whether two persons are related
                Enter 4 to populate the GraphViz file with the family tree encoded in DOT
                Enter 5 to terminate the program""";

        int inputOption;
        boolean shouldContinue = true;

        prettyPrint(helpMessage);

        Scanner scanner = new Scanner(System.in);

        while (shouldContinue) {
            System.out.println("Please enter an integer");
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                }
                inputOption = scanner.nextInt();
            } while (!Input.isValidOption(inputOption));

            scanner.nextLine();

            switch (inputOption) {
                case 0:
                    prettyPrint(helpMessage);

                    break;
                case 1:
                    if (!record.isEmpty()) {
                        prettyPrint("CSV is already parsed!");
                        break;
                    } else {
                        final Path CSVFilePath = Paths.get("tree.csv");
                        final Path CSVPath = resourcesPath.resolve(CSVFilePath);
                        record = Parser.parse(CSVPath);

                        prettyPrint("CSV parsed successfully!");
                        break;
                    }
                case 2:
                    final Path recordFilePath = Paths.get("record.txt");
                    final Path recordPath = resourcesPath.resolve(recordFilePath);
                    lines = Generator.generateRecordText(record);

                    if (lines.isPresent()) {
                        Utility.writeTextToFile(recordPath, lines.get());
                        prettyPrint("Record written to disk successfully!");
                    } else {
                        System.out.println("You have to parse the CSV first!");
                    }

                    break;
                case 3:
                    if (record.isEmpty()) {
                        System.out.println("You have to parse the CSV first!");
                        break;
                    }

                    String inputName;
                    String nameA;
                    String nameB;

                    boolean gotBothNames = false;
                    gotBothNamesLoop: while (!gotBothNames) {
                        System.out.println("Enter name A");
                        do {
                            while (!scanner.hasNextLine()) {
                                scanner.next();
                            }
                            inputName = scanner.nextLine();
                        } while (!Input.isValidName(inputName));

                        if (!record.containsKey(inputName)) {
                            System.out.println(inputName + " not found in the record!");
                            continue gotBothNamesLoop;
                        }

                        nameA = inputName;

                        System.out.println("Enter name B");
                        do {
                            while (!scanner.hasNextLine()) {
                                scanner.next();
                            }
                            inputName = scanner.nextLine();
                        } while (!Input.isValidName(inputName));

                        nameB = inputName;
                        gotBothNames = true;

                        if (!record.containsKey(nameB)) {
                            prettyPrint(nameA + " and " + nameB + " are not related!");

                            break;
                        }

                        StringPair sp = new StringPair(nameA, nameB);
                        List<Person> pathToPerson;

                        if (BFSRecord.containsKey(sp)) {
                            pathToPerson = BFSRecord.get(sp);
                            System.out.println("BFS Record used!");
                        } else {
                            Optional<List<Person>> relatednessResult = BreadthFirstSearch.search(nameB,
                                    record.get(nameA));
                            if (relatednessResult.isEmpty()) {
                                prettyPrint(nameA + " and " + nameB + " are not related!");
                                break;
                            } else {
                                pathToPerson = relatednessResult.get();
                                BFSRecord.put(sp, pathToPerson);
                            }
                        }

                        RelationshipTypeGendered rType;
                        Person source = pathToPerson.get(0);

                        if (Relationship.isParent(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.MOTHER
                                    : RelationshipTypeGendered.FATHER;
                        } else if (Relationship.isChild(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.DAUGHTER
                                    : RelationshipTypeGendered.SON;
                        } else if (Relationship.isSpouse(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.WIFE
                                    : RelationshipTypeGendered.HUSBAND;
                        } else if (Relationship.isSibling(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.SISTER
                                    : RelationshipTypeGendered.BROTHER;
                        } else if (Relationship.isCousin(pathToPerson)) {
                            rType = RelationshipTypeGendered.COUSIN;
                        } else if (Relationship.isGrandParent(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.GRANDMOTHER
                                    : RelationshipTypeGendered.GRANDFATHER;
                        } else if (Relationship.isGrandChild(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.GRANDDAUGHTER
                                    : RelationshipTypeGendered.GRANDSON;
                        } else if (Relationship.isNieceOrNephew(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.NIECE
                                    : RelationshipTypeGendered.NEPHEW;
                        } else if (Relationship.isAuntOrUncle(pathToPerson)) {
                            rType = source.getGender() == Gender.FEMALE ? RelationshipTypeGendered.AUNT
                                    : RelationshipTypeGendered.UNCLE;
                        } else {
                            prettyPrint(nameA + " and " + nameB + " are not related!");
                            break;
                        }

                        prettyPrint(Relationship.createRelationshipMessage(nameA, nameB, rType));
                    }

                    break;
                case 4:
                    final Path DOTFilePath = Paths.get("tree.gv");
                    final Path DOTPath = resourcesPath.resolve(DOTFilePath);
                    lines = Generator.generateDOTText(record);

                    if (lines.isPresent()) {
                        Utility.writeTextToFile(DOTPath, lines.get());
                        prettyPrint("DOT file written to disk successfully!");
                    } else {
                        System.out.println("You have to parse the CSV first!");
                    }

                    break;
                case 5:
                    prettyPrint("Exiting!");

                    shouldContinue = false;
                    break;
            }
        }

        scanner.close();
        System.exit(0);
    }

    private static void prettyPrint(String message) {
        System.out.println();
        System.out.println("====================");
        System.out.println(message);
        System.out.println("====================");
        System.out.println();
    }
}
