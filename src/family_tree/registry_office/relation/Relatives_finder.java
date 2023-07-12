package family_tree.registry_office.relation;
import family_tree.infrastucture.My_Scanner;
import family_tree.tree.FamilyTree;
import family_tree.infrastucture.try_catch.TryLong;

import java.util.Scanner;

public class Relatives_finder implements My_Scanner {

    TryLong tl = new TryLong();
    Scanner sc = My_Scanner.sc;

    public FamilyTree parents_finder(FamilyTree family_tree){
        System.out.println(family_tree);
        long id_person = get_person("Персона", family_tree);
        long id_mother = get_person("Мать", family_tree);
        long id_father = get_person("Отец", family_tree);
        if (id_person == -1 || id_father == -1 || id_mother == -1) {
            System.out.println("\nРодство не установлено.");
            return family_tree;
        } else {
            family_tree.getById(id_person).addParent(family_tree.getById(id_mother));
            family_tree.getById(id_person).addParent(family_tree.getById(id_father));
            family_tree.getById(id_mother).addChild(family_tree.getById(id_person));
            family_tree.getById(id_father).addChild(family_tree.getById(id_person));
            System.out.println("\nРодство задокументировано:");
            System.out.println(family_tree.getById(id_person));
            System.out.println(family_tree.getById(id_mother));
            System.out.println(family_tree.getById(id_father));
        }
        return family_tree;
    }

    public FamilyTree adoption(FamilyTree family_tree) {
        System.out.println(family_tree);
        long id_person = get_person("Родитель", family_tree);
        long id_child = get_person("Ребенок", family_tree);
        if (id_person == -1 || id_child == -1) {
            System.out.println("\nУсыновление не состоялось.");
            return family_tree;
        } else  {
            family_tree.getById(id_person).addChild(family_tree.getById(id_child));
            family_tree.getById(id_child).addParent(family_tree.getById(id_person));
            System.out.println("\nРебенок усыновлен:");
            System.out.println(family_tree.getById(id_person));
            System.out.println(family_tree.getById(id_child));
        }
        return family_tree;
    }

    public FamilyTree marriage(FamilyTree family_tree) {
        System.out.println(family_tree);
        long id_1 = get_person("Супруг", family_tree);
        long id_2 = get_person("Супруга", family_tree);
        if (id_1 == -1 || id_2 == -1) {
            System.out.println("\nБрак не зарегистрирован:");
            return family_tree;
        } else {
            family_tree.getById(id_1).setSpouse(family_tree.getById(id_2));
            family_tree.getById(id_2).setSpouse(family_tree.getById(id_1));
            System.out.println("\nБрак зарегистрирован:");
            System.out.println(family_tree.getById(id_1));
            System.out.println(family_tree.getById(id_2));
            return family_tree;
        }
    }

    private long get_person(String message, FamilyTree family_tree){
        String str;
        System.out.print(message + " - введите id: ");
        str = sc.nextLine();
        long id_person = tl.try_long(str);
        try {
            family_tree.getById(id_person);
            System.out.println(message + ": " + family_tree.getById(id_person));
        } catch (Exception e){
            id_person = -1;
        }
        return id_person;
    }
}
