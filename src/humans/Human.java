package humans;

import family_tree.FamilyTreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public class Human implements FamilyTreeItem<Human> {
    private Integer id;
    private String name;
    private Gender gender;
    private LocalDate dateBirthday;
    private LocalDate dateDeath;
    private Human mother;
    private Human father;
    private List<Human> childrenList;
    private LiveStatus liveStatus;

    public Human(Integer id,
                 String name,
                 Gender gender,
                 LocalDate dateBirthday,
                 LocalDate dateDeath,
                 Human father,
                 Human mother) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateBirthday = dateBirthday;
        this.dateDeath = dateDeath;
        this.father = father;
        this.mother = mother;
        childrenList = new ArrayList<>();
    }

    public Human(Integer id,
                 String name,
                 Gender gender,
                 LocalDate dateBirthday) {
        this(id, name, gender, dateBirthday, null, null, null);
    }

    public Human(Integer id,
                 String name,
                 Gender gender,
                 LocalDate dateBirthday,
                 LocalDate dateDeath) {
        this(id, name, gender, dateBirthday, dateDeath, null, null);
    }

    public Human(Integer id,
                 String name,
                 Gender gender,
                 LocalDate dateBirthday,
                 Human father,
                 Human mother) {
        this(id, name, gender, dateBirthday, null, father, mother);
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBirthday() {
        return dateBirthday;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public Integer getAge() {
        return setAgeHuman();
    }

    private Integer setAgeHuman() {
        if (!(dateDeath == null)) {
            liveStatus = LiveStatus.Dead;
            return Period.between(dateBirthday, dateDeath).getYears();
        } else {
            liveStatus = LiveStatus.Live;
            return Period.between(dateBirthday, LocalDate.now()).getYears();
        }
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return childrenList;
    }

    public void setChildren(Human human) {
        if (!childrenList.contains(human)) {
            childrenList.add(human);
        }
    }

    public List<Human> getParents() {
        List<Human> parentsList = new ArrayList<>(2);
        if (father != null) {
            parentsList.add(father);
        }
        if (mother != null) {
            parentsList.add(mother);
        }
        return parentsList;
    }

    public StringBuilder getChildrenInfo() {
        StringBuilder infoChild = new StringBuilder();
        infoChild.append("children: ");
        if (!childrenList.isEmpty()) {
            infoChild.append(childrenList.get(0).getName());
            for (int i = 1; i < childrenList.size(); i++) {
                infoChild.append(", ")
                        .append(childrenList.get(i).getName());
            }
        } else infoChild.append("отсутствуют");
        return infoChild;
    }

    public StringBuilder getNameMother() {
        StringBuilder infoMother = new StringBuilder();
        infoMother.append("mother: ");
        if (mother != null) {
            infoMother.append(mother.getName());
        } else {
            infoMother.append("не известно");
        }
        return infoMother;
    }

    public StringBuilder getNameFather() {
        StringBuilder infoFather = new StringBuilder();
        infoFather.append("father: ");
        if (mother != null) {
            infoFather.append(father.getName());
        } else {
            infoFather.append("не известно");
        }
        return infoFather;
    }


    private StringBuilder humanInfo() {
        StringBuilder humanInfo = new StringBuilder();
        humanInfo.append("\nid: ")
                .append(id)
                .append(", name: ")
                .append(name)
                .append(", gender: ")
                .append(gender)
                .append(", birth date: ")
                .append(getDateBirthday())
                .append(", age: ")
                .append(getAge())
                .append(", status: ")
                .append(liveStatus)
                .append(", ")
                .append(getChildrenInfo())
                .append(", ")
                .append(getNameMother())
                .append(", ")
                .append(getNameFather());
        return humanInfo;
    }


    @Override
    public String toString() {
        return humanInfo().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId().equals(getId());
    }
}


