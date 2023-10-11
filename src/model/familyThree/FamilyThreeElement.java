package model.familyThree;

import model.human.Gender;

import java.util.Date;
import java.util.Set;

public interface FamilyThreeElement<E> {
    Date getBirthday();
    String getFirstName();
    Gender getGender();
    E getMother();
    Date getDeathday();
//    String getLastName(); Специфично для Human
//    String getSecondName(); Специфично для Human
//    Set<Marriage> addMarriage(); Специфично для Human
    E getFather();
    Set<E> getChildren();
    void addChild( E child );
    // void addMarriage(); // у собак не может быть браков, это специфично для Human, но оставляю
    void setMother( E mother );
    void setFather( E father );
}
