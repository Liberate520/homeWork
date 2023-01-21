package homeWork.src.familyTree;

import homeWork.src.familyTree.comparators.Comparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {      // сериализируемый, итерируемый

    private List<T> members;

    private Writable writable;

    /**
     * конструктор класса FamilyTree. создаёт список и определят тип writable по умолчанию
     */
    public FamilyTree(Writable writable) {
        this.members = new ArrayList<>();
//        FileHandler по умолчанию
        this.writable = writable;
    }

    /**
     * печать всех членов семьи дерева
     *
     * @return String
     */
//    @Override
//    public String toString() {
//        StringBuilder familyMembers = new StringBuilder();
//        System.out.printf("Всего людей в дереве - %d\n", members.size());
//        int count = 0;
//        for (Human member : this.members) {
//            count++;
//            familyMembers.append("Член семьи ").append(count).append(" - ").append(member.getName()).append("\n");
//        }
//        return familyMembers.toString();
//    }


    /**
     * печать всех членов семьи дерева. реализация через Iterable.
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder familyMembers = new StringBuilder();
        System.out.printf("Всего людей в дереве - %d\n", members.size());
        int count = 0;
        for (T member : this) {
            familyMembers.append("Член семьи ").append(++count).append(" - ").append(member.getName()).append(", ").append("возраст ").append(member.getAge()).append("\n");
        }
        return familyMembers.toString();
    }

    /**
     * добавление нового члена семьи
     *
     * @param member Human
     */
    public void addNewMember(T member) {
//        System.out.println(this.members.size());
        this.members.add(member);   //добавляем member в список
        if (!(member.getFather() == null)) {
            member.getFather().addChild(member);   //если есть отец, записываем member в список его детей
        }
        if (!(member.getMother() == null)) {
            member.getMother().addChild(member);   //если есть мать, записываем member в список её детей
        }
        if (member.getChildren().size() > 0) {                //если есть дети, то записываем member в его father (mother)
// child должен быть типа T (параметризированный, иначе не имеет смысла), а member.getChildren() возвращает тип Human.
// Idea предложила реализовать forEach через лямбду для итерации по List. Работает.
// Или можно реализовать обычным циклом for от 0 до < member.getChildren().size()
            member.getChildren().forEach(child -> {
                if (member.getGender().equals("M")) {
                    child.setFather(member);
                } else if (member.getGender().equals("W")) {
                    child.setMother(member);
                }
            });
        }
        System.out.printf("Добавлен новый член семьи %s\n", member.getName());
    }

    /**
     * поиск человека по имени
     *
     * @param name имя
     * @return Human
     */
    public T getByName(String name) {
        for (T human : this.members) {
//            при поиске не учитывать регистр
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }


    public void setWritable(Writable writable) {
        this.writable = writable;
    }


    public void saveFamilyTree() {
//  если writable уже определён и он типа FileHandler, то вызываем writable.save c аргументом текущего FamilyTree
//        if (writable != null) {
//            if (writable instanceof FileHandler) {
        writable.save(this);
//            FileHandler fileHandler = (FileHandler) writable;     // не надо, т.к. writable уже FileHandler
//            }   // если будет другой обработчик, то вызываться будет уже он со своей реализацией метода save
//        } else {
//            System.out.println("Файл не записан! Обработчик не определён или не верен его тип.");
//        }
    }


    public FamilyTree readFamilyTree() {
//  если writable уже определён и он типа FileHandler (т.е. читаем FamilyTree из файла), то вызываем writable.read
        if (writable != null) {
            if (writable instanceof FileHandler) {
//                если FamilyTree ещё не существует, то создаём новое и возвращаем
                if (writable.read() == null) {
//                if ((((FileHandler) writable).read()) == null) {
                    System.out.println("FamilyTree в файле нет! Создаём новое FamilyTree.");
                    return new FamilyTree(writable);
                } else {
                    System.out.println("FamilyTree загружено из файла.");
                    //                    System.out.println(familyTree);
                    return (FamilyTree) writable.read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>(members);
    }


    public List<T> getMembers() {
        return members;
    }


    /**
     * сортировка FamilyTree по параметру
     *
     * @param sortParameter String
     */
    public void sortFamilyTree(String sortParameter) {
        Collections.sort(this.getMembers(), new Comparator(sortParameter));

    }


}
