package homeWork.src.member;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class FamilyMember implements Serializable {
    private long id;
    private String name;
    private String surname;
    private String patronymicName;
    private member.Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private FamilyMember mother;
    private FamilyMember father;
    private List<FamilyMember> children;
    private FamilyMember spouse;

    public FamilyMember(String name, String surname, String patronymicName, member.Gender gender,
                        LocalDate birthDate, LocalDate deathDate,
                        FamilyMember father, FamilyMember mother) {
        id = -1;
        this.name = name;
        this.surname = surname;
        this.patronymicName = patronymicName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
//        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        this.mother = null;
//        this.father = null;
    }

    public FamilyMember(String name, String surname, String patronymicName, member.Gender gender,
                        LocalDate birthDate){
        this(name, surname, patronymicName, gender, birthDate, null, null, null);
    }

    public FamilyMember(String name, String surname, String patronymicName, member.Gender gender,
                        LocalDate birthDate, FamilyMember father, FamilyMember mother){
        this(name, surname, patronymicName, gender, birthDate, null, father, mother);
    }

    public FamilyMember(String name, String surname, String patronymicName, member.Gender gender,
                        LocalDate birthDate, LocalDate deathDate) {
        this(name, surname, patronymicName, gender, birthDate, deathDate, null, null);
    }

    public boolean addChild(FamilyMember child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(FamilyMember parent){
        if(parent.getGender().equals(member.Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(member.Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    public void setMother(FamilyMember mother){
        this.mother = mother;
    }

    public void setFather(FamilyMember father){
        this.father = father;
    }

    public FamilyMember getMother(){return mother;}
    public FamilyMember getFather(){return father;}

    public List<FamilyMember> getParents(){
        List<FamilyMember> myList = new ArrayList<>(2);
        if(father != null){
            myList.add(father);
        }
        if(mother != null){
            myList.add(mother);
        }
        return myList;
    }

    public int getAge(){
        if(deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(FamilyMember spouse){this.spouse = spouse;}

    public FamilyMember getSpouse(){return spouse;}

    public String getName(){
        return name + " " + surname + " " + patronymicName;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){return id;}

    public LocalDate getBirthDate(){return  birthDate;}

    public LocalDate getDeathDate(){return deathDate;}

    public List<FamilyMember> getChildren(){return children;}

    public void setBirthDate(LocalDate birthDate){this.birthDate = birthDate;}

    public void setDeathDate(LocalDate deathDate){this.deathDate = deathDate;}

    public member.Gender getGender(){return gender;}

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof FamilyMember)){
            return false;
        }
        FamilyMember familyMember = (FamilyMember) obj;
        return familyMember.getId() == getId();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo () {
        StringBuilder sb = new StringBuilder();
        sb.append(id)
                .append(", ")
                .append(surname)
                .append(" ")
                .append(name)
                .append(" ")
                .append(patronymicName)
                .append(", ")
                .append(getGender())
                .append(", life years: ")
                .append(birthDate);

        if(deathDate != null){
            sb.append(" - ").append(deathDate);
        } else {
            sb.append(" - ").append("current");
        }
        sb.append(", ")
                .append(getSposeInfo())
                .append(", ")
                .append(getMotherInfo())
                .append(", ")
                .append(getFatherInfo())
                .append(", ")
                .append(getChildrenInfo());
        return sb.toString();
    }

    public String getSposeInfo(){
        String result = "spouse: ";
        if(spouse == null){
            result+= "no";
        } else {
            result+= spouse.getName();
        }
        return result;
    }

    public String getMotherInfo(){
        String result = "mother: ";
        if(mother != null){
            result+= mother.getName();
        } else {
            result+= "unknown";
        }
        return result;
    }

    public String getFatherInfo(){
        String result = "father: ";
        if(father != null){
            result+= father.getName();
        } else {
            result+= "unknown";
        }
        return result;
    }

    public String getChildrenInfo(){
        StringBuilder result = new StringBuilder();
        result.append("children: ");
        if(!children.isEmpty()) {
            for (int i = 1; i < children.size(); i++) {
                result.append(", ")
                        .append(children.get(i).getName());
            }
        } else {
            result.append("unknown");
        }
        return result.toString();
    }
}