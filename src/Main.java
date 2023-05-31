import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Parents father = new Parents("Иван", "21.05.1986");
        Parents mother = new Parents("Маша","20.06.1990");
        Children son = new Children("Коля","18.02.2015");
        Children daughter = new Children("Катя", "15.03.2017");
//        Human grandFather = new Human();

        father.addChild(daughter);
        father.addChild(son);
        mother.addChild(daughter);
        mother.addChild(son);
        daughter.addParent(father);
        daughter.addParent(mother);
        son.addParent(father);
        son.addParent(mother);


        father.displayFamilyTree();
        mother.displayFamilyTree();
        son.displayFamilyTree();
        daughter.displayFamilyTree();


        Tree tree = new Tree();
        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);
        tree.addHuman(daughter);


        Human find = tree.findHumanName("Иван");
        System.out.print("Результат поиска: ");
        System.out.println(find);
        System.out.println();


        father.hasChild(daughter);
        father.hasChild(son);
        mother.hasChild(daughter);
        mother.hasChild(son);
        daughter.hasParent(father);
        daughter.hasParent(mother);
        son.hasParent(mother);
        son.hasParent(father);

        System.out.println();


        System.out.println(tree.getHumanList());
    }
}
