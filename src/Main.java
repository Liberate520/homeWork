
import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import save.FileIO;
import save.FileIOImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
                vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25),
                vasya, masha);
        vasya.addChild(christina);
        vasya.addChild(semyon);
        masha.addChild(christina);
        masha.addChild(semyon);

        tree.add(vasya);
        tree.add(masha);
        tree.add(christina);
        tree.add(semyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);

        tree.add(grandMother);

        System.out.println(tree);

        FileIO fileIO = new FileIOImpl();
        String fileName = "familyTreeData.txt";

        String dataToWrite = convertFamilyTreeToString(tree);
        fileIO.writeToFile(fileName, dataToWrite);

        String dataRead = fileIO.readFromFile(fileName);

        FamilyTree readTree = convertStringToFamilyTree(dataRead);

        System.out.println("Family Tree read from the file:\n" + readTree);
    }

    private static String convertFamilyTreeToString(FamilyTree tree) {
        StringBuilder sb = new StringBuilder();
        List<Human> people = tree.getPeople();
        for (Human person : people) {
            sb.append(person.getName()).append(",")
                    .append(person.getGender()).append(",")
                    .append(person.getBirthDate()).append(",");

            List<Human> children = person.getChildren();
            if (!children.isEmpty()) {
                sb.append("Children:");
                for (Human child : children) {
                    sb.append(child.getName()).append(",");
                }
            }

            sb.append("\n");
        }
        return sb.toString();
    }

    private static FamilyTree convertStringToFamilyTree(String data) {
    FamilyTree tree = new FamilyTree();
    String[] lines = data.split("\n");
    for (String line : lines) {
        String[] values = line.split(",");
        String name = values[0];
        Gender gender = Gender.valueOf(values[1]);
        LocalDate birthDate = LocalDate.parse(values[2]);

        Human person = new Human(name, gender, birthDate);
        tree.add(person);

        if (values.length > 3) {
            for (int i = 3; i < values.length; i++) {
                if (values[i].startsWith("Children:")) {
                    String[] childNames = values[i].substring("Children:".length()).split(",");
                    for (String childName : childNames) {
                        Human child = new Human(childName.trim(), Gender.Unknown, LocalDate.now());
                        person.addChild(child);
                    }
                }
            }
        }
    }
    return tree;
    }
}
