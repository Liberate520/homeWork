package dog;

import family.Family;
import member.Connection;
import member.Gender;
import member.Member;
import member.comparator.MemberComparator;
import member.comparator.MemberComparatorByName;

import java.util.*;

public class Dog implements Member{
    private String fullName;
    private Gender gender;
    private Calendar birthDate;
    private Calendar deathDate;
    private Set<Family<? extends Member>> families;
    private Map<Connection, Set<Member>> connections;

    public Dog(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.families = new HashSet<>();
        if (family != null) this.families.add(family);
        connections = new HashMap<Connection, Set<Member>>();
    }
    public Dog(String fullName, Gender gender, Calendar birthDate, Calendar deathDate) {
        this(fullName, gender, birthDate, deathDate, null);
    }
    public Dog(String fullName, Gender gender, Calendar birthDate, Family<Member> family) {
        this(fullName, gender, birthDate, null, family);
    }
    public Dog(String fullName, Gender gender, Family<Member> family) {
        this(fullName, gender, null, null, family);
    }
    public Dog(String fullName, Gender gender) {
        this(fullName, gender, null, null, null);
    }

    /**
     * Add to Family connection
     * @param family which family to connect
     */
    public void addFamily(Family<? extends Member> family) {
        this.families.add(family);
    }

    /**
     * Add 'connection' to 'member'
     */
    public void addConnection(Member member, Connection connection) {
        if (!connections.containsKey(connection)) {
            connections.put(connection, new HashSet<>());
        }
        connections.get(connection).add(member);
    }

    public String getName() {
        return fullName;
    }

    public void changeName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public Calendar getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Calendar deathDate) {
        this.deathDate = deathDate;
    }

    public Set<? extends Member> getRelatedMembers(Connection connection) {
        return connections.get(connection);
    }

    public Set<Family<? extends Member>> getFamilies() {
        return families;
    }

    private String getFancyDate(Calendar calendar) {
        return String.format("%02d.%02d.%d",
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(fullName, dog.fullName) && gender == dog.gender && Objects.equals(birthDate, dog.birthDate) && Objects.equals(deathDate, dog.deathDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, gender, birthDate, deathDate);
    }

    @Override
    public String toString() {
        if (fullName == null && gender == null && birthDate == null && deathDate == null) return "Нет данных";
        String datesString;
        if (birthDate == null) {
            datesString = "Неизвестно";
        } else {
            if (deathDate == null) {
                datesString = getFancyDate(birthDate);
            } else {
                datesString = String.format("%s - %s", getFancyDate(birthDate), getFancyDate(deathDate));
            }
        }
        return String.format("%s, %s", fullName, datesString);
    }

    @Override
    public int compareTo(Member otherMember) {
        MemberComparator<Member> comparator = new MemberComparatorByName<>();
        return comparator.compare(this, otherMember);
    }
}
