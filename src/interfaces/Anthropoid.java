package interfaces;

import person.Sex;

import java.util.HashSet;

public interface Anthropoid {
    Anthropoid mother = null;
    Anthropoid father = null;
    Anthropoid spouse = null;
    HashSet<Anthropoid> brothersOrSistersSet = null;
    HashSet<Anthropoid> childrenSet = null;

    Sex getSex();
    String getFirstName();
    String getLastName();
    int getAge();

    void setMother(Anthropoid mother);
    void setFather(Anthropoid father);
    void setSpouse(Anthropoid spouse);
    Anthropoid getMother();
    Anthropoid getFather();
    Anthropoid getSpouse();
    void addBrother(Anthropoid brother);
    void addSister(Anthropoid sister);
    void addBrotherOrSisterSet (HashSet<Anthropoid> brotherOrSisterSet);
    void addBrotherOrSisterSet (Anthropoid brotherOrSister);
    HashSet<Anthropoid> getBrothersOrSistersSet();
    void addChildren(HashSet<Anthropoid> childrenSet);
    void addChildren(Anthropoid child);
    HashSet<Anthropoid> getChildrenSet();
}
