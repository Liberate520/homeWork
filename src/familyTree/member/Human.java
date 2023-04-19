package familyTree.member;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember, Serializable {

    private  int id;
    private String name;
    private String surname;
    private String dateBirth;
    private String dateDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> childList;
    private List<Human> siblings;
    private List<Human> grandparents;
    private List<Human> grandchildrens;

    public Human(int id, String name, String surname, Gender gender, String dateBirth, Human father, Human mother) {
        this.name = name;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.id = id;
        this.father = father;
        this.mother = mother;
        this.childList = new ArrayList<>();
        this.siblings = new ArrayList<>();

    }
    public Human() {
        this.id = 0;
        this.name = "unknown";
        this.surname = "unknown";
        this.dateBirth = "unknown";
        this.dateDeath = "unknown";
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public String getBirthDate() {
        return dateBirth;
    }
    @Override
    public void setBirthDate(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    @Override
    public String getDeathDate() {
        return dateDeath;
    }
    @Override
    public void setDeathDate(String dateDeath) {
        this.dateDeath = dateDeath;
    }
    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }
//
//    @Override
//    public FamilyMember getParent() {
//        return parent;
//    }
//    @Override
//    public void setParent(FamilyMember parent) {
//        this.parent = parent;
//    }

    @Override
    public List<Human> getChildren() {
        return childList;
    }

    @Override
    public List<Human> getSiblings() {
        return siblings;
    }
    @Override
    public List<Human> getGrandparents() {
        List<Human> grandparents = new ArrayList<>();
        if (father != null) {
            if (father.getFather() != null) {
                grandparents.add(father.getFather());
            }
            if (father.getMother() != null) {
                grandparents.add(father.getMother());
            }
        }
        if (mother != null) {
            if (mother.getFather() != null) {
                grandparents.add(mother.getFather());
            }
            if (mother.getMother() != null) {
                grandparents.add(mother.getMother());
            }
        }
        return grandparents;
    }

    public void setGrandparents(List<Human> grandparents) {
        this.grandparents = grandparents;
    }

    @Override
    public List<Human> getGrandchildren() {
        List<Human> grandchildrens = new ArrayList<>();
        for (Human child : grandchildrens) {
            grandchildrens.addAll(child.getChildren());
        }
        return grandchildrens;
    }

//    public String getDateDeath() {
//        return dateDeath;
//    }

    public List<Human> getChildList() {
        return childList;
    }


    public int getAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(dateBirth, formatter);
        return Period.between(date, currentDate).getYears();
    }

//    public int getAge() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
//        LocalDate currentDate = LocalDate.now();
//        LocalDate date = LocalDate.parse(dateBirth, formatter);
//        LocalDate endDate = LocalDate.parse(dateDeath, formatter);
//        if (getDeathDate() == null) {
//            return Period.between(date, currentDate).getYears();
//        } else {
//            return Period.between(date, endDate).getYears();
//        }
//    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumChildren() {
        return childList.size();
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }
    public String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.name = name;
        }
    }
    public void setSurname(String surname) {
        if (surname.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.surname = surname;
        }
    }
    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setDateBirth(String dateBirth) {
        if (dateBirth.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.dateBirth = dateBirth;
        }
    }
    public void setDateDeath(String dateDeath) {
        if (dateDeath.isEmpty()) {
            System.out.println("Поле не должно быть пустым");
        } else {
            this.dateDeath = dateDeath;
        }
    }
//    public String getMaidenName() {
//        return this.maidenName;
//    }
//    public void setMaidenName(String maidenName) {
//        if (maidenName.trim().matches(nameRegex)) {
//            if (this.gender == Gender.Male) {
//                this.maidenName = maidenName.trim();
//            } else {
//                throw new IllegalArgumentException("Девичья фамилия для женщин");
//            }
//        } else if (maidenName.isEmpty()) {
//            this.maidenName = "";
//        } else {
//            throw new IllegalArgumentException("Неверно задана фамилия");
//        }
//
//    }
    public void setChildList(List<Human> childList) {
        this.childList = childList;
    }

//    public void addChild(Human child) {
//        if (!childList.contains(child)) {
//            childList.add(child);
//        } else  {
//            System.out.println("Ребенок уже есть в списке");
//        }
//    }

    public void addChild(Human child) {
        if (child != null && !childList.contains(child)) {
            childList.add(child);
            if (this.gender == Gender.Male) {
                child.setFather(this);
            } else if (this.gender == Gender.Female) {
                child.setMother(this);
            } else {
                System.out.println("Ребенок уже есть в списке");
            }
        }
    }
    public void addParent(Human parent) {
        if (parent.getGender() == Gender.Male) {
            this.father = parent;
        } else {
            this.mother = parent;
        }
    }

    public void addSibling(Human sibling) {
        if (!siblings.contains(sibling)) {
            siblings.add(sibling);
            sibling.addSibling(this);
        }
    }

    public void addGrandparent(Human grandparent) {
        grandparents.add(grandparent);
        grandparent.addGrandchild(this);
    }

    public void addGrandchild(Human grandchild) {
        if (!grandchildrens.contains(grandchild)) {
            grandchildrens.add(grandchild);
            grandchild.addGrandparent(this);
        }
    }

//    public void addSiblings(Human newborn, Human mother, Human father) {
//        if (father.childList.size() > 1) {
//            for (Human human: father.childList) {
//                if (human != newborn) {
//                newborn.siblings.add(human);
//                human.siblings.add(newborn);
//            }
//        }
//    }

    public void addNewbornToParents(Human father, Human mother) {
        father.childList.add(this);
        mother.childList.add(this);

    }

    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName()).append(" ")
                .append(surname).append(", ")
                .append(getAge()).append(" лет. ")
                .append(getFatherInfo()).append(", ")
                .append(getMotherInfo()).append(", ")
                .append(getChildrenInfo()).append(getSiblingsInfo());
        return builder.toString();
    }
    public String getChildrenInfo() {
        StringBuilder childs = new StringBuilder();
        childs.append("\nдети: ");
        if (childList.size() != 0){
            childs.append(childList.get(0).getName());
            for (int i = 1; i < childList.size(); i++) {
                childs.append(", ");
                childs.append(childList.get(i).getName());
            }
        } else {
            childs.append("без детей");
        }
        return childs.toString();
    }

    public String getSiblingsInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nбратья и сестры: ");
        if (siblings.size() != 0){
            builder.append(siblings.get(0).getName());
            for (int i = 1; i < siblings.size(); i++) {
                builder.append(", ");
                builder.append(siblings.get(i).getName());
            }
        } else {
            builder.append("братьев и сестер нет");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return this.name +  " " + this.surname + " " +
                "Пол: " + getGender() + " " +
                "Возраст: " + getAge() + " лет " + "( " + getBirthDate() + " )" + "\n";
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
