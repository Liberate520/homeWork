package models;

import java.time.LocalDate;
import java.util.List;

import models.members.Gender;
import models.members.Human;
import models.repository.Keeper;
import models.tree.FamilyTree;

public class Service {
    private FamilyTree<Human> familyTree;
    private final Keeper keeper;

    public Service(Keeper keeper) {
        this.keeper = keeper;
        familyTree = getFamilyTree();
    }

    // #region получение дерева
    /** заполнение дерева */
    public FamilyTree<Human> getFamilyTree() {
        if (this.familyTree == null) {
            this.familyTree = read();
        }
        if (this.familyTree == null) {
            this.familyTree = createHumanFamily();
        }
        return familyTree;
    }

    /** заполнения дерева */
    public FamilyTree<Human> createHumanFamily() {
        FamilyTree<Human> family = new FamilyTree<>();
        Human ancestor1 = new Human("John Johnson", LocalDate.of(1910, 1, 2), Gender.Male);
        Human ancestor2 = new Human("Eliza Johnson", LocalDate.of(1909, 2, 4), Gender.Female);
        Human ancestor3 = new Human("Donald Ferguson", LocalDate.of(1908, 3, 6), Gender.Male);
        Human secondGen1 = new Human("Mike Johnson", LocalDate.of(1930, 4, 10), Gender.Male, ancestor1, ancestor2);
        Human secondGen2 = new Human("Betty Ferguson", LocalDate.of(1925, 5, 12), Gender.Female, ancestor3, null);
        Human thirdGen1 = new Human("Bobby Johnson", LocalDate.of(1950, 6, 14), Gender.Male, secondGen1, secondGen2);
        Human thirdGen2 = new Human("Christine Johnson", LocalDate.of(1955, 7, 16), Gender.Female, secondGen1, null);
        Human thirdGen3 = new Human("Steve Gomez", LocalDate.of(1951, 8, 18), Gender.Male, null, secondGen2);
        family.addNewMember(ancestor1);
        family.addNewMember(ancestor2);
        family.addNewMember(ancestor3);
        family.addNewMember(secondGen1);
        family.addNewMember(secondGen2);
        family.addNewMember(thirdGen1);
        family.addNewMember(thirdGen2);
        family.addNewMember(thirdGen3);
        return family;
    }

    /** сохранение */
    public void save() {
        keeper.save(familyTree);
    }

    /** чтение */
    private FamilyTree<Human> read() {
        return (FamilyTree<Human>) keeper.read();
    }
    // #endregion

    // #region сортировки
    /** сортировка по имени */
    public void sortFamilyByName() {
        familyTree.sortByName();
    }

    /** сортировка по дню рождения */
    public void sortFamilyByBirthday() {
        familyTree.sortByBirthday();
    }

    /* сортировка по количеству детей */
    public void sortFamilyByChildrenAmount() {
        familyTree.sortByChildrenAmount();
    }
    // #endregion

    // #region получение списков
    /** получение списка членов семьи по условию */
    public String getMembersNames() {
        return getNames((member) -> true);
    }

    /** получение списка гендеров */
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
            builder.append(members.get(i).GetShortInfo());
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
    // #endregion

    // #region получение размеров списков
    /** получение количества членов в списке по условию */
    public int getMaleAmount() {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Male).size();
    }

    public int getFemaleAmount() {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Female).size();
    }

    public int getAllAmount() {
        return familyTree.getMembers((member) -> true).size();
    }
    // #endregion

    // #region получение элемента из списка
    /** получение гендера по индексу */
    public String getGenderBy(int index) {
        return Gender.values()[index].toString();
    }

    /** получение детального описания члена семьи по условию */
    public String getMemberDetail(int index) {
        return familyTree.getMembers((member) -> true).get(index).toString();
    }


    /** получение имени члена семьи по индексу в списке по условию */
    public String getMaleName(int index) {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Male).get(index).getName();
    }

    public String getFemaleName(int index) {
        return familyTree.getMembers((member) -> member.getGender() == Gender.Female).get(index).getName();
    }

    /** получение члена семьи по индексу в списке по условию */
    private Human getMember(int index, Predicate predicate) {
        return familyTree.getMembers(predicate).get(index);
    }
    // #endregion

    /** добавление члена в семью */
    public void addNewMember(String fullName, LocalDate date, int genderInt, int fatherInt, int motherInt) {

        Gender gender = Gender.values()[genderInt];
        Human father = fatherInt == -1 ? null : getMember(fatherInt, (member) -> (member.getGender() == Gender.Male));
        Human mother = motherInt == -1 ? null : getMember(motherInt, (member) -> (member.getGender() == Gender.Female));
        Human human = new Human(fullName, date, gender, father, mother);
        familyTree.addNewMember(human);
    }

    /** обновление данных */
    public void updateMember(Integer index, String name, LocalDate date, Integer gender, Integer fatherIndex,
            Integer motherIndex) {
        Human currentHuman = getMember(index, (member) -> true);
        currentHuman.setName(name);
        currentHuman.setBirthday(date);
        currentHuman.setGender(gender == 0 ? Gender.Male : Gender.Female);
        if (fatherIndex != -1) {
            currentHuman.getFather().removeChild(currentHuman);
            currentHuman.setFather(getMember(fatherIndex, (member) -> member.getGender() == Gender.Male));
            if (fatherIndex != null) {
                currentHuman.getFather().addChild(currentHuman);
            }
        }
        if (motherIndex != -1) {
            currentHuman.getMother().removeChild(currentHuman);
            currentHuman.setMother(getMember(motherIndex, (member) -> member.getGender() == Gender.Male));
            if (motherIndex != null) {
                currentHuman.getMother().addChild(currentHuman);
            }
        }
    }
}
