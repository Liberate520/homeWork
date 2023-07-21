package FamilyTree.Model.tree;

import java.time.LocalDate;
import java.util.List;

public interface  Being  <T extends Being<T>>{

    public boolean addChild (T child);
    public boolean addParent (T parent);

    public boolean addSpouse (T spouse);

    public Integer getId() ;

    public void setId(Integer id);


    public String getName() ;
    public Enum getSex() ;

    public LocalDate getBirthday();

    public LocalDate getDeathday();
    public List<T> getChildren() ;

    public T getFather() ;
    public T getMother() ;


    public void setBirthday(LocalDate birthday) ;


    public void setDeathday(LocalDate deathday);


    public String toString() ;
    public String getChildrenInfo();
    public String getParentsnfo();
    public String getSpouseInfo();

    public boolean equals(Object o);

}



