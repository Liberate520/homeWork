package model.memberFactory;

import model.dog.Dog;
import model.family.Family;
import model.member.Gender;
import model.member.Member;

import java.util.Calendar;

public class DogFactory implements AbstractMemberFactory<Dog>{
    @Override
    public Dog create(String fullName, Gender gender, Calendar birthDate, Calendar deathDate, Family<Member> family) {
        return new Dog(fullName, gender, birthDate, deathDate, family);
    }
}
