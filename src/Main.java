
import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) { // array
                Human member1 = new Human("Гарик", "Петров", "45", "мужской");
                Human member2 = new Human("Любовь", "Петрова", "46", "женский");
                Human member3 = new Human("Виталий", "Петров", "18", "мужской");
                Human member4 = new Human("Милана", "Петрова", "10", "женский");

                // ===============================================================================================
                List<Relative> relatives = new ArrayList<>(); // список
                relatives.add(new Relative(member1, member2, Recitation.spouse)); // муж
                relatives.add(new Relative(member2, member1, Recitation.lady)); // баба
                relatives.add(new Relative(member1, member3, Recitation.father)); // батя cын
                relatives.add(new Relative(member3, member1, Recitation.son)); // сын батя
                relatives.add(new Relative(member1, member4, Recitation.father)); // батя дочка
                relatives.add(new Relative(member4, member1, Recitation.daughter)); // дочка батя
                relatives.add(new Relative(member2, member3, Recitation.mother)); // мама сын
                relatives.add(new Relative(member3, member2, Recitation.son)); // сын мама
                relatives.add(new Relative(member2, member4, Recitation.mother)); // мама дочь
                relatives.add(new Relative(member4, member2, Recitation.daughter)); // дочь мама
                relatives.add(new Relative(member3, member4, Recitation.brother)); // брат сестра
                relatives.add(new Relative(member4, member3, Recitation.sister)); // сестра брат
                // ===============================================================================================

                Controller controller = new Controller(); // печать
                System.out.println(member1.getName() + " " + member1.getSurname() + " - жена " +
                                controller.searchMemberByRecitation(member1, Recitation.lady, relatives));
                System.out.println(member1.getName() + " " + member1.getSurname() + " - дочь " +
                                controller.searchMemberByRecitation(member1, Recitation.daughter, relatives));
                System.out.println(member2.getName() + " " + member2.getSurname() + " - муж " +
                                controller.searchMemberByRecitation(member2, Recitation.spouse, relatives));
                System.out.println(member4.getName() + " " + member4.getSurname() + " - мама " +
                                controller.searchMemberByRecitation(member4, Recitation.mother, relatives));
                System.out.println(member2.getName() + " " + member2.getSurname() + " - сын " +
                                controller.searchMemberByRecitation(member2, Recitation.son, relatives));
                System.out.println(member2.getName() + " " + member2.getSurname() + " - дочь " +
                                controller.searchMemberByRecitation(member2, Recitation.daughter, relatives));
                System.out.println(member4.getName() + " " + member4.getSurname() + " - брат " +
                                controller.searchMemberByRecitation(member4, Recitation.brother, relatives));
                System.out.println(member3.getName() + " " + member3.getSurname() + " - сестра " +
                                controller.searchMemberByRecitation(member3, Recitation.sister, relatives));
                System.out.println(member1.getName() + " " + member1.getSurname() + " - " + "связь: " +
                                controller.searchRecitation(member1, relatives));
                System.out.println(member3.getName() + " " + member3.getSurname() + " - " + "связь: " +
                                controller.searchRecitation(member3, relatives));
                System.out.println(member2.getName() + " " + member2.getSurname() + " - " + "связь: " +
                                controller.searchRecitation(member2, relatives));
                System.out.println(member4.getName() + " " + member4.getSurname() + " - " + "связь: " +
                                controller.searchRecitation(member4, relatives));
        }
}