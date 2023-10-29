package family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import family_tree.family_trees.TreeItem;
import family_tree.human.types_enum.Gender;
import family_tree.human.types_enum.LifeStatus;

import java.util.ArrayList;

public class Human implements Serializable, TreeItem{
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deadDay;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(String name, LocalDate birthDay, LocalDate deadDay, Human mother, Human father, Gender gender)
    {
        id = -1;
        this.name = name;
        this.birthDay = birthDay;
        this.deadDay = deadDay;
        this.mother = mother;
        this.father = father;
        this.gender = gender;
        childrens = new ArrayList<>();   
    }
    
    public int getID()
    {
        return id;
    }
    public int setID(int id)
    {
        return this.id = id;
    }
    public String getName() 
    {
        return name;
    }
    
    public List<Human> getParents()
    {
        List<Human> parentsList = new ArrayList<>(2);
        if(mother != null)
        {
            parentsList.add(mother);        
        }
        if(father != null)
        {
            parentsList.add(father);        
        }
        return parentsList;
    }

    public Human getMother() 
    {
        return mother;
    }

    public Human getFather() 
    {
        return father;
    }

    public Gender getGender() 
    {
        return gender;
    }

    public LifeStatus getLifeStatus() 
    {
        if(deadDay != null)
        {
            return LifeStatus.Dead;
        }
        return LifeStatus.Live;

    }

    public void addChild(Human child)
    {
        if(!childrens.contains(child))
        {
            childrens.add(child);
        }
    }

    public List<Human> getChildrensListInfo()
    {
        return childrens;
    }

    public int getAge() {
        int age = 0;
        LocalDate date_now = LocalDate.now();
        if(deadDay == null)
        {
            age = date_now.getYear() - birthDay.getYear();
        }
        else
        {
            age = deadDay.getYear() - birthDay.getYear();
        }
        return age;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(getName());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", Life Status: ");
        sb.append(getLifeStatus());
        sb.append(", Mother: ");
        sb.append(getMotherInfo());
        sb.append(", Father: ");
        sb.append(getFatherInfo());
        sb.append(", Childs: ");
        sb.append(getChildrensInfo());

        return sb.toString();
    }

    public String getMotherInfo()
    {
        String res = "";
        if(mother != null)
        {
            res += mother.getName();
        }
        else
        {
            res += "неизвестно";
        }
        return res;
    }

    public String getFatherInfo()
    {
        String res = "";
        if(father != null)
        {
            res += father.getName();
        }
        else
        {
            res += "неизвестно";
        }
        return res;
    }

    public String getChildrensInfo()
    {
        StringBuilder sb = new StringBuilder();

        if(childrens.size() != 0)
        {
            sb.append(childrens.get(0).getName());
            for(int i = 1; i < childrens.size(); i++)
            {
                sb.append(", ");
                sb.append(childrens.get(i).getName());
            }
        }
        else
        {
            sb.append("нету");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(this == obj)
        {
            return true;
        }
        if(!(obj instanceof Human))
        {
            return false;
        }
        Human human = (Human) obj;
        return human.getID() == getID();
    }
}