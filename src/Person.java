import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Person {
    static Integer id = 0;
    private final Integer personId;
    private String name;
    private LocalDate birthday;
    private LocalDate dayOfDeath;
    private Gender gender;
    private Person partner;
    private final ArrayList<Person> parents;
    private final ArrayList<Person> children;
    private final ArrayList<Person> siblings;


    public Person(String name,
                  Person partner,
                  LocalDate birthday,
                  LocalDate dayOfDeath,
                  Gender gender,
                  Person mother,
                  Person father) {
        this.personId = id++;
        this.name = name;
        this.birthday = birthday;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father != null) {
            parents.add(father);
        }
        children = new ArrayList<>();
        this.partner = partner;
        siblings = new ArrayList<>();
    }

    public Person(String name,
                  LocalDate birthday,
                  Person partner,
                  Gender gender,
                  Person mother,
                  Person father) {
        this(name, partner, birthday, null, gender, mother, father);
    }

    public Person(String name,
                  LocalDate birthday,
                  Gender gender,
                  Person mother,
                  Person father) {
        this(name, null, birthday, null, gender, mother, father);
    }

    public Person(String name,
                  LocalDate birthday,
                  Gender gender) {
        this(name, birthday, null, gender, null, null);
    }

    public Person(String name,
                  Person partner,
                  LocalDate birthday,
                  Gender gender) {
        this(name, partner, birthday, null, gender, null, null);
    }

    public Person(String name,
                  LocalDate birthday,
                  LocalDate dayOfDeath,
                  Gender gender) {
        this(name, null, birthday, dayOfDeath, gender, null, null);
    }

    public Person(String name,
                  Person partner,
                  LocalDate birthday,
                  LocalDate dayOfDeath,
                  Gender gender) {
        this(name, partner, birthday, dayOfDeath, gender, null, null);
    }

    public void addChild(Person person) {
        if (person == null) {
            return;
        }
        if (!children.contains(person)) {
            children.add(person);
        }
    }

    public void addMother(Person person) {
        if (person == null) {
            return;
        }
        if (!parents.contains(person)) {
            parents.add(person);
        }
    }

    public void addFather(Person person) {
        if (person == null) {
            return;
        }
        if (!parents.contains(person)) {
            parents.add(person);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.personId, other.personId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer getAge() {
        if (dayOfDeath == null) {
            return getPeriod(birthday, LocalDate.now());
        } else {
            return getPeriod(birthday, dayOfDeath);
        }
    }

    private Integer getPeriod(LocalDate firstDate, LocalDate secondDate) {
        Period diff = Period.between(firstDate, secondDate);
        return diff.getYears();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public Person getFather() {
        for (Person person : parents) {
            if (person.gender == Gender.Male) {
                return person;
            }
        }
        return null;
    }

    public Person getMother() {
        for (Person person : parents) {
            if (person.gender == Gender.Female) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public String getMotherInfo() {
        if (getMother() != null) {
            return getMother().name;
        }
        return "undefined";
    }

    public String getFatherInfo() {
        if (getFather() != null) {
            return getFather().name;
        }
        return "undefined";
    }

    public String getDayOfDeathInfo() {
        if (dayOfDeath != null) {
            return dayOfDeath.toString();
        }
        return "undefined";
    }

    public String getChildrenInfo() {
        if (children.size() == 0) {
            return "undefined";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Person> iterator = children.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().name);
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public Integer getId() {
        return personId;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public String getPartnerInfo() {
        if (getPartner() == null) {
            return "undefined";
        } else {
            return partner.name;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Person> getSiblings() {
        return siblings;
    }

    public void addSibling(Person sibling) {
        if (sibling != null) {
            this.siblings.add(sibling);
        }
    }

    public String getSiblingsInfo() {
        if (siblings.size() == 0) {
            return "undefined";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Person> iterator = siblings.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().name);
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("Age: ");
        stringBuilder.append(getAge());
        stringBuilder.append("\n");
        stringBuilder.append("Partner: ");
        stringBuilder.append(getPartnerInfo());
        stringBuilder.append("\n");
        stringBuilder.append("Gender: ");
        stringBuilder.append(gender.toString());
        stringBuilder.append("\n");
        stringBuilder.append("Birthday: ");
        stringBuilder.append(birthday.toString());
        stringBuilder.append("\n");
        stringBuilder.append("Day of death: ");
        stringBuilder.append(getDayOfDeathInfo());
        stringBuilder.append("\n");
        stringBuilder.append("Mother: ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append("\n");
        stringBuilder.append("Father: ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append("\n");
        stringBuilder.append("Children: ");
        stringBuilder.append(getChildrenInfo());
        stringBuilder.append("\n");
        stringBuilder.append("siblings: ");
        stringBuilder.append(getSiblingsInfo());
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

}