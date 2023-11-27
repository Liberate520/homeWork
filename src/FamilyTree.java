import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FamilyTree {
    // Класс имеет одно поле с листом
    private ArrayList<Human> humans;

    // В конструкторе инициализируем List как ArrayList
    public FamilyTree() {
        humans = new ArrayList<>();
    }

    // Метод для заполнения ArrayList экземплярами класса Human
    public void addHuman(Human human) {
        humans.add(human);
    }


    // Переопределяем метод toString класса FamilyThree
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Human h : humans) {
            if (h.getChildren().isEmpty())
                builder.append("РЕБЕНОК: ");
            else if (h.getGender().equals(Gender.MALE))
                builder.append("ОТЕЦ: ");
            else
                builder.append("МАТЬ: ");
            builder.append("имя: ")
                    .append(h.getName())
                    .append(", Фамилия: ")
                    .append(h.getLastName())
                    .append(", возраст: ");
            if(h.getDateDeath()==null)
                builder.append(Period.between(h.getBirthDay(), LocalDate.now()).getYears()).append(" лет");
            else
                builder.append(" умер в количестве: ")
                        .append(Period.between(h.getBirthDay(),h.getDateDeath()).getYears())
                        .append(" лет");

                    builder.append(", пол: ")
                           .append(h.getGender()).append(",дети: ");
            if (h.getChildren().isEmpty())
                builder.append(",нет детей.").append("\n");
            else
                builder.append(h.children).append("\n").append("-------------------------------------").append("\n");

        }
        return builder.toString();
    }

    // Поиск ребенка
    public String findChildren(String name, String lastName) {
        StringBuilder br = new StringBuilder();
     boolean find = false;

        for (Human parents : humans) {

                for (Human child : parents.getChildren()) {

                    if (child.getName().equals(name) && child.getLastName().equals(lastName)) {
                       if(!find) {
                           if (child.getGender().equals(Gender.MALE))
                               br.append("НАЙДЕН:").append("\n").append("СЫН: ");
                           else br.append("ДОЧЬ: ");


                           br.append("имя: ")
                                   .append(child.getName()).append(", фамилия: ")
                                   .append(child.getLastName()).append(", возраст: ");
                           if(child.getDateDeath()==null)
                                   br.append(Period.between(child.getBirthDay(),LocalDate.now()).getYears())
                                           .append(" лет");
                           else br.append("Умер в количестве: ")
                                   .append(Period.between(child.getBirthDay(),child.getDateDeath()).getYears())
                                           .append(" лет");
                                   br.append("\n")
                                   .append("************************").append("\n");
                       }
                        if (parents.getGender().equals(Gender.MALE))
                            br.append("ОТЕЦ: ");

                        else br.append("МАТЬ: ");

                        br.append(" имя: ").append(parents.getName()).append(", фамилия: ")
                                .append(parents.getLastName()).append(" возраст: ");
                        if(parents.getDateDeath()==null)
                            br.append(Period.between(parents.getBirthDay(),LocalDate.now()).getYears()).append(" лет");
                        else
                            br.append(" умер в возрасте: ")
                                    .append(Period.between(parents.getBirthDay(),parents.getDateDeath()).getYears())
                                    .append("лет");
                        br.append("\n");
                        find = true;
                    }

                }
            }
        if(!find)  br.append("Ребенок с таким именем и фамилией НЕ НАЙДЕН!");

        return br.toString();

        }
        // Метод для добавления ребенка(поиск родителя по имени и фамилии и сравнения списка детей
        // добавляем ребенка матери и отцу
        // если такого ребенка нет
        // если нет совпадений выводим не возможно добавить
   public void addChild(String name,String lastName,Human child){
        ArrayList<Human> wedding = new ArrayList<>();
       for (int i = 0; i < humans.size(); i++) {
           if(humans.get(i).getName().equals(name)&&humans.get(i).getLastName().equals(lastName)){
               int j = 0;
               while (j < humans.size()) {
                   if (humans.get(i).getChildren().equals(humans.get(j).getChildren()))
                       wedding.add(humans.get(j));

                   j++;
               }
           }

           }
       if(wedding.isEmpty()) {
           System.out.println("Не возможно добавить! Таких родителей нет!");
       }
       else {
       for (Human ch : wedding) {
           if (ch.getChildren().contains(child)) {
               System.out.println("Такой ребенок уже добавлен!");
               break;
           } else {
               ch.getChildren().add(child);
           }
       }

       }

       }
   }















