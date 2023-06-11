package model.dog;

import model.family.Family;
import model.member.Gender;
import model.member.Member;
import java.util.*;

public class Dog extends Member{
    public Dog(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family) {
        super(fullName, gender, birthDate, deathDate, family);
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
}