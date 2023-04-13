package model.Persons;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human extends Person implements Serializable, InterfaceHuman
{
    private int id;
    private Person father;
    private Person mother;
    private Gender gender;
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    private LocalDate dataDeath;
    private ArrayList<Person> children;
    


    public Human(int id, String lastName, String firstName, Gender gender,
    LocalDate dataBirth, LocalDate dataDeath, Person father, Person mother, ArrayList<Person> children)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dataBirth = dataBirth;
        this.dataDeath = dataDeath;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }    
    

    public Human(int id, String lastName, String firstName,Gender gender,
    LocalDate dataBirth, LocalDate dataDeath, Person father, Person mother)
    {
        this(id, lastName, firstName, gender, dataBirth, dataDeath, father, mother,null);
        
    }

    public Human(int id, String lastName, String firstName,Gender gender,
    LocalDate dataBirth, LocalDate dataDeath, Person father)
    {
        this(id, lastName, firstName, gender, dataBirth, dataDeath, father, null, null);     
    }

    public Human(int id, String lastName, String firstName,Gender gender, LocalDate dataBirth, LocalDate dataDeath)
    {
        this(id, lastName, firstName, gender, dataBirth, null, null, null,null);
    }
    
    public Human(int id, String lastName, String firstName, Gender gender, LocalDate dataBirth)
    {
        this(id, lastName, firstName, gender, dataBirth, null, null, null, null);
        
    }

    public Human(int id, String lastName, String firstName, Gender gender)
    {
        this(id, lastName, firstName, gender, null, null, null, null, null);
        
    }
    public Human(int id, String lastName, String firstName)
    {
        this(id, lastName, firstName, null, null, null, null, null,null);  
    }

    public Human(int id, String lastName)
    {
        this(id, lastName, null, null, null, null, null,null, null);  
    }
    public Human(int id)
    {
        this(id, null, null, null, null, null, null,null, null);  
    }

    public Human()
    {
        this(0, null, null, null, null, null, null, null, null);
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setFather(Person father)
    {
        this.father = father;
    }

    public Person getFather() 
    {
        return father;
    }
    public void setMother(Person mother) 
    {
        this.mother = mother;
    }
    public Person getMother() 
    {
        return mother;
    }

    public void setGender(Gender gender) 
    {
        this.gender = gender;
    }
    public Gender getGender() 
    {
        return gender;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getFirstName() 
    {
        return firstName;
    }
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    public String getLastName() 
    {
        return lastName;
    }

    public void setDataBirth(LocalDate dataBirth) 
    {
        this.dataBirth = dataBirth;
    }
    public LocalDate getDataBirth() 
    {
        return dataBirth;
    }
    public void setDataDeath(LocalDate dataDeath) 
    {
        this.dataDeath = dataDeath;
    }
    public LocalDate getDataDeath() {
        return dataDeath;
    }
    
    public void setChildren(ArrayList<Person> children) 
    {
        this.children = children;
    }
    public ArrayList<Person> getChildren()
    {
        return children;
    }

    public void addChildren(Person person)
    {
        if(this.children == null)
        {
            this.children = new ArrayList<>();    
        }
        this.children.add(person);
    }

    public int getAge() 
    {
        LocalDate currenDate = LocalDate.now();
        if (getDataDeath() == null)
            return Period.between(dataBirth, currenDate).getYears();
        else
            return Period.between(dataBirth, dataDeath).getYears();
    }

    
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(id).append(" фамилия: ").append(lastName).append(", имя: ").append(firstName).append("\n");
        sb.append(" дата рождения: ").append(dataBirth);
        if (dataDeath == null)
        {sb.append(" возраст: ").append(getAge()).append("\n");}
        else
        {sb.append(", дата смерти: ").append(dataDeath).append("\n");}
        if(gender == Gender.Male)
        {sb.append(" пол мужской: ").append(gender).append("\n");}
        else
        {sb.append(" женский пол:").append(gender).append("\n");}
        if(father == null)
        {sb.append(" отец не определён ").append("\n");}
        else
        {sb.append(" отец id: ").append(father.getId()).append(" фамилия: ").append(father.getLastName()).append(", имя:  ").append(father.getFirstName()).append(", год рождения: ").append(father.getDataBirth()).append("\n");}
        if(mother == null)
        {sb.append(" мать не определёна ").append("\n");}
        else
        {sb.append(" мать id: ").append(mother.getId()).append(" фамилия: ").append(mother.getLastName()).append(", имя:  ").append(mother.getFirstName()).append(", год рождения: ").append(mother.getDataBirth()).append("\n");}
        if (children == null)
        {sb.append(" детей нет").append("\n");}
        else
        {
            sb.append(" дети: ").append("\n");
            for (int i =0; i < children.size(); i++)
            {
                if(children.get(i).getGender() == Gender.Male)
                {sb.append(" сын : ");}
                else{sb.append(" дочь: ");}
                sb.append(" id: ").append(children.get(i).getId());
                sb.append(" фамилия: ").append(children.get(i).getLastName());
                sb.append(" имя: ").append(children.get(i).getFirstName());
                sb.append(" дата рождения: ").append(children.get(i).getDataBirth()).append("\n");
            }
        }
        return sb.toString();
    }
}
