package Tree;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class FamilyTree implements Serializable {
    private List<Person> personList;

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List <Person> personList){
        this.personList=personList;
    }

    //Добавление человека в генеалогическое древо
    public boolean add(Person person){
        if(person==null || personList.contains(person)){
            System.out.println("Пустой объект или такой объект имеется");
            return false;
        }
        else{
            personList.add(person);
            addToParents(person);//Добавление родственных связей
            addToChildren(person);//Добавление родственных связей
            return true;
        }
    }

    //Связь с родителями
    private void addToParents(Person person){
        for (Person parent: person.getParents()) {
            parent.addChild(person);
        }
    }

    //СВязь с детьми
    private void addToChildren(Person person){
        for (Person child: person.getChildrenList()) {
            child.addParent(person);
        }
    }


    //Поиск по имени. Могут быть однофамильцы. Возвращается список объектов
    public List<Person> getByName(String fullName){
        List<Person> res=new ArrayList<>();
        for (Person person: personList){
            if (person.getFullName().equals(fullName)){
                res.add(person);
            }
        }
        return res;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb=new StringBuilder();
        sb.append("В генеалогическом древе ");
        sb.append(personList.size());
        sb.append(" объектов: \n ");
        for(Person person: personList){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();

    }

}
