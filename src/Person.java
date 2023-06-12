import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Person {
    private String surname;
    private String firstName;
    private String middleName;
    private String sex;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String surname, String firstName, String middleName, String sex){
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.sex = sex;
        this.father = null;
        this.mother = null;
        this.dateOfDeath = null;
        this.children = new ArrayList<>();
    }

    public int getAge() {
        LocalDate date = LocalDate.now(); // получаем текущую дату
        int month = date.getMonthValue();
        int age = date.getYear() - this.dateOfBirth.getYear() - 1;
        if (date.getMonthValue() > this.dateOfBirth.getMonthValue()){
            age = age + 1;
        }
        if (date.getMonthValue() == this.dateOfBirth.getMonthValue()){
            if (date.getDayOfMonth() >= this.dateOfBirth.getMonthValue()){
                age = age + 1;
            }
        }
        return age;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return this.surname + " " + this.firstName + " " + this.middleName ;
    }

    public void addChild(Person child){
        this.children.add(child);
        if (this.sex == "F"){
            child.mother = this;
        } else {
            child.father = this;
        }
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public void showChildren(){
        if (!this.children.isEmpty()){
            System.out.println("Родитель: " + this.getFullName());
            int iter = 1;
            for (Person child : children){
                System.out.printf("- Ребёнок %d: %s\n", iter++, child.getFullName());
            }
        } else {
            System.out.printf("%s не имеет детей", this.getFullName());
        }
    }
}
