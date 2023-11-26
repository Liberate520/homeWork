package family_tree.model.family_tree.service;

import family_tree.model.family_tree.Family_tree;
import family_tree.model.family_tree.human.Gender;
import family_tree.model.family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Service {
    private Family_tree familyTree;
    private Scanner scanner;
    private FileHandler fileHandler;

    public Service() {
        familyTree = new Family_tree();
        scanner = new Scanner(System.in);
        fileHandler = new FileHandler();
    }

    public void AddHuman(String snils, String fam, String name, LocalDate dr){
        Human human = new Human(snils, fam, name, dr);

        familyTree.AddHuman(human);

    }

    public String GetHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Object human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        return GetHumanListInfo();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByFam(){
        familyTree.sortByFam();
    }

    public void sortByAge(){
        familyTree.sortByDr();
    }

    public void AddMather(){
        System.out.println("Введите снилс кому добавляем мать");
        String snils = scanner.nextLine();
        Human thisHuman = familyTree.SelectHuman(snils);
        if (thisHuman == null){
            System.out.println("Человек не найден по СНИЛС");
            return;
        }
        System.out.println("Введите снилс матери");
        snils = scanner.nextLine();
        Human mather = familyTree.SelectHuman(snils);
        if (mather == null){
            System.out.println("Мать не найдена по СНИЛС");
            return;
        }
        thisHuman.AddMother(mather);
    }

    public void AddFather(){
        System.out.println("Введите снилс кому добавляем отца");
        String snils = scanner.nextLine();
        Human thisHuman = familyTree.SelectHuman(snils);
        if (thisHuman == null){
            System.out.println("Человек не найден по СНИЛС");
            return;
        }
        System.out.println("Введите снилс отца");
        snils = scanner.nextLine();
        Human father = familyTree.SelectHuman(snils);
        if (father == null){
            System.out.println("Отец не найден по СНИЛС");
            return;
        }
        thisHuman.AddFather(father);
    }

    public void SaveFamily() throws IOException, ClassNotFoundException {
        fileHandler.SaveFamily_tree(familyTree);
    }
    public void LoadFamily() throws IOException, ClassNotFoundException {
        familyTree = fileHandler.LoadFamily_tree();
    }


}
