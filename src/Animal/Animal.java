package Animal;

import java.time.LocalDate;
import java.util.List;

import Animal.Human.Gender;

public interface Animal<T>{
    void setName(String str);
    void setBirthday(LocalDate date);
    LocalDate getBirthday();
    void setGender(Gender gender);
    void setGender(String gender);
    Gender getGender();
    void setId(int id);
    int getId();
    String getName();
    void setFather(T animal);
    void setMather(T animal);
    void addChildren(T animal);
    List<T> getChildren();
    void setSpouse(T animal);
    T getSpouse();
    int compareTo(T o);
    
} 
