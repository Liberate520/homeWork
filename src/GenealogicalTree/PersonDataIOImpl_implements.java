package GenealogicalTree;


import java.io.*;
import java.util.*;

public abstract class PersonDataIOImpl_implements implements PersonDataIO_interface {
    @Override
    public void writeDataToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Person person : GenealogyTreeApp.allPeople) {
            writer.write(person.getId() + "," + person.getName() + "," + person.getGender() + "," +
                    person.getDateOfBirth() + "," + person.getDateOfDeath() + "\n");

            List<Person> children = person.getChildren();
            List<Person> parents = person.getParents();

            if (!children.isEmpty()) {
                writer.write("Children:");
                for (Person child : children) {
                    writer.write("," + child.getName());
                }
                writer.write("\n");
            }

            if (!parents.isEmpty()) {
                writer.write("Parents:");
                for (Person parent : parents) {
                    writer.write("," + parent.getName());
                }
                writer.write("\n");
            }
        }
        writer.close();
    }


    @Override
    public void readDataFromFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");

            Integer id = Integer.valueOf(data[0]);
            String name = data[1];
            String gender = data[2];
            String dateOfBirth = data[3];
            String dateOfDeath = data[4];

            Person person = new Person(id, name, gender, dateOfBirth, dateOfDeath);
            GenealogyTreeApp.allPeople.add(person);

            if (line.startsWith("Children:")) {
                List<Person> children = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    String childName = data[i];
                    Person child = GenealogyTreeApp.findPersonByName(childName);
                    if (child != null) {
                        children.add(child);
                        child.addParent(person);
                    }
                }
                person.addChildren(children);
            }

            if (line.startsWith("Parents:")) {
                List<Person> parents = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    String parentName = data[i];
                    Person parent = GenealogyTreeApp.findPersonByName(parentName);
                    if (parent != null) {
                        parents.add(parent);
                        parent.addChild(person);
                    }
                }
                person.addParents(parents);
            }
        }
        bufferedReader.close();
    }

    public abstract void writeData(List<Person> people, String filename) throws IOException;

    public abstract List<Person> readData(String filename) throws IOException;
}