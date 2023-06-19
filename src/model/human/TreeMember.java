package model.human;

import java.time.LocalDate;

public interface TreeMember {
    String getName();
    Gender getGender();
    int getChildrenAmount();
    LocalDate getBirthday();
    TreeMember getFather();
    TreeMember getMother();
    void setName(String name);
    void setGender(Gender gender);
    void setBirthday(LocalDate birthday);
    void setFather(TreeMember father);
    void setMother(TreeMember mother);
    void addChild(TreeMember child);
    void removeChild(TreeMember child);
}
