package FamalyTree;

import java.time.LocalDate;

import Human.Gender;

public interface Animal {
    void setName(String str);
    void setBirthday(LocalDate date);
    void setGender(Gender gender);
    void setGender(String gender);
    Gender getGender();
    void setId(int id);
    String getName();
    void setFather(Animal animal);
    void setMather(Animal animal);
    void addChildren(Animal animal);
    void setSpouse(Animal animal);
    Animal getSpouse();
} 
