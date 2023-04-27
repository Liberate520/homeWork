package FamilyTree.model.nodes;

// import java.util.ArrayList;
// import java.util.List;
import java.lang.StringBuilder;

public class Person extends Node{
    private String secondName;
    private String surname;

    public Person (String name, String secondName,String surname, Gender gender,int yearOfBirth,int yearOfDeath, Person father,Person mother) {
        super(name, gender, yearOfBirth, yearOfDeath, father, mother);
        this.secondName = secondName;
        this.surname = surname;     
    }
    public Person (String name, String secondName,String surname, Gender gender,int yearOfBirth, int yearOfDeath) {
        this(name, secondName, surname, gender, yearOfBirth, yearOfDeath, null, null);
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int yearOfDeath = getYearOfDeath();
        sb.append("ФИО: ")
            .append(surname)
            .append(" ")
            .append(getName())
            .append(" ")
            .append(secondName)
            .append(", пол: ");
        if(getGender().equals(Gender.m)){
            sb.append("муж. ");
        } else sb.append("жен. ");
        sb.append(getYearOfBirth())
            .append(" - ");
        if(yearOfDeath > 0){
            sb.append(yearOfDeath);
        }
        return sb.toString();
    }

    @Override
    public boolean search(String text) {//поиска по текстовым полям человека, возвращает истину, если текст содержится
        if(super.getName().contains(text) || surname.contains(text) || secondName.contains(text))
            return true;
        return false;    
    }

    @Override
    public String getShortInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(surname).append(";").append(super.getName()).append(";").append(secondName);
        return sb.toString();
    }

    @Override
    public String getFullInfo() {
        StringBuilder sb = new StringBuilder();//основная информация о человеке
        sb.append(this).append("\n");//вместо this.toString() можно использовать просто this
        //информация о родителях(если есть). если нет - писать неизвестен. Родители типа Node, нужно кастовать к Person
        sb.append("Родители:\n").append("\tотец: ");
        if (getFather() == null){
            sb.append("неизвестен");
        }else{
            sb.append((Person)getFather());//вызовется toString() отца. 
        }
        sb.append("\n\tмать: ");
        if (getMother() == null){
            sb.append("неизвестна");
        }else{
            sb.append((Person)getMother());//вызовется toString() матери.
        }
        //информация о детях, если есть. если нет - писать детей нет. дети - список Node, нужно кастовать к Person
        sb.append("\nДети:\n");
        if(getChildren().size() == 0){
            sb.append("\tотсутствуют\n");
        }else{
            for(int i = 0; i < getChildren().size(); i++){
                sb.append("\t").append(i+1).append(" ").append(getChildren().get(i)).append("\n");
                //странно, почему сработало без кастования к Person. в List <Node> children добавляются полноценные
                //объекты Person, но ссылка типа Node, усеченная по возможностям. В Node не прописан toString(), нет фамилии и отчества
            }
        }
        //потом добавить информацию о супругах
        //проверить информацию о другом родителе у каждого ребенка. может быть от разных браков, тогда выводить список супругов
        //по идее у последнего добавленного ребенка будет актуальный супруг
        return sb.toString();
    }

}
