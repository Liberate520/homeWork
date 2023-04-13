package familyTree.member;

import java.util.List;

public interface FamilyMember {
    int getId();
    void setName(String name);
    String getName();
    void setSurname(String lastName);
    String getSurname();
    String getBirthDate();
    void setBirthDate(String birthDate);
    String getDeathDate();
    void setDeathDate(String deathDate);
    Gender getGender();
    void setGender(Gender gender);
    Human getFather();
    void setFather(Human father);
    Human getMother();
    void setMother(Human mother);
    List<Human> getChildren();
    List<Human> getSiblings();
    List<Human> getGrandparents();
    List<Human> getGrandchildren();
    void addChild(Human child);
    void addSibling(Human sibling);
    void addGrandchild(Human grandchild);
    void addGrandparent(Human grandparent);

    String getInfo();

//    void addChild(FamilyMember member);

}
