package ru.gb.model.service;

import ru.gb.model.data.Gender;
import ru.gb.model.family_tree.FamilyTree;
import ru.gb.model.human.Human;
import ru.gb.model.human.HumanComparatorByAge;
import ru.gb.model.human.HumanComparatorByName;
import ru.gb.model.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler<FamilyTree<Human>> fileHandler;

    public Service() {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler<>();
    }
    public void setConnection(Scanner scanner) {
        System.out.println("Введите id ребенка");
        long childId = Long.parseLong(scanner.nextLine());
        System.out.println("Введите id родителя");
        long parentId = Long.parseLong(scanner.nextLine());
        String answer = familyTree.setConnection(childId, parentId);
        System.out.println(answer);
    }
    public void addHuman (Human human) {
        familyTree.addHuman(human);
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(familyTree.getHumansId());
        sb.append(" объектов: \n");

        for (Human human: familyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    public Human createHuman(Scanner scanner){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения человека в формате ДД_ММ_ГГ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите пол в формате Male или Female");
        Gender gender = Gender.valueOf(scanner.nextLine());

        return new Human(name, birthday, gender);
    }
    public void save() throws IOException {
        fileHandler.save(familyTree);
    }
    public void load() throws IOException, ClassNotFoundException {
        familyTree = fileHandler.load();

    }
}
