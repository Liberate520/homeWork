package service.classes;

import service.tree.FamilyTree;
import service.tree.Relation;

import java.io.Serializable;
import java.util.ArrayList;

import static service.tree.RelationType.DAUGHTER;
import static service.tree.RelationType.SON;

/*
Рабочий класс для объектов в базе
 */
public class Person extends Human implements Relation, Serializable {

    private final FamilyTree familymembers;
    private int generation = 0;

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }


    public FamilyTree getTree() {
        return this.familymembers;
    }

    public void showChildren() {
        if (this.checkMember(SON)) {
            this.showMember(SON);
        } else {
            System.out.println("No sons found.");
        }
        if (this.checkMember(DAUGHTER)) {
            this.showMember(DAUGHTER);
        } else {
            System.out.println("No daughters found.");
        }
    }

    public ArrayList<Integer> getChildren() {
        ArrayList<Integer> children = new ArrayList<>();
        try {
            children.addAll(new ArrayList<>(this.getMember(SON)));
        } catch (Exception ignored) {
        }

        try {
            children.addAll(new ArrayList<>(this.getMember(DAUGHTER)));
        } catch (Exception ignored) {
        }
        return children;
    }

    public int getChildrenCount() {
        return getChildren().size();
    }

    public Person(FamilyTree familymembers) {
        this.familymembers = familymembers;
    }

    public Person() {
        this(new FamilyTree());
    }
}
