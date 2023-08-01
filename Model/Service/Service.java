package Service;

import Model.Gender;
import Model.Human;
import Service.writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Сюда планируется перенос методов, как учили на семинаре
public class Service implements Serializable {
    String filePath = "/Users/station/Desktop/HomeWork/FamilyTree/familyTree.out";
    FileHandler fileHandler = new FileHandler();
    List<Human> family = new ArrayList<Human>();
    public void Scanner() {
        Scanner in = new Scanner(System.in);
        boolean exit = false;
            while (!exit) {
                addHuman(in);
                System.out.println("\nВыберите действие:");
                System.out.println("1. Добавить человека");
                System.out.println("2. Вывести всех людей");
                System.out.println("3. Сортировать по имени");
                System.out.println("4. Сортировать по возрасту");
                System.out.println("0. Сохранение и выход");
                System.out.print("Ваш выбор: ");
                int choice = in.nextInt();

              switch (choice) {
                  case 1:
                      addHuman(in);
                      break;
                  case 2:
                      getFamilyInfo();
                      break;
                  case 3:
                      sortByName();
                      break;
                  case 4:
                      sortByAge();
                      break;
                  case 0:
                      exit = true;
                      break;
                  default: System.out.println("Некорректный выбор. Повторите попытку.");
              }
        }
        in.close();
        fileHandler.save((Serializable) family, filePath);
    }
            public void addHuman(Scanner in){
                Human human = new Human();
                System.out.print("Добавить нового человека \nВведите имя: ");
                human.setName(in.nextLine());
                System.out.print("Введите пол (Male/Female): ");
                human.setGender(Gender.valueOf(in.nextLine()));
                System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
                human.setAge(LocalDate.parse(in.nextLine()));
                System.out.printf("Имя: %s  Возраст: %d \n", human.getName(), human.getAge());
                family.add(human);
            }
            public void getFamilyInfo(){
                StringBuilder stringBuilder = new StringBuilder();
                for(Human human: family) {
                    stringBuilder.append(human);
                    stringBuilder.append('\n');
                }
                System.out.printf(stringBuilder.toString());
            }
    public void sortByName() {

        family.sort(new FamilyMemberComparatorByName());
        getFamilyInfo();
    }
    public void sortByAge() {
        family.sort(new FamilyMemberComparatorByAge());
        getFamilyInfo();
    }
}

//    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, String status)
