package model.creature.Interface;

public interface ParentsInfo<T> {
    void addParent(T parent);
    String getMotherInfo();
    String getFatherInfo();
    T getMother();
    void setMother(T mather);
    T getFather();
    void setFather(T father);
}
