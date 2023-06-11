package model.member;

import model.family.Family;
import model.member.comparator.MemberComparator;
import model.member.comparator.MemberComparatorByName;
import java.io.Serializable;
import java.util.*;

public abstract class Member implements Serializable, Comparable<Member> {
    private String fullName;
    private Gender gender;
    private Calendar birthDate;
    private Calendar deathDate;
    private Set<Family<? extends Member>> families;
    private Map<Connection, Set<Member>> connections;

    public Member(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.families = new HashSet<>();
        if (family != null) this.families.add(family);
        connections = new HashMap<>();
    }

    /**
     * Add to Family connection
     * @param family which model.family to connect
     */
    public void addFamily(Family<? extends Member> family) {
        this.families.add(family);
    }

    /**
     * Add 'connection' to 'other model.member'
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(fullName, member.fullName) && gender == member.gender && Objects.equals(birthDate, member.birthDate) && Objects.equals(deathDate, member.deathDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, gender, birthDate, deathDate);
    }

    protected String getFancyDate(Calendar calendar) {
        return String.format("%02d.%02d.%d",
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
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
