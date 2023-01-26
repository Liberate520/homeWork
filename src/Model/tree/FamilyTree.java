package Model.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static Model.Service.countPostfix;

public class FamilyTree<T extends Creature> implements Iterable<T>, Containerable{
    private String name;
    private Integer volume;
    private List<T> treeElements = new ArrayList<>();

    private Writable writable;

    public FamilyTree(String name) {
        this.name = name;
        this.volume = 0;
    }

    public FamilyTree(String name, List<T> creature) {
        this(name);
        this.volume = creature.size();
        for (T creatures : creature) {
            this.treeElements.add(creatures);
        }
    }

    public void addElement(T creature){
        this.treeElements.add(creature);
        this.volume++;
    }



    @Override
    public String toString() {
        StringBuilder humansForPrint = new StringBuilder();
        for (T creature : treeElements) {
            humansForPrint.append("\n").append(creature);
            if (creature.getMother() != null) {
                humansForPrint.append(", мать: ").append(creature.getMother().getFullName());
            } else humansForPrint.append(", мать: ").append("Не указано");
            if (creature.getFather() != null) {
                humansForPrint.append(", отец: ").append(creature.getFather().getFullName());
            } else humansForPrint.append(", отец: ").append("Не указано");
            if (creature.getChildren().size() !=0){
                List<T> childs = creature.getChildren();
                humansForPrint.append(", дети: ");
                for (Creature child : childs) {
                    humansForPrint.append(child.getFullName()).append(", ");
                }
                humansForPrint.deleteCharAt(humansForPrint.length() - 2);
            } else humansForPrint.append(", дети: Не указано");
        }
        return "Семейное дерево " + name +
                " cостоит из " + volume + " " + countPostfix(volume) + ":" +
                humansForPrint;
    }

    public List<T> getTreeElements() {
        return treeElements;
    }

    public String getName() {
        return name;
    }

    public void findByName(String name){
        for (T creature : this.treeElements) {
            if (creature.getFullName().equalsIgnoreCase(name)) {
                System.out.println(creature);
            }
        }
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void save() throws IOException {
        if (writable != null) {
            writable.writeTreeToFile(this);
        }
    }

    public FamilyTree read() throws IOException {
        if (writable != null) {
            writable.readTreeFromFile(this);
        }
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator(treeElements);
    }

    @Override
    public String getVisibleName() {
        return this.name;
    }

    @Override
    public String getVisibleType() {
        return "Семейное дерево";
    }
}