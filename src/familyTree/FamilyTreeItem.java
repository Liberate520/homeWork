package familyTree;

import java.time.LocalDate;
import java.util.List;

public  interface FamilyTreeItem<T> {
    int getAge();
    String getName();
    LocalDate getBirthDay();
    void setId(int id);

    default void setChildren(T children){};
    List<T> getChildren();

    //Вопрос: а как в интерфейсе прописывать методы с параметрами, как ниже?

//    public <T> getMother();
//    public void setMother(T mother);
//    public <T> getFather();

//    public void setFather(T father);


}
