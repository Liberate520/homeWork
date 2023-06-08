import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Human ivan = new Human("Иван", LocalDate.of(1987, 7, 20));
        Human maria = new Human("Мария", LocalDate.of(1989, 5, 15));

        tree.addHuman(ivan);
        tree.addHuman(maria);

        Human vasilina = new Human("Василина", LocalDate.of(2015, 8, 11), ivan, maria);
        Human kolya = new Human("Коля", LocalDate.of(2011, 1, 16), ivan, maria);

        tree.addHuman(vasilina);
        tree.addHuman(kolya);

        System.out.println(tree.getHumanList());

        Human find = tree.findHumanName("Иван");
        System.out.print("Результат поиска: ");
        System.out.println(find);
        System.out.println();

        List<Human> childrenOfIvan = tree.getChildrenOfHuman(ivan);
        System.out.println("Дети:" + ivan);
        for (Human child : childrenOfIvan) {
            System.out.println(child.getName());
        }
        System.out.println();

        // Вывод списка родителей при выборе ребенка
        List<Human> parentsOfVasilina = tree.getParentsOfHuman(vasilina);
        System.out.println("Родители:" + vasilina);
        for (Human parent : parentsOfVasilina) {
            System.out.println(parent.getName());
        }
        System.out.println();
    }
    }
