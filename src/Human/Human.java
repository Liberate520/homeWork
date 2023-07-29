package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import Enum.Gender;

public class Human implements Serializable {

    // #region Fields

    private List<Human> cildrenList;
    private LocalDate dataOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private int idHuman;
    private String name;
    private List<Human> parentsList;

    // #endregion

    // #region Constructor

    public Human(int id, String name, Gender gender, LocalDate dataOfBirth, LocalDate dataOfDeath, Human father,
            Human mother) {
        this.idHuman = -1;
        this.name = name;
        this.gender = gender;
        this.dataOfBirth = dataOfBirth;
        this.dateOfDeath = dataOfDeath;
        cildrenList = new ArrayList<>();
        parentsList = new ArrayList<>();
        if (father != null) {
            parentsList.add(father);
        }
        if (mother != null) {
            parentsList.add(mother);
        }
    }

    public Human(int id, String name, Gender gender, LocalDate dataOfBirth, Human father, Human mother) {
        this(id, name, gender, dataOfBirth, null, father, mother);
    }

    public Human(int id, String name, Gender gender, LocalDate dataOfBirth) {
        this(id, name, gender, dataOfBirth, null, null, null);
    }

    // #endregion

    // #region Get

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dataOfBirth, LocalDate.now());
        } else {
            return getPeriod(dataOfBirth, dateOfDeath);
        }
    }

    public List<Human> getChildren() {
        return cildrenList;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (cildrenList.size() != 0) {
            res.append(cildrenList.get(0).getName());
            for (int i = 1; i < cildrenList.size(); i++) {
                res.append(", ");
                res.append(cildrenList.get(i).getName());
            }
        } else {
            res.append("информация отсутствует");
        }
        return res.toString();
    }

    public Human getFather() {
        for (Human parent : parentsList) {
            if (parent.getGender() == Gender.male) {
                return parent;
            }
        }
        return null;
    }

    public String getDataOfBirth() {
        return dataOfBirth.toString();
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res = res + father.getName();
        } else {
            res = res + "информация отсутствует";
        }
        return res;
    }

    private Gender getGender() {
        return gender;
    }

    public int getId() {
        return idHuman;
    }

    private String getGenderInfo() {
        String res = " пол: ";
        Gender gender = getGender();
        if (gender == Gender.male) {
            res += "мужской";
        } else if (gender == Gender.female) {
            res += "женский";
        }
        return res;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(idHuman);
        info.append(", имя: ");
        info.append(name);
        info.append(", ");
        info.append(getGenderInfo());
        info.append(", возраст: ");
        info.append(getAge());
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getChildrenInfo());
        return info.toString();
    }

    public Human getMother() {
        for (Human parent : parentsList) {
            // System.out.print(parent);

            if (parent.getGender() == Gender.female) {
                // System.out.println(parent);
                return parent;
            }
        }
        return null;
    }

    public String getMotherInfo() {
        String res = "мама: ";
        Human mother = getMother();
        if (mother != null) {
            res = res + mother.getName();
        } else {
            res = res + "информация отсутствует";
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public List<Human> getParents() {
        return parentsList;
    }

    private int getPeriod(LocalDate dataStart, LocalDate dataEnd) {
        Period diff = Period.between(dataStart, dataEnd);
        return diff.getYears();
    }
    // #endregion

    // #region Set

    public void setId(int idHuman) {
        this.idHuman = idHuman;
    }
    // #endregion

    // #region Metods

    public boolean addChild(Human child) {
        if (!cildrenList.contains(child)) {
            cildrenList.add(child);
            return true;
        }
        return false;

    }

    public boolean addParent(Human parent) {
        if (!parentsList.contains(parent)) {
            parentsList.add(parent);
            return true;
        }
        return false;

    }
    // #endregion

    // #region Override
    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Human)) {
            return false;
        }
        Human human = (Human) object;
        return human.getId() == getId();
    }
    // #endregion

}
