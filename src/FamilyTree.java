package homeWork.src;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    List<Human> members;

    /**
     * конструктор класса FamilyTree. просто создаёт список
     */
    public FamilyTree() {
        this.members = new ArrayList<>();
    }


    /**
     * печать всех членов семьи дерева
     *
     * @return
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
    }

    /**
     * поиск человека по имени
     *
     * @param name имя
     * @return Human
     */
    public Human getByName(String name) {
        for (Human human : this.members) {
            if (human.getName().toLowerCase().equals(name.toLowerCase())) {
                return human;
            }
        }
        return null;
    }


}
