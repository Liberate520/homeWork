package family;

import family.writer.FileHandler;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {

        Human A = new Human("A",1930,2011);
        Human B = new Human("B");
        Human C = new Human("C",1991);
        Human D = new Human("D", 1995);

        Tree family = new Tree();

        family.addHuman(A);
        family.addHuman(B);
        family.addHuman(C);
        family.addHuman(D);

        System.out.print("исходная семья \n"+family.outputTree()+"\n");
        save(family);

        B.addParent(A);
        B.addChild(C);
        B.setBirn(1960);
        B.setDie(2023);
        D.setPair(C);

        System.out.print("новые данные \n"+family.outputTree()+"\n");

        Tree familyNEW = load();
        System.out.print("загруженные данные \n"+familyNEW.outputTree()+"\n");

    }

    private static void save(Tree family){
        FileHandler fileHandler=new FileHandler();
        String path="src/family.txt";
        fileHandler.save(family,path);
    }

    private static Tree load(){
        FileHandler fileHandler=new FileHandler();
        String path="src/family.txt";
        return (Tree) fileHandler.read(path);
    }

}