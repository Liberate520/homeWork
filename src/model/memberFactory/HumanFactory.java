package model.memberFactory;

import model.family.Family;
import model.human.Human;
import model.member.Gender;
import model.member.Member;

import java.util.Calendar;

public class HumanFactory implements AbstractMemberFactory<Human>{

    @Override
    public Human create(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family) {
        return new Human(fullName, gender, birthDate, deathDate, family);
    }
}
