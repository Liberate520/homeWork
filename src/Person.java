
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class Person {
    private String name;
    private String secondName;
    private String surname;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;  
    private int yearOfBirth;
    private int yearOfDeath;
    
    public Person (String name, String secondName,String surname,Person father,Person mother, Gender gender,int yearOfBirth,int yearOfDeath) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.father = father;
        this.mother = mother;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        
    }
    public Person (String name, String secondName,String surname,Person father,Person mother, Gender gender,int yearOfBirth) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.father = father;
        this.mother = mother;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        yearOfDeath = 0;
    }
    public String getName() {
        return name;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getSurname() {
        return surname;
    }
    public Gender getGender() {
        return gender;
    }
    public Person getFather() {
        return father;
    }
    public Person getMother() {
        return mother;
    }
    public List<Person> getChildren() {
        return children;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public int getYearOfDeath() {
        return yearOfDeath;
    }
    public void addChildren(Person child) {//добавление ребенка к родителю
        if(children == null)//если списка детей не существует, создаем его.
            children = new ArrayList<>();//нет смысла инициализировать данный список при создании человека, тк это будет лишнее использ-е памяти.
        children.add(child);
    }
    public void showChildren() { //вывод списка детей   
        if (children.size()>0){//если дети есть
            for(int i = 0; i < children.size(); i++){
                System.out.printf("%d ", i+1);
                System.out.println(children.get(i));
            }
        }
        
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ФИО: ")
            .append(surname)
            .append(" ")
            .append(name)
            .append(" ")
            .append(secondName)
            .append(". ")
            .append(yearOfBirth)
            .append(" - ");
        if(yearOfDeath > 0){
            sb.append(yearOfDeath);
        }
        return sb.toString();
    }
}
