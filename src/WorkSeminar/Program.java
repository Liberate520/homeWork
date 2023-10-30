package WorkSeminar;

import WorkSeminar.Consol.СontrolTree;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        СontrolTree.ControlMain();


        //Tree tree = newTree();
        //SaveLoadTree saveTree = new SaveLoadTree();
        //saveTree.saveFile("src/WorkSeminar.SaveFile/saveTree.out", tree);
        //SaveLoadTree loadTree = new SaveLoadTree();
        //WorkSeminar.Tree tree = (WorkSeminar.Tree) loadTree.loadFile("src/WorkSeminar.SaveFile/saveTree.out");

        //System.out.println(tree);


        //tree.printSisBroth(tree.getSisBroth(3));
        // System.out.println(tree.getNamePersona("Граф"));

    }

    public static Tree newTree(){
        Tree tree = new Tree();

        Persona One = new Persona("Граф", "Грэй", Gender.Male, LocalDate.of(1988, 2, 22));
        Persona Two = new Persona("Графиня", "Грэй", Gender.Female, LocalDate.of(1990, 6, 1));
        tree.addPersona(One);
        tree.addPersona(Two);
        tree.setWedding(One, Two);

        Persona Three = new Persona("Старший сын", "Грэй", Gender.Male, LocalDate.of(2010, 1, 5));
        Persona Four = new Persona("Старшая дочь", "Грэй", Gender.Female, LocalDate.of(2009, 5, 1));
        Persona Five = new Persona("Младший сын", "Грэй", Gender.Male, LocalDate.of(2015, 3, 17));
        tree.addPersona(Three);
        tree.addPersona(Four);
        tree.addPersona(Five);


        One.addKid(Three);
        Two.addKid(Three);
        One.addKid(Four);
        Two.addKid(Four);
        One.addKid(Five);
        Two.addKid(Five);

        Three.addParent(One, Two);
        Four.addParent(One, Two);
        Five.addParent(One, Two);

        return tree;

    }


}
