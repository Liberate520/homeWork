
import java.io.IOException;
import java.util.List;

import Human.Human;
import Tree.TreeCommon;
import Tree.Tree;
import Writer.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human humanKorolevaNataly = new Human("Королева","Наталья", "Борисовна");
        Human humanKorolevYaroslav = new Human("Королев","Ярослав", "Петрович");
        Human humanKorolevFedor = new Human("Королев","Федор", "Ярославович", humanKorolevaNataly, humanKorolevYaroslav);
        Human humanKorolevDmitry = new Human("Королев","Дмитрий", "Ярославович", humanKorolevaNataly, humanKorolevYaroslav);
        FileHandler fileHandler = new FileHandler();
        Tree familyKorolevs = new Tree();
     
        humanKorolevYaroslav.addChildren(humanKorolevFedor);
        humanKorolevYaroslav.addChildren(humanKorolevDmitry);
        humanKorolevaNataly.addChildren(humanKorolevFedor);
        humanKorolevaNataly.addChildren(humanKorolevDmitry);
        familyKorolevs.addFamilyTree(humanKorolevFedor);
        familyKorolevs.addFamilyTree(humanKorolevDmitry);
        familyKorolevs.addFamilyTree(humanKorolevaNataly);
        familyKorolevs.addFamilyTree(humanKorolevYaroslav);


        List<Human> children = humanKorolevDmitry.getMother().getChildren();
        children.remove(humanKorolevDmitry);
        System.out.println(children);
        System.out.println(familyKorolevs.getFamilyTreeInfo());
        fileHandler.write(familyKorolevs, "text");
    }

}