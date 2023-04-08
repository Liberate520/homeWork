import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyTree implements SaveRead{
    private List<Human> family;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList family) {
        this.family = family;
    }

    public void printFamily() {
        System.out.println("Члены семьи");
        for (Human human : family) {
            System.out.println(human + "\n");
        }
    }

    public void printChildrens(Human human) {
        List<Human> kids = human.getChild();
        System.out.println("Дети " + human.getName() + ":");
        for (Human person : kids) {
            System.out.println(person + "\n");
        }
    }

    public void printParents(Human human) {
        List<Human> parents = human.getParent();
        System.out.println("Родители " + human.getName() + ":");
        for (Human person : parents) {
            System.out.println(person + "\n");
        }
    }

    public void addHuman(Human human) {
        family.add(human);
    }

    public String textForFile() {
        String text = "Вся семья:\n";
        
        for (Human human : family) {
            text = text + human + "\n";
        }
        text = text + "Семейные узы:\n";
        for (Human human : family) {
            String parents = "";
            Set<Human> parentsSet = new HashSet<>();
            for (Human parent : human.getParent()) {
                if(!parentsSet.contains(parent)){
                    parents += parent.getName() + ",";
                }
                parentsSet.add(parent);
            }
            if(parents.length() >= 1) {
                parents = parents.substring(0, parents.length()-1);
            }
            if (parents.length() < 1) {
                parents = "неизвестно";
            }
            
            String children = "";
            Set<Human> childrenSet = new HashSet<>();
            for (Human child : human.getChild()) {
                if(!childrenSet.contains(child)){
                    children += child.getName() + ",";
                }
                childrenSet.add(child);
            }
            if(children.length() >= 1) {
                children = children.substring(0, children.length()-1);
            }
            if (children.length() < 1) {
                children = "отсутствуют";
            }
            
            text = text + human.getName() + " - родители: " + parents + " дети: " + children + "\n";
        }
        return text;
    }
}
