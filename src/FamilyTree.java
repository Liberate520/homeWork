package homeWork.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> members;

    private Writable writable;

    /**
     * конструктор класса FamilyTree. создаёт список и определят тип writable по умолчанию
     */
    public FamilyTree() {
        this.members = new ArrayList<>();
//        FileHandler по умолчанию
        this.writable = new FileHandler();
    }


    /**
     * печать всех членов семьи дерева
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder familyMembers = new StringBuilder();
        System.out.printf("Всего людей в дереве - %d\n", members.size());
        int count = 0;
        for (Human member : this.members) {
            count++;
            familyMembers.append("Член семьи ").append(count).append(" - ").append(member.getName()).append("\n");
        }
        return familyMembers.toString();
    }

    /**
     * добавление нового члена семьи
     *
     * @param member Human
     */
    public void addNewMember(Human member) {
//        System.out.println(this.members.size());
        this.members.add(member);   //добавляем member в список
        if (!(member.getFather() == null)) {
            member.getFather().getChildren().add(member);   //если есть отец, записываем member в список его детей
        }
        if (!(member.getMother() == null)) {
            member.getMother().getChildren().add(member);   //если есть мать, записываем member в список её детей
        }
        if (member.getChildren().size() > 0) {                //если есть дети, то записываем member в его father (mother)
            for (Human child : member.getChildren()) {
                if (member.getGender().equals("M")) {
                    child.setFather(member);
                } else if (member.getGender().equals("W")) {
                    child.setMother(member);
                }
            }
        }
        System.out.printf("Добавлен новый член семьи %s\n", member.getName());
    }

    /**
     * поиск человека по имени
     *
     * @param name имя
     * @return Human
     */
    public Human getByName(String name) {
        for (Human human : this.members) {
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
        if (writable != null) {
            if (writable instanceof FileHandler) {
                writable.save(this);
//            FileHandler fileHandler = (FileHandler) writable;     // не надо, т.к. writable уже FileHandler
            }   // если будет другой обработчик, то вызываться будет уже он со своей реализацией метода save
        } else {
            System.out.println("Файл не записан! Обработчик не определён или не верен его тип.");
        }
    }


    public FamilyTree readFamilyTree() {
//  если writable уже определён и он типа FileHandler (т.е. читаем FamilyTree из файла), то вызываем writable.read
        if (writable != null) {
            if (writable instanceof FileHandler) {
//                если FamilyTree ещё не существует, то создаём новое и возвращаем
                if ((((FileHandler) writable).read()) == null) {
                    System.out.println("FamilyTree в файле нет! Создаём новое FamilyTree.");
                    return new FamilyTree();
                } else {
                    return ((FileHandler) writable).read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

}
