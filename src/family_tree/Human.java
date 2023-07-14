package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Human implements Serializable{
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    // private List<Human> wifes;
    // private List<Human> husbands;
    private List<Human> spouses;

    public Human (String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
    Human father, Human mother, Human wife, Human husband) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();

        spouses = new ArrayList<>();
        if (wife != null) {
            spouses.add(wife);
        }
        if (husband != null) {
            spouses.add(husband);
        }

        // wifes = new ArrayList<>();
        // if (wife != null) {
        //     wifes.add(wife);
        // }
        // husbands = new ArrayList<>();
        // if (husband != null) {
        //     husbands.add(husband);
        // }
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this (name, gender, birthDate, null, null, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human wife) {
        this (name, gender, birthDate, null, null, null, wife);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this (name, gender, birthDate, null, father, mother, null, null);
    }    

    public Human(String name, Gender gender, LocalDate birthDate,
    Human father, Human mother, Human wife, Human husband) {
        this (name, gender, birthDate, null, father, mother, wife, husband);
    }


    public boolean addChild (Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {return name;}

    public boolean addParents (Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public boolean addSpouse (Human spouse) {
        if (!spouses.contains(spouse)) {
            spouses.add(spouse);
            return true;
        }
        return false;
    }

    // public boolean addWifes (Human wife) {
    //     if (!wifes.contains(wife)) {
    //         wifes.add(wife);
    //         return true;
    //     }
    //     return false;
    // }

    // public boolean addHusbands (Human husband) {
    //     if (!husbands.contains(husband)) {
    //         husbands.add(husband);
    //         return true;
    //     }
    //     return false;
    // }

    public LocalDate getBirthDate() {return birthDate;}
    public LocalDate getDeathDate() {return deathDate;}

    public Human getFather() {
        for (Human parent: parents) {
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent: parents) {
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public List<Human> getParents() {return parents;}
    public List<Human> getChildren() {return children;}

    public Human getWife() {
        for (Human spouse: spouses) {
            if (spouse.getGender() == Gender.Female){
                return spouse;
            }
        }
        return null;
    }

    public Human getHusband() {
        for (Human spouse: spouses) {
            if (spouse.getGender() == Gender.Male){
                return spouse;
            }
        }
        return null;
    }

    // public Human getWife() {
    //     for (Human wife: wifes) {
    //         if (wife.getGender() == Gender.Female){
    //             return wife;
    //         }
    //     }
    //     return null;
    // }

    // public Human getHusband() {
    //     for (Human husband: husbands) {
    //         if (husband.getGender() == Gender.Male){
    //             return husband;
    //         }
    //     }
    //     return null;
    // }

    // public List<Human> getWifes() {return wifes;}
    // public List<Human> getHusbands() {return husbands;}
    public List<Human> getSpouse() {return spouses;}

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

    public Gender getGender() {return gender;}

    @Override
    public String toString() {return getInfo();}

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        if (getGender() == Gender.Male) { 
            sb.append(getWifeInfo());
            // sb.append(", ");
        }
        if (getGender() == Gender.Female) { sb.append(getHusbandInfo()); }
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public String getWifeInfo(){
        String res = "жена: ";
        Human wife = getWife();
        if (wife != null) {
            res += wife.getName();
        } else {
            res += "отсутствует";
        }
        return res;
    }

    public String getHusbandInfo(){
        String res = "муж: ";
        Human husband = getHusband();
        if (husband != null) {
            res += husband.getName();
        } else {
            res += "отсутствует";
        }
        return res;
    }


    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod (LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
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
        return human.getName().equals(getName());
    }


}