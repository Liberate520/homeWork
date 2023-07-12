package family_tree.human;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.HashMap;



public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String firstName, secondName, fathersName;
    private LocalDate dateOfBirth, dateOfDeath;
    private boolean alive;
    private Gender gender;
    private HashMap<Human,Parent_Type> parents;
    private boolean hasBioMother;
    private boolean hasBioFather;
    private Human spouse;
    private boolean married;
    private HashMap<Human, Child_type> children;

    public Human(String firstName, String secondName, String fathersName, LocalDate dateOfBirth,
                 LocalDate dateOfDeath, Gender gender) {
        id = -1;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.parents = new HashMap<>();
        this.children = new HashMap<>();
        this.alive = true;
        this.hasBioFather = false;
        this.hasBioMother = false;
        this.married = false;
    }
    public Human(String firstName, String secondName, String fathersName, LocalDate dateOfBirth, Gender gender) {
        this(firstName, secondName, fathersName, dateOfBirth, null, gender);
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getFullName(){
        return this.secondName + " " + this.firstName + " " + this.fathersName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public Gender getGender(){
        return this.gender;
    }

    public HashMap<Human, Parent_Type> getParents() {
        return parents;
    }

    public HashMap<Human, Child_type> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public Boolean isMarried(){
        return this.married;
    }

    public void setSecondName(String newSecondName){
        this.secondName = newSecondName;
    }

    public void addParent(Human parent, Parent_Type parentType){
        if(!this.parents.containsKey(parent)) {
            if (parentType.equals(Parent_Type.Foster_Mother)
                    || parentType.equals(Parent_Type.Foster_Father)) {
                this.parents.put(parent, parentType);
                if(this.gender.equals(Gender.male)) parent.addChild(this, Child_type.Foster_Son);
                else parent.addChild(this, Child_type.Foster_Daughter);
            }
            if ((hasBioFather == false) && (parentType.equals(Parent_Type.Biological_Father))) {
                this.parents.put(parent, parentType);
                this.hasBioFather = true;
                if(this.gender.equals(Gender.male)) parent.addChild(this, Child_type.Biological_Son);
                else parent.addChild(this, Child_type.Biological_Daughter);
            }
            if ((hasBioMother == false) && (parentType.equals(Parent_Type.Biological_Mother))) {
                this.parents.put(parent, parentType);
                this.hasBioMother = true;
                if(this.gender.equals(Gender.male)) parent.addChild(this, Child_type.Biological_Son);
                else parent.addChild(this, Child_type.Biological_Daughter);
            }
        }
    }

    public void setSpouse(Human spouse){
        this.spouse = spouse;
        this.married = true;
    }

    public void addChild(Human child, Child_type childType){
        if(!this.children.containsKey(child)) {
            this.children.put(child, childType);
            if (childType.equals(Child_type.Foster_Son) || childType.equals(Child_type.Foster_Daughter)) {
                if (this.gender.equals(Gender.male)) {
                    child.addParent(Human.this, Parent_Type.Foster_Father);
                } else {
                    child.addParent(Human.this, Parent_Type.Foster_Mother);
                }
            } else {
                if (this.gender.equals(Gender.male)) {
                    child.addParent(Human.this, Parent_Type.Biological_Father);
                } else {
                    child.addParent(Human.this, Parent_Type.Biological_Mother);
                }
            }
        }
    }

    public void removeSpouse(){
        this.spouse = null;
        this.married = false;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
        this.alive = false;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public int getAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period difference;
        int age = 0;
        if (!(this.dateOfDeath == null))
        {
            difference = Period.between(dateOfBirth, dateOfDeath);
        }
        else{
            difference = Period.between(dateOfBirth, LocalDate.now());
        }
        age = difference.getYears();
        return age;
    }

    @Override
    public String toString() {
        return infoFormat();
    }

    public String infoFormat(){
        StringBuilder sb = new StringBuilder();
        sb.append(nameInfo());
        sb.append(ageInfo());
        sb.append(genderInfo());
        sb.append(parentsInfo());
        sb.append(marriageInfo());
        sb.append(childrenInfo());
        return sb.toString();
    }

    public String nameInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия: ").append(this.secondName).append("\n");
        sb.append("Имя: ").append(this.firstName).append("\n");
        sb.append("Отчество: ").append(this.fathersName).append("\n");
        return sb.toString();
    }

    public String ageInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Дата рождения: ").append(this.dateOfBirth).append("\n");
        if(this.alive){
            sb.append("Возраст: ").append(getAge(this.dateOfBirth, null)).append(" лет").append("\n");
        }
        else{
            sb.append("Дата смерти: ").append(this.dateOfDeath).append("\n");
        }
        return sb.toString();
    }

    public String genderInfo(){
        StringBuilder sb = new StringBuilder();
        if(this.gender.equals(Gender.male)){
            sb.append("Пол: мужской").append("\n");
        }
        else{
            sb.append("Пол: женский").append("\n");
        }
        return sb.toString();
    }

    public String parentsInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human parent : this.parents.keySet()) {
            if(this.parents.get(parent).equals(Parent_Type.Biological_Mother)) sb.append("Родная мать: ").append(parent.getFullName()).append("\n");
            else if(this.parents.get(parent).equals(Parent_Type.Biological_Father)) sb.append("Родной отец: ").append(parent.getFullName()).append("\n");
            else if(this.parents.get(parent).equals(Parent_Type.Foster_Father)) sb.append("Приемный отец: ").append(parent.getFullName()).append("\n");
            else if(this.parents.get(parent).equals(Parent_Type.Foster_Mother)) sb.append("Приемная мать: ").append(parent.getFullName()).append("\n");
        }
        return sb.toString();
    }

    public String marriageInfo(){
        StringBuilder sb = new StringBuilder();
        if (this.married){
            if(this.spouse.gender.equals(Gender.male)) sb.append("Муж: ").append(spouse.getFullName()).append("\n");
            else sb.append("Жена: ").append(spouse.getFullName()).append("\n");
        }
        else {
            if(this.gender.equals(Gender.male)) sb.append("Не женат").append("\n");
            else sb.append("Не замужем").append("\n");
        }
        return sb.toString();
    }

    public String childrenInfo(){
        StringBuilder sb = new StringBuilder();
        if (this.children.isEmpty()){
            sb.append("Детей нет").append("\n");
        }
        else {
            for(Human child : this.children.keySet()){
                if(this.children.get(child).equals(Child_type.Biological_Son)) sb.append("Родной сын: ").append(child.getFullName()).append("\n");
                else if(this.children.get(child).equals(Child_type.Biological_Daughter)) sb.append("Родная дочь: ").append(child.getFullName()).append("\n");
                else if(this.children.get(child).equals(Child_type.Foster_Son)) sb.append("Приемный сын: ").append(child.getFullName()).append("\n");
                else if(this.children.get(child).equals(Child_type.Foster_Daughter)) sb.append("Приемная дочь: ").append(child.getFullName()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id;
    }

    @Override
    public int compareTo(Human o) {
        return 0;
    }
}
