package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FamilyTree implements Serializable {
    private List<Person> tree = new ArrayList<>();      // Список всех людей в семье

    // 1 Добавление человека
    public void addPerson(Person person){
        if (!tree.contains(person)){tree.add(person);}
    }

    // 3 Добавление детей (ссылки на родителей уже внутри класса) (у родителей прописать так же детей)
    public void addChild(Person child){
        if (!tree.contains(child)){
            addPerson(child);
            if (child.getMother() != null) { child.getMother().addChild(child); }
            if (child.getFather() != null) { child.getFather().addChild(child); }
        }
    }
    public void addChild(Person child, Person mother){
        if (!tree.contains(child)){
            child.addMother(mother);
            addChild(child);
        }
    }
    public void addChild(Person child, Person mother, Person father){
        if (!tree.contains(child)){
            child.addFather(father);
            addChild(child, mother);
        }
    }
    // 4 Свадьба
    public void setMarriage(Person spouse1, Person spouse2, LocalDate marriageDate ){
        if (!tree.contains(spouse1)) { addPerson(spouse1); }
        if (!tree.contains(spouse2)) { addPerson(spouse2); }
        spouse1.setMarriage(spouse2, marriageDate);
        spouse2.setMarriage(spouse1, marriageDate);
    }
    // 5 Развод
    public void setDivorce(Person spouse1, Person spouse2, LocalDate divorceDate ){
        if (tree.contains(spouse1) && tree.contains(spouse2)) {
            spouse1.setDivorce(spouse2, divorceDate);
            spouse2.setDivorce(spouse1, divorceDate);
        }
    }
    // 6 Смерть
    public void setDeath(Person person, LocalDate deathDate){
        if (tree.contains(person)){ person.setDead(deathDate); }
    }
    // 7 Напечатать дерево
    // 8 Найти человека
}