package family_tree.model.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Human extends Intity {

    private String surname;
    private String patronymic;

    private Map<Kinship, List<Human>> relatives;

    public Human(int id, String name, String surName, String patronymic, Gender gender, LocalDate dateOfBirth,
            LocalDate dateOfDeath) {
        super(id, name, gender, dateOfBirth, dateOfDeath);
        this.surname = surName;
        this.patronymic = patronymic;
        this.relatives = new HashMap<>();
        initRelatives();
    }

    public Human(int id, String name, String surName, String patronymic, Gender gender, LocalDate dateOfBirth) {
        this(id, name, surName, patronymic, gender, dateOfBirth, null);
    }

    private void initRelatives() {
        Kinship temp[] = Kinship.values();
        for (int i = 0; i < temp.length; i++) {
            relatives.put(temp[i], new ArrayList<>());
        }
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPatronymic() {
        return this.patronymic;
    }
    
    public List<Human> getParents() {
        if (relatives.get(Kinship.PARENTS) == null) {
            return null;
        }
        return relatives.get(Kinship.PARENTS);
    }
    
    public Human getFather() {
        for (Human human : relatives.get(Kinship.PARENTS)) {
            if (human.getGender() == Gender.MALE) {
                return human;
            }
        }
        return null;
    }
    
    public Human getMother() {
        for (Human human : relatives.get(Kinship.PARENTS)) {
            if (human.getGender() == Gender.FAMALE) {
                return human;
            }
        }
        return null;
    }
    
    public List<Human> getChildren() {
        if (relatives.get(Kinship.CHILDREN) == null) {
            return null;
        }
        return relatives.get(Kinship.CHILDREN);
    }
    
    private Integer getIdMother() {
        if (getMother() != null) {
            return getMother().getId();
        }
        return null;
    }

    private Integer getIdFather() {
        if (getFather() != null) {
            return getFather().getId();
        }
        return null;
    }
    
    private String getInfoHuman() {
        String temp = "";
        if (gender == Gender.MALE)
            temp = "муж";
        else
            temp = "жен";
        
        Formatter formatter = new Formatter();
        formatter.format("%-3s %-10s    %-10s      %-15s   %s   %-3s       %s      %-10s   %-5s , %s",
                         this.id, this.surname,name,patronymic,temp,getAgeHuman(),dateOfBirth,dateOfDeath, 
                         this.getIdMother(),this.getIdFather());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(formatter);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    @Override
    public boolean addKinship(Human human, Kinship kinship) {
        List<Human> temp = relatives.get(kinship);
        if (!temp.contains(human)) {
            temp.add(human);
            if (kinship == Kinship.PARENTS) {
                human.addKinship(this, Kinship.CHILDREN);
            } else {
                human.addKinship(this, Kinship.PARENTS);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Human)) {
            return false;
        }
        Human human = (Human) o;
        return human.getName().equalsIgnoreCase(getName()) && human.getAgeHuman() == getAgeHuman();
    }

    @Override
    public String toString() {
        return this.getInfoHuman();
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public int getAgeHuman() {
        if (dateOfDeath != null)
            return dateOfDeath.getYear() - dateOfBirth.getYear();
        LocalDate temp = LocalDate.now();
        return temp.getYear() - dateOfBirth.getYear();
    }

    @Override
    public boolean removeKinship(Human kinship) {
        for (Kinship itrKinship : relatives.keySet()) {
            if (relatives.get(itrKinship).contains(kinship)) {
                relatives.get(itrKinship).remove(kinship);
            }
        }
        return true;
    }

    @Override
    public List<Human> getKinshipList() {
        List<Human> kinshipList = new ArrayList<>();
        for (Kinship itrKinship : relatives.keySet()) {
            kinshipList.addAll(relatives.get(itrKinship));
        }
        return kinshipList;
    }
}