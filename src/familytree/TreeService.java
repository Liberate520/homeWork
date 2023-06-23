package familytree;

import human.Human;
import save.FileOperations;

import java.io.Serializable;
import java.time.LocalDate;

public class TreeService implements Serializable {
    private Tree<Human> tree;
    private FileOperations fileOperations;
    public String filePath = "test.txt";

    public TreeService(FileOperations fileOperations){
        this.tree = new Tree<>();
        this.fileOperations = fileOperations;
    }

    public TreeService(Tree<Human> tree){
        this.tree = tree;

        tree.add(new Human("Иван", "мужской", LocalDate.of(1987,7,15),null));
        tree.add(new Human("Ирина", "женский", LocalDate.of(1980,5,11),null));

        tree.add(new Human("Василина", "женский", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2010,1,1), null));
        tree.add(new Human("Коля", "мужской", tree.findHumanName("Иван"), tree.findHumanName("Ирина"), LocalDate.of(2012,2,2), null));
    }

    public void add(String name, String gender, Human father, Human mother, LocalDate dateOfBirth, LocalDate deathDate) {
        tree.add(new Human(name, gender, father, mother, dateOfBirth, deathDate));
    }

    public String getInfoHuman(){
        StringBuilder sb = new StringBuilder();
        for (Human human : tree) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void setWrite(FileOperations writable) {
        this.fileOperations = writable;
    }

    public void save(){
        fileOperations.write(tree, filePath);
    }

    public void load(){
        fileOperations.read(filePath);
    }


    public void sortByName(){
        tree.sortByName();
    }

    public void sortById(){
        tree.sortById();
    }

    public  void sortByAge(){
        tree.sortByAge();
    }
}
