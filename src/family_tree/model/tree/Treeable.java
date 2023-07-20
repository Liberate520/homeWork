package family_tree.model.tree;

import family_tree.model.gender.Gender;
import family_tree.model.person.Person;

import java.time.LocalDate;
import java.util.ArrayList;


public interface Treeable<E> {
    void addChild(E person);

    void addMother(E person);

    void addFather(E person);

    @Override
    boolean equals(Object obj);

    String getName();

    void setName(String name);

    LocalDate getBirthday();

    Integer getAge();

    void setBirthday(LocalDate birthday);

    LocalDate getDayOfDeath();

    void setDayOfDeath(LocalDate dayOfDeath);

    ArrayList<E> getParents();

    Person getFather();

    Person getMother();

    ArrayList<E> getChildren();

    String getMotherInfo();

    String getFatherInfo();

    String getDayOfDeathInfo();

    String getChildrenInfo();

    Integer getId();

    Person getPartner();

    void setPartner(E partner);

    String getPartnerInfo();

    Gender getGender();

    void setGender(Gender gender);

    ArrayList<E> getSiblings();

    void addSibling(E sibling);

    String getSiblingsInfo();

    String getInfo();
    public void setParents(ArrayList<Person> parents);

    public void setChildren(ArrayList<Person> children);

    public void setSiblings(ArrayList<Person> siblings);
}
