package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import models.members.Gender;
import models.members.Human;
import models.repository.CapableOfPreserving;
import models.repository.CapableOfRestore;
import models.repository.FileHandler;
import models.tree.FamilyTree;

public class Service {
    private FamilyTree<Human> familyTree;

    private String path;

    public Service(String path) {
        this.path = path;
        getFamilyTree();
    }

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
        CapableOfPreserving preserver = new FileHandler();
        preserver.save(path, familyTree);
    }

    /** чтение */
    private FamilyTree<Human> read() {
        CapableOfRestore restorer = new FileHandler();
        return (FamilyTree<Human>) restorer.read(path);
    }

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

    /** получение списка членов семьи по условию */
    public String getInfo(Predicate predicate) {

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

    /** получение гендера по индексу */
    public String getGenderBy(int index) {
        return Gender.values()[index].toString();
    }

    /** получение количества членов в списке по условию */
    public int getAmountOfList(Predicate predicate) {
        return familyTree.getMembers(predicate).size();
    }

    /** добавление члена в семью */
    public boolean addNewMember(String fullname, LocalDate date, int genderInt, int fatherInt, int motherInt) {

        Gender gender = Gender.values()[genderInt];
        Human father = fatherInt == -1 ? null : getMember(fatherInt, (member) -> (member.getGender() == Gender.Male));
        Human mother = motherInt == -1 ? null : getMember(motherInt, (member) -> (member.getGender() == Gender.Female));
        Human human = new Human(fullname, date, gender, father, mother);
        familyTree.addNewMember(human);
        return true;
    }

    /** получение детального описания члена семьи по условию */
    public String getMemberDetail(int index, Predicate predicate) {
        return familyTree.getMembers(predicate).get(index).toString();
    }

    /** получение дня рождения члена семьи по индексу в списке по условию */
    public String getMemberDate(int index, Predicate predicate) {
        return DateTimeFormatter.ISO_LOCAL_DATE.format(familyTree.getMembers(predicate).get(index).getBirthday());
    }

    /** получение имени члена семьи по индексу в списке по условию */
    public String getMemberName(int index, Predicate predicate) {
        return familyTree.getMembers(predicate).get(index).getName();
    }

    /** получение члена семьи по индексу в списке по условию */
    private Human getMember(int index, Predicate predicate) {
        return familyTree.getMembers(predicate).get(index);
    }

    /** установка имени члена семьи по индексу в списке по условию */
    public void setDifferentName(int index, String fullname, Predicate predicate) {
        familyTree.getMembers(predicate).get(index).setName(fullname);
    }

    /** установка пола члена семьи по индексу в списке по условию */
    public void setGender(int index, int gender, Predicate predicate) {
        familyTree.getMembers(predicate).get(index).setGender(Gender.values()[gender]);
    }

    /** установка дня рождения члена семьи по индексу в списке по условию */
    public void setBirthday(int index, LocalDate date, Predicate predicate) {
        familyTree.getMembers(predicate).get(index).setBirthday(date);
    }

    /** установка отца члена семьи по индексу в списке по условию */
    public void setFather(int index, int father) {
        Human current = familyTree.getMembers((member) -> true).get(index);
        if (current.getFather() != null) {
            current.getFather().removeChild(current);
        }
        if (father >= 0) {
            Human newFather = familyTree.getMembers((member) -> member.getGender() == Gender.Male).get(father);
            newFather.addChild(current);
            current.setFather(newFather);
        }
    }

    /** установка матери члена семьи по индексу в списке по условию */
    public void setMother(int index, int father) {
        Human current = familyTree.getMembers((member) -> true).get(index);
        if (current.getFather() != null) {
            current.getFather().removeChild(current);
        }
        if (father >= 0) {
            Human newFather = familyTree.getMembers((member) -> member.getGender() == Gender.Male).get(father);
            newFather.addChild(current);
            current.setFather(newFather);
        }
    }
}
