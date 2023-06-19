package model;

import model.familyTree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.repository.FileService;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private final FileService fileService;

    public Service(FileService fileService) {
        this.fileService = fileService;
        familyTree = getFamilyTree();
    }

    // #region получение дерева

    /**
     * заполнение дерева
     */
    public FamilyTree<Human> getFamilyTree() {
        if (this.familyTree == null) {
            this.familyTree = read();
        }
        if (this.familyTree == null) {
            this.familyTree = createHumanFamily();
        }
        return familyTree;
    }

    /**
     * заполнения дерева
     */
    public FamilyTree<Human> createHumanFamily() {
        FamilyTree<Human> family = new FamilyTree<>();
        Human person1 = new Human("Николай Калугин", LocalDate.of(1938, 3, 1), Gender.Male);
        Human person2 = new Human("Зинаида Калугина", LocalDate.of(1943, 10, 15), Gender.Female);
        Human person3 = new Human("Олег Кондратьев", LocalDate.of(1965, 4, 12), Gender.Male);
        Human person4 = new Human("Иван Кондратьев", LocalDate.of(1994, 6, 21), Gender.Male, null, null);
        Human person5 = new Human("Татьяна Кондратьева", LocalDate.of(1974, 9, 19), Gender.Female, person1, person2);
        Human person6 = new Human("Денис Кондратьев", LocalDate.of(2004, 1, 29), Gender.Male, person3, person5);
        Human person7 = new Human("Дарья Кондратьева", LocalDate.of(1993, 3, 23), Gender.Female, null, null);
        Human person8 = new Human("Лев Кондратьев", LocalDate.of(2022, 6, 11), Gender.Male, person4, person7);
        family.addMember(person1);
        family.addMember(person2);
        family.addMember(person3);
        family.addMember(person4);
        family.addMember(person5);
        family.addMember(person6);
        family.addMember(person7);
        family.addMember(person8);
        return family;
    }

    public void save() {
        fileService.save(familyTree);
    }

    private FamilyTree<Human> read() {
        return (FamilyTree<Human>) fileService.read();
    }

    public void sortFamilyByName() {
        familyTree.sortByName();
    }

    public void sortFamilyByBirthday() {
        familyTree.sortByBirthday();
    }

    public void sortFamilyByChildrenAmount() {
        familyTree.sortByChildrenAmount();
    }

    public String getMembersNames() {
        return getNames((member) -> true);
    }

    public String getGenderList() {
        Gender[] genders = Gender.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < genders.length; i++) {
            builder.append("\t|> ");
            builder.append(i + 1);
            builder.append(". ");
            builder.append(genders[i]);
            builder.append("\n");
        }
        return builder.toString();
    }

    private String getNames(Predicate predicate) {
        List<Human> members = familyTree.getMembers(predicate);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < members.size(); i++) {
            builder.append("\t|> ");
            builder.append(i + 1);
            builder.append(". ");
            builder.append(members.get(i).getShortInfo());
            builder.append("\n");
        }
        return builder.toString();
    }

    public String getMaleNames() {
        return getNames((member) -> member.getGender() == Gender.Male);
    }

    public String getFemaleNames() {
        return getNames((member) -> member.getGender() == Gender.Female);
    }

    public int getMaleAmount() {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Male).size();
    }

    public int getFemaleAmount() {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Female).size();
    }

    public int getAllAmount() {
        return familyTree.getMembers((member) -> true).size();
    }

    public String getGenderBy(int index) {
        return Gender.values()[index].toString();
    }

    public String getMemberDetail(int index) {
        return familyTree.getMembers((member) -> true).get(index).toString();
    }

    public String getMaleName(int index) {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Male).get(index).getName();
    }

    public String getFemaleName(int index) {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Female).get(index).getName();
    }

    private Human getMember(int index, Predicate predicate) {
        return familyTree.getMembers(predicate).get(index);
    }
    public void addNewMember(String fullName, LocalDate date, int genderInt, int fatherInt, int motherInt) {

        Gender gender = Gender.values()[genderInt];
        Human father = fatherInt == -1 ? null : getMember(fatherInt, (member) -> (member.getGender() == Gender.Male));
        Human mother = motherInt == -1 ? null : getMember(motherInt, (member) -> (member.getGender() == Gender.Female));
        Human human = new Human(fullName, date, gender, father, mother);
        familyTree.addMember(human);
    }

    public void updateMember(Integer index, String name, LocalDate date, Integer gender, Integer fatherIndex,
                             Integer motherIndex) {
        Human currentHuman = getMember(index, (member) -> true);
        currentHuman.setName(name);
        currentHuman.setBirthday(date);
        currentHuman.setGender(gender == 0 ? Gender.Male : Gender.Female);
        if (fatherIndex != -1) {
            if (currentHuman.getFather() != null) currentHuman.getFather().removeChild(currentHuman);
            currentHuman.setFather(getMember(fatherIndex, (member) -> member.getGender() == Gender.Male));
            if (fatherIndex != null) {
                currentHuman.getFather().addChild(currentHuman);
            }
        }
        if (motherIndex != -1) {
            if (currentHuman.getMother() != null) currentHuman.getMother().removeChild(currentHuman);
            currentHuman.setMother(getMember(motherIndex, (member) -> member.getGender() == Gender.Female));
            if (motherIndex != null) {
                currentHuman.getMother().addChild(currentHuman);
            }
        }
    }
}
