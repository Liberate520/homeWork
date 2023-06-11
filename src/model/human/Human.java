package model.human;

import model.family.Family;
import model.member.Gender;
import model.member.Member;
import java.util.*;

public class Human extends Member {
    public Human(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family) {
        super(fullName, gender, birthDate, deathDate, family);
    }
    public Human(String fullName, Gender gender, Calendar birthDate, Calendar deathDate) {
        this(fullName, gender, birthDate, deathDate, null);
    }
    public Human(String fullName, Gender gender, Calendar birthDate, Family<Member> family) {
        this(fullName, gender, birthDate, null, family);
    }
    public Human(String fullName, Gender gender, Family<Member> family) {
        this(fullName, gender, null, null, family);
    }
    public Human(String fullName, Gender gender) {
        this(fullName, gender, null, null, null);
    }
}