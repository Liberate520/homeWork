package faminly_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree {
   private List<Human> tree = new ArrayList<>();
   private HashMap<Human, Human> fathersList = new HashMap<>();
    private HashMap<Human, Human> mothersList = new HashMap<>();

    public void addPerson(Human human){
        tree.add(human);
    }
    // Получается что, если я буду создавать людей через методы этого класса, то, имея два конструктора у Human,
    // я должна создавать перегрузку методов addFather и addMother, чтобы учесть оба конструктора.
    // Этого можно как-то избежать и нужно ли?

    /**
     * Добавить отца человека
     * @param name имя отца
     * @param birthYear год рождения отца
     * @param birthMonth месяц рождения отца
     * @param birthDay день рождения отца
     * @param human человек, чьего отца добавляем
     */
    public void addFather(String name, int birthYear, int birthMonth, int birthDay, Human human){
        Human father = new Human(name, Gender.Male, birthYear, birthMonth, birthDay);
        tree.add(father); //добавляем его в общий список персон
        fathersList.put(human, father); //добавляем в словарь отцов
        human.setFather(father); //определяем поле отец у человека, для которого вызвали метод
        List<Human> children = father.getChildren(); //находим других детей этого отца
        if (children == null){
            children = new ArrayList<>();
            children.add(human);
        }
        else children.add(human); //добавляем человека, для которого вызвали метод
        father.setChildren(children); //переопределяем поле дети у этого отца
    }
    public void addFather(String name, int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth, int deathDay, Human human){
        Human father = new Human(name, Gender.Male, birthYear, birthMonth, birthDay, deathYear, deathMonth, deathDay);
        tree.add(father); //добавляем его в общий список персон
        fathersList.put(human, father); //добавляем в словарь отцов
        human.setFather(father); //определяем поле отец у человека, для которого вызвали метод
        List<Human> children = father.getChildren(); //находим других детей этого отца
        if (children == null){
            children = new ArrayList<>();
            children.add(human);
        }
        else children.add(human); //добавляем человека, для которого вызвали метод
        father.setChildren(children); //переопределяем поле дети у этого отца
    }

    /**
     * Добавить мать человека
     * @param name имя матери
     * @param birthYear год рождения матери
     * @param birthMonth месяц рождения матери
     * @param birthDay день рождения матери
     * @param human человек, чью мать добавляем
     */
    public void addMother(String name, int birthYear, int birthMonth, int birthDay, Human human){
        Human mother = new Human(name, Gender.Female, birthYear, birthMonth, birthDay);
        tree.add(mother);
        mothersList.put(human, mother);
        human.setMother(mother);
        List<Human> children = mother.getChildren();
        if (children == null){
            children = new ArrayList<>();
            children.add(human);
        }
        else children.add(human);
        mother.setChildren(children);
    }
    public void addMother(String name, int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth, int deathDay, Human human){
        Human mother = new Human(name, Gender.Female, birthYear, birthMonth, birthDay, deathYear, deathMonth, deathDay);
        tree.add(mother); //добавляем его в общий список персон
        mothersList.put(human, mother); //добавляем в словарь отцов
        human.setMother(mother); //определяем поле отец у человека, для которого вызвали метод
        List<Human> children = mother.getChildren(); //находим других детей этого отца
        if (children == null){
            children = new ArrayList<>();
            children.add(human);
        }
        else children.add(human); //добавляем человека, для которого вызвали метод
        mother.setChildren(children); //переопределяем поле дети у этого отца
    }
    public void addChildren(String name, int birthYear, int birthMonth, int birthDay, Human human){
        Human child = new Human(name, Gender.Female, birthYear, birthMonth, birthDay);
        tree.add(child);
        if (human.getGender() == Gender.Male) {
            fathersList.put(child, human);
            child.setFather(human);
        }
        else {
            mothersList.put(child, human);
            child.setMother(human);
        }
        List<Human> children = human.getChildren();
        if (children == null){
            children = new ArrayList<>();
            children.add(child);
        }
        else children.add(child);
        human.setChildren(children);
    }
    public String findParents(Human human){
        StringBuilder parents = new StringBuilder();
        Human father = fathersList.get(human);
        Human mother = mothersList.get(human);
        if (father != null) parents.append("Father:\n" + father + "\n");
        else parents.append("Father not found\n");
        if (mother != null) parents.append("Mother:\n" + mother + "\n");
        else parents.append("Mother not found\n");
        return parents.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }

    @Override
    public String toString(){
        return tree.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
    }
}
