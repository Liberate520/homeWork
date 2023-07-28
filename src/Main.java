import family_tree.FamilyTree;
import human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human irina = new Human("Ирина", LocalDate.of(1980, 07, 20));
        Human oleg = new Human("Олег", LocalDate.of(1978, 02, 11));
        Human elizabeth = new Human("Элизабет", LocalDate.of(2005, 12, 26));
        Human katya = new Human("Екатерина", LocalDate.of(2008, 05, 11));
        Human sasha = new Human("Александр", LocalDate.of(1963, 02, 13),
                LocalDate.of(2022, 06, 15));
        List<Human> listHuman = new ArrayList<>();
        listHuman.add(irina);
        listHuman.add(oleg);
        listHuman.add(elizabeth);
        listHuman.add(katya);
        listHuman.add(sasha);

        FamilyTree ft = new FamilyTree(listHuman);
        ft.marry(listHuman.get(0), listHuman.get(1));
        ft.addChild(listHuman.get(0), listHuman.get(2));
        ft.addChild(listHuman.get(1), listHuman.get(2));
        ft.addChild(listHuman.get(0), listHuman.get(3));
        ft.addChild(listHuman.get(1), listHuman.get(3));
        ft.addParent(listHuman.get(1), listHuman.get(4));

        //ft.sortByName();
        ft.sortByDateBirthDay();
        StringBuilder sb = new StringBuilder();
        Iterator<Human> iterator = ft.iterator();
        while(iterator.hasNext()){
            sb.append(iterator.next());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
