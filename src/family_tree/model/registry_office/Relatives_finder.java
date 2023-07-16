package family_tree.model.registry_office;

import family_tree.model.Service;
import family_tree.model.human.Human;
import family_tree.model.tree.FamilyTree;



public class Relatives_finder {


    Reg_office reg_office;
    Get_person get_person;


    public Relatives_finder() {
        reg_office = new Reg_office();
        get_person = new Get_person();
    }

        public void parents_finder(FamilyTree<Human> family_tree){
            new Service().send_info(family_tree.getInfo());
            long id_person = get_person.get_person_id("Ребенок", family_tree);
            long id_mother = get_person.get_person_id("Мать", family_tree);
            long id_father = get_person.get_person_id("Отец", family_tree);
            if (id_person == -1 || id_father == -1 || id_mother == -1) {
                new Service().send_info("\nРодство не установлено.");

            } else {
                family_tree.getById(id_person).addParent(family_tree.getById(id_mother));
                family_tree.getById(id_person).addParent(family_tree.getById(id_father));
                family_tree.getById(id_mother).addChild(family_tree.getById(id_person));
                family_tree.getById(id_father).addChild(family_tree.getById(id_person));
                new Service().send_info("\nРодство задокументировано:\n" +
                                            family_tree.getById(id_person) + "\n" +
                                            family_tree.getById(id_mother) + "\n" +
                                            family_tree.getById(id_father));
            }
            reg_office.setFamily_tree(family_tree);
        }

        public void adoption(FamilyTree<Human> family_tree) {
            new Service().send_info(family_tree.getInfo());
            long id_person = get_person.get_person_id("Родитель", family_tree);
            long id_child = get_person.get_person_id("Ребенок", family_tree);
            if (id_person == -1 || id_child == -1) {
                new Service().send_info("\nУсыновление не состоялось.");
            } else  {
                family_tree.getById(id_person).addChild(family_tree.getById(id_child));
                family_tree.getById(id_child).addParent(family_tree.getById(id_person));
                new Service().send_info("\nРебенок усыновлен:\n" +
                                            family_tree.getById(id_person) + "\n" +
                                            family_tree.getById(id_child));
            }
            reg_office.setFamily_tree(family_tree);
        }

        public void marriage(FamilyTree<Human> family_tree) {
            new Service().send_info(family_tree.getInfo());
            long id_1 = get_person.get_person_id("Супруг", family_tree);
            long id_2 = get_person.get_person_id("Супруга", family_tree);
            if (id_1 == -1 || id_2 == -1) {
                new Service().send_info("\nБрак не зарегистрирован:");
            } else {
                family_tree.getById(id_1).setSpouse(family_tree.getById(id_2));
                family_tree.getById(id_2).setSpouse(family_tree.getById(id_1));
                new Service().send_info("\nБрак зарегистрирован:\n" +
                                                family_tree.getById(id_1) + "\n" +
                                                family_tree.getById(id_2));
            }
            reg_office.setFamily_tree(family_tree);
        }
    }