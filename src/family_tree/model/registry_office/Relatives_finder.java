package family_tree.model.registry_office;

import family_tree.model.human.Human;
import family_tree.model.tree.FamilyTree;



public class Relatives_finder {


    Reg_office reg_office;
    Get_person get_person;


    public Relatives_finder() {
        reg_office = new Reg_office();
        get_person = new Get_person();
    }

    public void set_relatives(String str, FamilyTree<Human> familyTree){
        switch (str) {
            case "1" -> reg_office.setFamily_tree(parents_finder(familyTree));
            case "2" -> reg_office.setFamily_tree(adoption(familyTree));
            case "3" -> reg_office.setFamily_tree(marriage(familyTree));
        }
    }


        public FamilyTree<Human> parents_finder(FamilyTree<Human> family_tree){
            System.out.println(family_tree);
            long id_person = get_person.get_person_id("Ребенок", family_tree);
            long id_mother = get_person.get_person_id("Мать", family_tree);
            long id_father = get_person.get_person_id("Отец", family_tree);
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

        public FamilyTree<Human> adoption(FamilyTree<Human> family_tree) {
            System.out.println(family_tree);
            long id_person = get_person.get_person_id("Родитель", family_tree);
            long id_child = get_person.get_person_id("Ребенок", family_tree);
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

        public FamilyTree<Human> marriage(FamilyTree<Human> family_tree) {
            System.out.println(family_tree);
            long id_1 = get_person.get_person_id("Супруг", family_tree);
            long id_2 = get_person.get_person_id("Супруга", family_tree);
            if (id_1 == -1 || id_2 == -1) {
                System.out.println("\nБрак не зарегистрирован:");
            } else {
                family_tree.getById(id_1).setSpouse(family_tree.getById(id_2));
                family_tree.getById(id_2).setSpouse(family_tree.getById(id_1));
                System.out.println("\nБрак зарегистрирован:");
                System.out.println(family_tree.getById(id_1));
                System.out.println(family_tree.getById(id_2));
            }
            return family_tree;
        }


    }