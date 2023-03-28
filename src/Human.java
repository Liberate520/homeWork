import java.util.ArrayList;

public class Human 
{
    private int id;
    private Human father;
    private Human mather;
    Gender gender;
    private String firstName;
    private String lastName;
    private int dataBirth;
    private ArrayList<Human> childrens;
    


    public Human(int id, String firstName, String lastName, Gender gender,
    int dataBirth, Human father, Human mather, ArrayList<Human> childrens)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dataBirth = dataBirth;
        this.father = father;
        this.mather = mather;
        this.childrens = childrens;
    }    
    

    public Human(int id, String lastName, String firstName,Gender gender,
    int dataBirth, Human father, Human mather)
    {
        this(id, lastName, firstName, gender, dataBirth, father, mather,null);
        
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
    public void setMather(Human mather) 
    {
        this.mather = mather;
    }
    public Human getMather() 
    {
        return mather;
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
    
    public void setChildrens(ArrayList<Human> childrens2) {
        this.childrens = childrens;
    }
    public ArrayList<Human> getChildrens()
    {
        return childrens;
    }

    public void addChildrens(Human human)
    {
        if(this.childrens == null)
        {
            this.childrens = new ArrayList<>();    
        }
        this.childrens.add(human);
    }

    
    
    @Override
    public String toString() 
    {
        return String.format("\n%d Фамилия : %s; Имя : %s; пол : %s; дата рождения : %d\n отец : %s\n мать : %s\n дети : %s \n",
        id, firstName, lastName, gender, dataBirth, father, mather, childrens);
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
