import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Children person_1 = new Children(1, "Иван", "Анатольевич", "Петров", "мужской");
        Children person_2 = new Children(1, "Маргарита", "Анатольевна", "Петрова", "женский");
        Children person_3 = new Children(2, "Илья", "Ярославович", "Петров", "мужской");
        Children person_4 = new Children(2, "Инна", "Ярославовна", "Петрова", "женский");
        Children person_5 = new Children(3, "Александр", "Сергеевич", "Петров", "мужской");

        Parent person_6 = new Parent(1, "Анатолий", "Иванович", "Петров", "мужской");
        Parent person_7 = new Parent(1, "Анна", "Ильинична", "Петрова", "женский");
        Parent person_8 = new Parent(2, "Ярослав", "Иванович", "Петров", "мужской");
        Parent person_9 = new Parent(2, "Марина", "Алексеевна", "Петрова", "женский");
        Parent person_10 = new Parent(3, "Сергей", "Фёдорович", "Петров", "мужской");
        Parent person_11 = new Parent(3, "Елена", "Альбертовна", "Петрова", "женский");
        System.out.println("Выберите функцию:");
        System.out.println("1 - выборка детей по родителю");
        System.out.println("2 - выборка родителей по ребёнку");
        Scanner sc = new Scanner(System.in,"ibm866");
        Integer choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Введите ID семьи: ");
                System.out.printf(person_6.toString() + "\n" + person_7.toString() + "\n"+ person_8.toString() + "\n"+ person_9.toString() + "\n"+ person_10.toString() + "\n"+ person_11.toString() + "\n");
                Integer id = sc.nextInt();
                System.out.println("Дети: ");
                if(id == 1){
                    System.out.printf(person_1.toString() + "\n" + person_2.toString() + "\n");
                }
                else if(id == 2){
                    System.out.printf(person_3.toString() + "\n" + person_4.toString() + "\n");
                }   
                else if(id == 3){
                    System.out.printf(person_5.toString() + "\n");
               
                }
            }else if(choice == 2){

                System.out.println("Введите ID семьи: ");
                System.out.printf(person_1.toString() + "\n" + person_2.toString() + "\n"+ person_3.toString() + "\n"+ person_4.toString() + "\n"+ person_5.toString() + "\n");
                Integer idd = sc.nextInt();
                System.out.println("Родители: ");
                    if(idd == 1){
                        System.out.printf(person_6.toString() + "\n" + person_7.toString() + "\n");
                    }
                    else if(idd == 2){
                        System.out.printf(person_8.toString() + "\n" + person_9.toString() + "\n");
                    }   
                    else if(idd == 3){
                        System.out.printf(person_10.toString() + "\n" + person_11.toString() + "\n");
                    }
                }
    sc.close();
}
}
