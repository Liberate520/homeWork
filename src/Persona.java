import java.util.ArrayList;
import java.util.List;


public class Persona {
    
    private String firstname;
    private String secondname;
    private String dateofbirth;
    private List<Persona> childrens = new ArrayList<>();
    private Persona father;
    private Persona mother;
    
    public Persona(String firstname, String secondname, String dateofbirth){
        this.firstname = firstname;
        this.secondname = secondname;
        this.dateofbirth = dateofbirth;

        this.childrens = childrens;
        this.father = father;
        this.mother = mother;
    }
  
    

    public void getFirstName() {
        System.out.println(firstname);
    }

    public void getSecondName() {
        System.out.println(secondname);
    }

    public void getDateOfBirth() {
        System.out.println(dateofbirth);
    }

    public void getMother() {
        System.out.println(mother);
    }

    public void getFather() {
        System.out.println(father);
    }

    public void getChildren() {
        System.out.println(childrens);
    }

    public Persona addMother(Persona persona) {
        return this.mother = persona;
    }

    public Persona addFather(Persona persona) {
        return this.father = persona;
    }

    public void addChildren(Persona persona){
        childrens.add(persona);
    }


    @Override
    public String toString() {
        return "Имя, Фамилия: " + firstname + " " + secondname; 
        // + "; Дата рождения: " + dateofbirth; 
        // +  ", Мать: " + mother + ", Отец: " + father;
        // + " Дети:" + childrens;
    }

}
