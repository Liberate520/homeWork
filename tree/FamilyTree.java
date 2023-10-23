package tree;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import person.Person;
import person.Gender;
import java.io.Serializable;

public class FamilyTree implements Serializable {

    private static final long serialVersionUID = 1L;
    private String family;
    public List<Person> familyMembers;
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
            stringBuilder.append("Дата рождения: "+member.getBirthday()+"; "+"Возраст: "+member.getAgeString()+" лет; ");
            stringBuilder.append(member.getParents()+member.getSpouse()+member.getChildren()+"\n");
            stringBuilder.append("---------------------------\n");                    
        }
        return stringBuilder.toString();
    }
    public static FamilyTree exampleFamylyTree(){
        FamilyTree resultTree = new FamilyTree("Медведевы");
        Person FirstPerson = new Person(resultTree, "Медведев", "Дмитрий", Gender.Male);
        FirstPerson.setBirthday(LocalDate.of(1996, 8, 26));
        Person SecondPerson = new Person(resultTree, "Медведева", "Ольга", Gender.Female);
        SecondPerson.setBirthday(LocalDate.of(1989, 1, 13));
        Person ThridPerson = new Person(resultTree, "Медведева", "Наталья", Gender.Female);
        ThridPerson.setBirthday(LocalDate.of(1966, 4, 2));
        Person FourPerson = new Person(resultTree, "Медведев", "Владислав", Gender.Male);
        FourPerson.setBirthday(LocalDate.of(1960, 10, 13));
        Person FifthPerson = new Person(resultTree, "Кролевецкий", "Иван", Gender.Male);
        FifthPerson.setBirthday(LocalDate.of(1991, 6, 14));
        SecondPerson.setLastname("Кролевецкая");//фамилию меняет, потому что вышла замуж
        SecondPerson.setSpouse(FifthPerson);
        Person FirstChild = new Person(resultTree, "Кролевецкая", "Екатерина", Gender.Female);
        FirstChild.setBirthday(LocalDate.of(2009, 2, 17));
        SecondPerson.setChild(FirstChild);
        FifthPerson.setChild(FirstChild);
        ThridPerson.setSpouse(FourPerson);
        ThridPerson.setChild(FirstPerson);
        ThridPerson.setChild(SecondPerson);
        FourPerson.setChild(FirstPerson);
        FourPerson.setChild(SecondPerson);
        FourPerson.setDeathday(LocalDate.of(2021, 5, 15));
        return resultTree;
    }
}

