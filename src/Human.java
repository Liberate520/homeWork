import java.time.LocalDate;
import java.util.*;

public class Human {
    private String firstName, secondName;
    private Gender gender;
    private Map<Relationship, ArrayList<Human>> family;
    private LocalDate birthDate;


    public Human(String firstName, String secondName, Gender gender,
                 int birthday, int birthmonth, int birthyear) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = LocalDate.of(birthyear, birthmonth, birthday);
        this.family = new LinkedHashMap<>();
    }

    public void setRelationship(Relationship rs, Human human) {
        ArrayList<Human> relatives = new ArrayList<>(
                Collections.singletonList(human));
        if (rs.equals(Relationship.Mother) &&
                family.containsKey(Relationship.Mother) ||
                rs.equals(Relationship.Father) &&
                        family.containsKey(Relationship.Father)) {
            System.out.println("Мама и папа могут быть только одни!");
        } else if (rs.equals(Relationship.Grandmothers) &&
                family.get(Relationship.Grandmothers).size() == 2 ||
                rs.equals(Relationship.Grandfathers) &&
                        family.get(Relationship.Grandfathers).size() == 2) {
            System.out.println("Бабушек и дедушек может быть только двое!");
        } else {
            if (family.containsKey(rs)) {
                family.get(rs).add(human);
            } else {
                family.put(rs, relatives);
            }
        }
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    public boolean isAnOrhan() {
        return !(family.containsKey(Relationship.Mother) &&
                family.containsKey(Relationship.Father));
    }

    public Gender getGender() {
        return gender;
    }

    public void getAge() {
        LocalDate now_date = LocalDate.now();
        int age = now_date.getYear() - this.birthDate.getYear();
        if (now_date.getMonthValue() < this.birthDate.getMonthValue() ||
                now_date.getMonthValue() == this.birthDate.getMonthValue() &&
                        now_date.getDayOfMonth() <
                                this.birthDate.getDayOfMonth()) {
            age--;
        }
        System.out.println(this.getFullName() + " " + age + " лет");
    }

    public Map<Relationship, ArrayList<Human>> getFamily() {
        return family;
    }
}
