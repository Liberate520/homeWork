package com.britenight;

import com.britenight.FamilyTree.FamilyTree;
import com.britenight.FamilyTree.FamilyTreeNode;
import com.britenight.FamilyTree.Relation;
import com.britenight.FamilyTree.RelationType;
import com.britenight.Person.Gender;
import com.britenight.Person.Person;
import com.britenight.ImportExport.OperationsWithFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Person> tree = new FamilyTree<>();

        tree.addObject(new Person(0, "Sergey", LocalDate.parse("1980-02-24"), Gender.Male));
        tree.addObject(new Person(1, "Ekaterina", LocalDate.parse("1976-06-11"), Gender.Female));
        tree.addObject(new Person(2, "Ivan", LocalDate.parse("2001-09-29"), Gender.Male));
        tree.addObject(new Person(3, "Elena", LocalDate.parse("1999-01-15"), Gender.Female));
        tree.addObject(new Person(4, "Egor", LocalDate.parse("2023-04-14"), Gender.Male));
        tree.addObject(new Person(5, "Anastasiya", LocalDate.parse("2021-07-11"), Gender.Female));

        tree.addRelation(new Relation<Person>(tree.getObjects().get(0), tree.getObjects().get(1), RelationType.Spouse));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(1), tree.getObjects().get(0), RelationType.Spouse));

        tree.addRelation(new Relation<Person>(tree.getObjects().get(2), tree.getObjects().get(0), RelationType.Parent));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(2), tree.getObjects().get(1), RelationType.Parent));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(2), tree.getObjects().get(3), RelationType.Spouse));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(3), tree.getObjects().get(2), RelationType.Spouse));

        tree.addRelation(new Relation<Person>(tree.getObjects().get(4), tree.getObjects().get(2), RelationType.Parent));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(4), tree.getObjects().get(3), RelationType.Parent));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(4), tree.getObjects().get(5), RelationType.Sibling));

        tree.addRelation(new Relation<Person>(tree.getObjects().get(5), tree.getObjects().get(2), RelationType.Parent));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(5), tree.getObjects().get(3), RelationType.Parent));
        tree.addRelation(new Relation<Person>(tree.getObjects().get(5), tree.getObjects().get(4), RelationType.Sibling));

        var importExport = new OperationsWithFile<Person>();

        importExport.saveToFile(tree, "myTree.fmt");

        FamilyTree<Person> importedTree = importExport.readFromFile("myTree.fmt");




        List<FamilyTreeNode<Person>> nodes = importedTree.getNodes();
        nodes.sort(new Comparator<FamilyTreeNode<Person>>() {
            @Override
            public int compare(FamilyTreeNode o1, FamilyTreeNode o2) {
                return o1.getObject().compareTo(o2.getObject());
            }
        });

        for (FamilyTreeNode<Person> ftn : nodes) {
            System.out.println("\n");
            System.out.println("Человек:");
            System.out.println(ftn.getObject());
            System.out.println("Связи:");
            for (Relation<Person> relation : ftn.getRelations()) {
                System.out.printf("%s - %s\n", relation.getRelationObject(), relation.getRelationObjectType().name());
            }
        }
    }
}
