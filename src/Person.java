import java.util.ArrayList;

public class Person {
    private static int idCount;
    private int id;
    private String name;
    private String sex;
    private ArrayList<Person> spouse;
    private int birthDate;
    private int dateOfDeath;
    private String father;
    private String mother;
    private ArrayList<Person> childrens;

    public Person(String name, String sex, int birthDate, int dateOfDeath) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.dateOfDeath = dateOfDeath;
        this.id = idCount + 1;
        idCount++;
    }
    public Person(String name, String sex, int birthDate) {
        this(name, sex, birthDate, -1);
    }
    public Person(String name, String sex) {
        this(name, sex, -1, -1);
    }
    public Person() {
        this(null, null, -1, -1);
    }

    //    SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void sex(String sex) {
        this.sex = sex;
    }
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    public void setDateOfDeath(int dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }


    //    ADD SPOUSE
    public void addSpouse(Person person) {
        if (this.spouse == null) {this.spouse = new ArrayList<>();};
        this.spouse.add(person);
    }

    //    ADD PARENTS
    public void addParent(Person parent) {
        if(parent.sex != null) {
            if(parent.sex == "мужской") {
                this.father = parent.name;
            } else {this.mother = parent.name;}
        }
    }

    //    ADD CHILDRENS
    public void addChildren(Person child) {
        if (this.childrens == null) {this.childrens = new ArrayList<>();};
        this.childrens.add(child);
    }

    //    GET SPOUSE
    public ArrayList<Person> getSpouse() {
        return this.spouse;
    }
    //    GET SPOUSE
    public ArrayList<Person> getChildrens() {
        return this.childrens;
    }

    //    GETTTERS
    public String getName() {
        return this.name;
    }
    public String getFather() {
        return this.father;
    }
    public String getMother() {
        return this.mother;
    }
    public int getBirthDate() {
        return this.birthDate;
    }
    public int getDateOfDeath() {
        return this.dateOfDeath;
    }


    @Override
    public String toString() {
        StringBuilder value = new StringBuilder();
        value.append("\nPerson ID: ").append(this.id);
        if (this.name != null) {value.append("\nName: ").append(this.name);}
        if (this.sex != null) {value.append("\nSex: ").append(this.sex);}
        if (this.spouse != null) {
            int tmp = 1;
            for (Person person : this.spouse) {
                if (this.spouse.size() == 1) {
                    value.append("\nSpouse: ").append(person.name);
                } else {
                    value.append("\nSpouse ").append(tmp).append(": ").append(person.name);
                    tmp++;
                }
            }
        }
        if (this.birthDate != -1) {value.append("\nDate of birth: ").append(this.birthDate);}
        if (this.dateOfDeath != -1) {value.append("\nDate of death: ").append(this.dateOfDeath);}
        if (this.father != null) {value.append("\nFather: ").append(this.father);}
        if (this.mother != null) {value.append("\nMother: ").append(this.mother);}
        if (this.childrens != null) {
            int tmp = 1;
            for (Person person : this.childrens) {
                if (this.childrens.size() == 1) {
                    value.append("\nChild: ").append(person.name);
                } else {
                    value.append("\nChild ").append(tmp).append(": ").append(person.name);
                    tmp++;
                }
            }
        }
        return value.toString();
    }
}