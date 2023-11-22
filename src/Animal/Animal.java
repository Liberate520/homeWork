package Animal;

import java.time.LocalDate;
import java.util.List;

import Animal.Human.Gender;

public interface Animal{
    void setName(String str);
    void setBirthday(LocalDate date);
    LocalDate getBirthday();
    void setGender(Gender gender);
    void setGender(String gender);
    Gender getGender();
    void setId(int id);
    String getName();
    void setFather(Animal animal);
    void setMather(Animal animal);
    void addChildren(Animal animal);
    List<Animal> getChildren();
    void setSpouse(Animal animal);
    Animal getSpouse();
    int compareTo(Animal o);
    
} 
