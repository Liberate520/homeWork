package Service;

import Tree.Human;
import java.time.LocalDate;
import java.util.Scanner;

// Сюда планируется перенос методов, как учили на семинаре
public class Service {
public void Scanner() {
    Scanner in = new Scanner(System.in);
    boolean exit = false;
        while (!exit) {
            addHuman(in);
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить человека");
//          System.out.println("2. Вывести всех людей");
            System.out.print("Ваш выбор: ");
            int choice = in.nextInt();
            in.nextLine();

          switch (choice) {
              case 1: addHuman(in);
              case 2: addHuman(in);
              case 0: exit = true;
              default: System.out.println("Некорректный выбор. Повторите попытку.");
              }
              in.close();
    }
}
        public void addHuman(Scanner in){
            Human human = new Human();
            System.out.print("Add new human \nInput name: ");
            human.setName(in.nextLine());
            System.out.print("Input age: ");
            human.setAge(LocalDate.parse(in.nextLine()));
            System.out.printf("Name: %s  Age: %d \n", human.getName(), human.getAge());
        }
}
