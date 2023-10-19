package tree;

import java.util.ArrayList;
import java.util.List;

import person.Person;

public class FamilyTree {

    private String family;
    private List<Person> familyMembers;
    private int memberId = 1;

    public FamilyTree(String family) {
        this.family = family;
        familyMembers = new ArrayList<>();
    }

    public void tryAdd (Person human) throws PersExistEx {
        if (familyMembers.contains(human)) {
            throw new PersExistEx(human, "Нельзя повторно добавить такого человека. Он уже добавлен в состав семьи.");
        }
    }
    public void addMember (Person human) {
        human.setId(memberId++);
        try {
            tryAdd(human);
            if (!familyMembers.contains(human)) {
                familyMembers.add(human);
            }
        } catch (PersExistEx e) {
            System.out.println(e.getMessage());
        }
    }

    public String allMembers () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья " + family + ": \n");
        for (Person member: familyMembers) {
            stringBuilder.append(member).append("\n");
        }
        return stringBuilder.toString();
    }
    public String allMembersMaxInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семья "+family+": \n");
        for (Person member: familyMembers) {
            stringBuilder.append(member.getId()+member.getNameAndLastName());
            stringBuilder.append("Дата рождения: "+member.getBirthday()+"; "+"Возраст: "+member.getAge()+" лет; ");
            stringBuilder.append(member.getParents()+member.getSpouse()+member.getChildren()+"\n");
            stringBuilder.append("---------------------------\n");                    
        }
        return stringBuilder.toString();
    }
}

