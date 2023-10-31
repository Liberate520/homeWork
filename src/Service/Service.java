package Service;

import Human.*;
import familyTree.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Service {
    private FamilyTree tree;
    private HumanBuilder builder;

    public Service () {
        tree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman (String name, LocalDate bd, Gender gender){
        Human human = builder.build(name, bd, gender);
        tree.addHuman(human);
    }

    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of humans:").append("\n");
        for (Human human: tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void save () throws IOException, ClassNotFoundException {
        Saver saver = new Saver();
        saver.write(tree.getHumanList(), "SaverFile.txt");
    }

    public void read () throws IOException, ClassNotFoundException {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Humans list from file: \n");
        for (Human human: (List<Human>) Objects.requireNonNull(Saver.read("SaverFile.txt"))) {
            stringbuilder.append(human).append("\n");
        }
        System.out.println(stringbuilder);
    }

    @Override
    public String toString() {
        return getFamilyTree();
    }
    public void sortByName () {
        tree.sortByName();
    }

    public void sortByAge () {
        tree.sortByAge();
    }
}
