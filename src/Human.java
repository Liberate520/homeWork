import java.util.ArrayList;

public class Human 
{
    private int id;
    private Human father;
    private Human mother;
    Gender gender;
    private String firstName;
    private String lastName;
    private int dataBirth;
    private ArrayList<Human> children;
    


    public Human(int id, String firstName, String lastName, Gender gender,
    int dataBirth, Human father, Human mother, ArrayList<Human> children)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dataBirth = dataBirth;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }    
    

    public Human(int id, String lastName, String firstName,Gender gender,
    int dataBirth, Human father, Human mother)
    {
        this(id, lastName, firstName, gender, dataBirth, father, mother,null);
        
    }

    public Human(int id, String lastName, String firstName,Gender gender,
    int dataBirth, Human father)
    {
        this(id, lastName, firstName, gender, dataBirth, father, null, null);     
    }

    public Human(int id, String lastName, String firstName,Gender gender, int dataBirth)
    {
        this(id, lastName, firstName, gender, dataBirth, null, null, null);
    }
    
    public Human(int id, String lastName, String firstName, Gender gender)
    {
        this(id, lastName, firstName, gender, 0, null, null, null);
        
    }

    public Human(int id, String lastName, String firstName)
    {
        this(id, lastName, firstName, null,0, null, null, null);
        
    }
    public Human(int id, String lastName)
    {
        this(id, lastName, null, null, 0, null, null,null);  
    }

    public Human(int id)
    {
        this(id, null, null, null, 0, null, null,null);  
    }

    public Human()
    {
        this(0, null, null, null,
         0, null, null, null);
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setFather(Human father)
    {
        this.father = father;
    }

    public Human getFather() 
    {
        return father;
    }
    public void setMother(Human mother) 
    {
        this.mother = mother;
    }
    public Human getMother() 
    {
        return mother;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setDataBirth(int dataBirth) {
        this.dataBirth = dataBirth;
    }
    public int getDataBirth() {
        return dataBirth;
    }
    
    public void setChildren(ArrayList<Human> children2) {
        this.children = children;
    }
    public ArrayList<Human> getchildren()
    {
        return children;
    }

    public void addChildren(Human human)
    {
        if(this.children == null)
        {
            this.children = new ArrayList<>();    
        }
        this.children.add(human);
    }

    
    
    @Override
    public String toString() 
    {
        return String.format("\n%d Фамилия : %s; Имя : %s; пол : %s; дата рождения : %d\n отец : %s\n мать : %s\n дети : %s \n",
        id, firstName, lastName, gender, dataBirth, father, mother, children);
    }

    public boolean isEmpty() 
    {
        return false;
    }

    public boolean contains(Human human) 
    {
        return false;
    }


}