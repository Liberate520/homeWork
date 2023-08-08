package View;


import Model.Human.Gender;
import Model.Human.Status;

import java.time.LocalDate;

public interface View {
    void start();
    void findById();
    void addHumanWithParents();
    void addChild();
    void makeMarriage();
    String setName();
    Gender setGender();
    Status setStatus();
    LocalDate setDate();
    void save();
    void load();
    void printAnswer(String text);

}
