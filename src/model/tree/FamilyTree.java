package model.tree;
import model.Builder.HumanBuilder;
import model.human.Human;
import model.human.comparators.ComparatorByAge;
import model.human.comparators.ComparatorById;
import model.human.comparators.ComparatorByLastname;
import model.human.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyTreeItem<T> > implements Serializable, Iterable< T > {
//    private int id = 1;
    private List< T > familyList;
    public FamilyTree() {
        familyList = new ArrayList<>();
//        this(new ArrayList<>());
    }
    public FamilyTree(List< T> familyList) {
        this.familyList=familyList;
    }

    /**
     * Добавление человека в FamilyList с проверкой уникальности
     * @param human
     */
//    public void addHuman(T human) {
//        human.setId(id++);
//        if (!familyList.contains(human)) familyList.add(human);
////        familyList.add(human);
//    }
//    public void addHuman(String name, int age){
//        T human = builder.build(name, age);
//        familyList.addHuman(human);
//    }
public void addHuman(T human) {
    familyList.add(human);
}

    /**
     * Вывод в строках всех членов семьи с датами, родителями, детьми, возрастом, полом и ID, полученная при переборе элементов в FamilyList
     * @return Строка
     */
    public String allTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Вывод всех членов семьи\n").append("-".repeat(128)).append("\n");
        for (T member: familyList) {
            sb.append(member.getId());
            sb.append(member.getFullName());
            sb.append("; ");
            sb.append("Дата рождения: ").append(member.getDayOfBirth()).append("; ");

            if(member.getDayOfDeath()!=null) {
                sb.append("Дата смерти: ");
                sb.append(member.getDayOfDeath());
                sb.append("; ");
                sb.append("Возраст: ");
                sb.append(member.getAge());
                sb.append(" лет; ");
            }
            else {
                sb.append("Возраст: ");
                sb.append(member.getAge());
                sb.append(" лет; ");
            }
            sb.append(member.getParents().replace("{", "").replace("}", ""));
            sb.append("; ");
            sb.append(member.getSpouse());
            sb.append("; ");
            sb.append(member.getChildren().replace("[", " ").replace("]", " ").strip()).append("\n");
            sb.append("-".repeat(128));
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Поиск и вывод в строку Данных о человеке по поисковому слову "name", которое может содержаться в имени или фамилии
     * @param name
     * @return Строка данных "ID, Фамилия, Имя, Родители, Дети"
     */
    public String SearchByNameSurname (String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Результат поиска: \n");
        for (T member: familyList) {
            if(member.getName().contains(name)|| member.getLastname().contains(name)){
                sb.append(member.getId());
                sb.append(member.getFullName());
                sb.append("; ");
                sb.append(member.getDayOfBirth());
                sb.append("; ");
                sb.append(member.getAge());
                sb.append("; ");
                sb.append(member.getParents().replace("{", "").replace("}", ""));
                sb.append("; ");
                sb.append(member.getSpouse());
                sb.append("; ");
                sb.append(member.getChildren().replace("[", "").replace("]", ""));
                sb.append("; ");
                sb.append("\n");
            }
        }
        return sb.toString();
    }


//    @Override
//    public String toString() {
//        return allTree().replace("Вывод всех членов семьи", "Отсортированное древо: \n");
//    }

    @Override
    public Iterator< T > iterator() {
        return new HumanIterator<>(familyList);
    }

    public void sortByName(){
        System.out.println("Сортировка по имени\n");
        familyList.sort(new ComparatorByName<>());
    }

    public void sortByLastname(){
        System.out.println("Сортировка по фамилии\n");
        familyList.sort(new ComparatorByLastname<>());
    }

    public void sortByAge(){
        System.out.println("Сортировка по возрасту\n");
        familyList.sort(new ComparatorByAge<>());
    }

    public T searchById(int id){
        StringBuilder sb = new StringBuilder();
        StringBuilder sbId = new StringBuilder();
        String idS = sbId.append(id).toString();
        for (T member: familyList) {
            if(member.getId().contains(idS)){
                return member;
            }
        }
        return null;
    }

    public void sortById() {
        System.out.println("Сортировка по ID\n");
        familyList.sort(new ComparatorById<>());
    }
}
