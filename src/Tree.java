
import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;
import java.lang.StringBuilder;

public class Tree {
    private List<Person> family;
    // private Person addedPerson;


    public Tree(List <Person> persons){
        family = persons;
    }

    public Tree(){
        this(new ArrayList<>());
    }

    public void addPerson (Person addedPerson, Person father, Person mother){////////////////метода добавления нового человека в дерево///
        family.add(addedPerson);
        if(father != null)//если родители есть, добавляем им информацию о ребенке 
            father.addChild(addedPerson);
        if(mother != null){   
            mother.addChild(addedPerson);
        }      
    }

    public void addPerson (Person addedPerson){//перегрузка метода для случая, когда родители не известны
        addPerson(addedPerson, null,null);
    }

    public List<Person> getFamily() {
        return family;
    }

    public String showFamily(List<Person> persons) {//надо будет сделать, чтобы вызывать этот метод работал для любого списка людей, сейчас работает в привязке к дереву
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < persons.size(); i++){
            sb.append(i+1).append(" ").append(persons.get(i)).append("\n");
        }
        return sb.toString();
    }

    public List<Person> findPersons (String surname) {//пока поиск только по фамилии
        System.out.println("Начинаю поиск...");
        List<Person> foundPersons = new ArrayList<>();
        for(int i = 0; i < family.size(); i++){
            // System.out.println(family.get(i).getSurname());//отладка
            if(family.get(i).getSurname().equals(surname)){//пока точное совпадение, потом продумать, чтобы находило по части фамилии
                foundPersons.add(family.get(i));
            }
        }
        if(foundPersons.size() == 0)
            System.out.println("Ничего не найдено!");
        return foundPersons;
    }


    @Override
    public String toString(){
        return showFamily(family);
    }
}
