package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
//    private int idHuman;
    private FamilyTree familyTree;

    public Service() {familyTree = new FamilyTree<>();}
        public void addHuman(String numPassport, String surname, String name, Human.Gender gender, LocalDate birthday, LocalDate dateOfDeath){
            Human human = new Human(numPassport, surname,name, gender, birthday, dateOfDeath);
//            human.setId(idHuman++);
            familyTree.addHuman(human);
        }
    private void addHuman(String name, Human.Gender gender, LocalDate birthday) {   // перегрузка для addToKids, addToParents, addToPartners
        Human human = new Human(name, gender, birthday);
        familyTree.addHuman(human);
    }
    public void addToKids(String name, Human.Gender gender, LocalDate birthday) {
        addHuman(name, gender, birthday);

    }

    public void addToParents(String name, Human.Gender gender, LocalDate birthday) {


    }

    public void addToPartners(String name, Human.Gender gender, LocalDate birthday) {

    }
}
