
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
        // Scanner scan = new Scanner(System.in, "Cp866");//если закрывать сканер, то закрывается поток, и при повторном вызове метода он снова не открывается. как быть?  
        // System.out.println("***************************************************************");
        // System.out.println("Добавляем нового человека в дерево");
        // Gender gender = null;
        // String name = "";
        // String secondName = "";
        // String surname = "";
        // System.out.println("1 - М");
        // System.out.println("2 - Ж");
        // System.out.print("Выберете пол:");
        // String selGend = scan.nextLine();
        // switch(selGend){
        //     case "1":
        //         gender = Gender.m;
        //         break;
        //     case "2":
        //         gender = Gender.f;
        //         break;    
        // }
        // System.out.print("Введите год рожедения: ");//ввод года рождения
        // int yob = scan.nextInt();
        // scan.nextLine();

        // System.out.print("Введите имя: ");//ввод имени
        // name = scan.nextLine();  
          
        // if(father != null && mother != null){//если родители известны - формируем отчество и фамилию
        //     if(gender.equals(Gender.m)){//если мужской пол
        //         surname = father.getSurname();
        //         secondName = father.getName() + "ович";//потом переделать
        //     }
        //     else{//если женский пол
        //         surname = mother.getSurname();//фамилию надо будет брать от отца и трансформировать
        //         secondName = father.getName() + "овна";
        //     }
        // }else{//если родители неизвестны, нужно заполнить фамилию и отчество
        //     System.out.print("Введите отчество: ");
        //     secondName = scan.nextLine();
        //     System.out.print("Введите фамилию: ");
        //     surname = scan.nextLine();    
        // }
        // System.out.println("Добавляемый человек жив? ");
        // System.out.print("1 - да, 2 - нет. Введите № варианта: ");
        // String living = scan.nextLine();
        // if (living.equals("1")){//если жив - создаем без даты смерти
        //     addedPerson = new Person(name, secondName, surname, father, mother, gender, yob);
        // }else{
        //     System.out.print("Введите год смерти: ");//иначе - уточняем дату смерти и создаем по полному конструктору
        //     int yod = scan.nextInt();
        //     scan.nextLine();
        //     addedPerson = new Person(name, secondName, surname, father, mother, gender, yob, yod);
        // }

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
