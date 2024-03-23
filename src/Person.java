import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id; //Добавляем id,кооторый будет увеличиваться, как автоинкремент в Main.
    private String fullName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother;
    private Person father;
    private List<Person> childrenList;


    //Полный конструктор
    public Person(int id, String fullName, Gender gender, LocalDate birthDate, LocalDate deathDate, Person mother, Person father) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        childrenList=new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getChildrenList() {
        return childrenList;
    }

    //Уточнение даты смерти
    public String lifeYears(){
        if (getDeathDate()!=null){
            return " дата смерти: "+getDeathDate()+",";
        }
        return "";
    }

    //Вывод возраста
    public int getAge(LocalDate birthDate,LocalDate deathDate){
        if(deathDate!=null){
            return Period.between(birthDate,deathDate).getYears();
        }
        else{
            return Period.between(birthDate,LocalDate.now()).getYears();
        }
    }


    //Добавление родителя в зависимости от пола
    public void addParent(Person parent){
        if(parent.getGender().equals(Gender.male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.male)){
            setMother(parent);
        }
    }


    //Формулируем лист родителей для каждого отдельного человека
    public List<Person> getParents(){
        List<Person> list=new ArrayList<>(2);
        if(father!=null){
            list.add(father);
        }
        if(mother!=null){
            list.add(mother);
        }
        return list;
    }


    //Вывод информации о родителях в зависимости от пола и степени известности
    public StringBuilder getParentsInfo(){
        StringBuilder str=new StringBuilder();
        List<Person> parents=getParents();
        if (parents.size()==2) {
            for (Person parent : parents) {
                if (parent.getGender().equals(Gender.female)) {
                    str.append("  мать: " + mother.getFullName());
                } else {
                    str.append(" отец: " + father.getFullName());
                }
            }
        }
        else if  (parents.size()==1){
            for (Person parent : parents) {
                if (parent.getGender().equals(Gender.female)) {
                    str.append("отец: неизвестен");
                    str.append("  мать: " + mother.getFullName());
                } else {
                    str.append("отец: " + father.getFullName());
                    str.append("  мать: неизвестена");
                }
            }
        }
        else{
            str.append(" родители неизвестны");
        }
        return str;
    }


    //Добавление детей родителю
    public void addChild(Person child) {
        if (!childrenList.contains(child)) {
            childrenList.add(child);
        }
    }


    //вывод информации о детях
    public String getChildrenInfo(){
        StringBuilder res =new StringBuilder();
        res.append("дети: ");
        if (!childrenList.isEmpty()){
            res.append(childrenList.get(0).getFullName());
            for (int i=1;i<childrenList.size();i++){
                res.append(", ");
                res.append(childrenList.get(i).getFullName());
            }
        }
            else {
                res.append("отсутствуют");
            }
            return res.toString();
        }



        //Вывод информации на консоль о соответсвующем экземпляре класса
    @Override
    public String toString() {
        return getInfoAboutPerson();
    }

    public String getInfoAboutPerson(){
        StringBuilder str=new StringBuilder();
        str.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        str.append("\nID: ");
        str.append(id);
        str.append(", имя: ");
        str.append(fullName);
        str.append("\nпол: ");
        str.append(getGender());
        str.append(", возраст: ");
        str.append(getAge(birthDate,deathDate));
        str.append(", дата рождения: ");
        str.append(getBirthDate());
        str.append(", ");
        str.append(lifeYears());
        str.append(getParentsInfo());
        str.append(", ");
        str.append(getChildrenInfo());
        return str.toString();

    }

}
