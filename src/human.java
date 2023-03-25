package homeWork.src;

import java.util.ArrayList;

public class human 
{
    private int id;
    private human Father;
    private human Mather;
    Gender gender;
    private String firstName;
    private String lastName;
    private int dataBirth;
    private ArrayList<human> children;


    public human(int id, String firstName, String lastName, Gender gender,
    int dataBirth, human Father,human Mather, ArrayList<human> children)
    {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dataBirth = dataBirth;
        this.Father = Father;
        this.Mather = Mather;
        this.children = children;
    }    
    
    public human(int id, String lastName, String firstName,Gender gender,
    int dataBirth, human Father, human Mather)
    {
        this(id, lastName, firstName, gender, dataBirth, Father, Mather,null);
        
    }

    public human(int id, String lastName, String firstName,Gender gender,
    int dataBirth, human Father)
    {
        this(id, lastName, firstName, gender, dataBirth, Father, null, null);     
    }

    public human(int id, String lastName, String firstName,Gender gender, int dataBirth)
    {
        this(id, lastName, firstName, gender, dataBirth, null, null, null);
    }
    
    public human(int id, String lastName, String firstName, Gender gender)
    {
        this(id, lastName, firstName, gender, 0, null, null, null);
        
    }

    public human(int id, String lastName, String firstName)
    {
        this(id, lastName, firstName, null,0, null, null, null);
        
    }
    public human(int id, String lastName)
    {
        this(id, lastName, null, null, 0, null, null,null);  
    }

    public human(int id)
    {
        this(id, null, null, null, 0, null, null,null);  
    }

    public human()
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

    public void setFather(human Father)
    {
        this.Father = Father;
    }

    public human getFather() 
    {
        return Father;
    }
    public void setMather(human Mather) 
    {
        this.Mather = Mather;
    }
    public human getMather() 
    {
        return Mather;
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
    
    public void setChildren(ArrayList<human> children) {
        this.children = children;
    }
    public ArrayList<human> getChildren() {
        return children;
    }
    
    @Override
    public String toString() 
    {
        return String.format("\n%d Фамилия : %s; Имя : %s; пол : %s; дата рождения : %d\n отец : %s\n мать : %s\n дети : %s \n",
        id, firstName, lastName, gender, dataBirth, Father, Mather, children);
    }


}
