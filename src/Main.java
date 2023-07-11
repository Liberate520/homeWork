import java.util.List;

public class Main {
    public static void Main(String[] args) {
        Human humanKorolevFedor = new Human("Королев","Федор", "Ярославович", humanKorolevaNataly, humanKorolevYaroslav);
        Human humanKorolevDmitry = new Human("Королев","Дмитрий", "Ярославович" humanKorolevaNataly, humanKorolevYaroslav);
        Human humanKorolevaNataly = new Human("Королева","Наталья", "Борисовна");
        Human humanKorolevYaroslav = new Human("Королев","Ярослав", "Петрович");

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

    }

}