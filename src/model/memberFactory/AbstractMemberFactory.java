package model.memberFactory;

import model.family.Family;
import model.member.Gender;
import model.member.Member;

import java.util.Calendar;

public interface AbstractMemberFactory<T> {
    T create(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family);
}
