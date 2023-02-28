package HWGT.model;

import java.util.List;
import java.util.Scanner;

public class Service {
    private FamilyTree familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void fillTestTree(FamilyTree familyTree) {
        familyTree.setPerson(new Person("Ivan1","male", 1000, 1030,"Unknown", "Unknown", List.of("Ivan2")));
        familyTree.setPerson(new Person("Ivan2","male", 1021, 1040, "Unknown", "Ivan1", List.of("Vasiliy1","Fedor1","Sofia1")));
        familyTree.setPerson(new Person("Vasiliy1","male", 1036, 1055, "Unknown", "Ivan2", List.of()));
        familyTree.setPerson(new Person("Fedor1","male", 1031, 1060, "Unknown", "Ivan2", List.of()));
        familyTree.setPerson(new Person("Sofia1","female", 1035, 1069, "Unknown", "Ivan2", List.of()));
        System.out.println("тестовое дерево создано");
    }

    public boolean checkName (FamilyTree familyTree, String name){
        System.out.println(familyTree.getPerson(name));
        return (familyTree.getPerson(name)!=null);
    }

    public void addPerson (FamilyTree familyTree){
        String personName;
        String personSex;
        Integer birthData;
        Integer deathData;

        System.out.println("Введите данные о новом человеке");
        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
//                    scanner1.close();
        if (checkName(familyTree, personName)){
            System.out.println("такой человек уже есть в базе даных \n");
        }
        else{
            System.out.println("Введите пол");
            personSex = scanner1.next();
            System.out.println("год рождения");
            birthData = scanner1.nextInt();
            System.out.println("год смерти");
            deathData = scanner1.nextInt();

            familyTree.setPerson(new Person(personName,personSex, birthData, deathData));
            System.out.println("человек добавлен \n");
        }

    }

    public void updatePerson(FamilyTree familyTree) {
        String personName;
        Integer birthDate;
        Integer deathDate;

        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName(familyTree, personName)) {
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));
            System.out.println("введите год рождения или '0'\n");
            birthDate = scanner1.nextInt();
            if (birthDate > 0) {
                familyTree.getPerson(personName).setDateOfBirth(birthDate);
            }
            System.out.println("введите год смерти или '0'\n");
            deathDate = scanner1.nextInt();
            if (deathDate > 0) {
                familyTree.getPerson(personName).setDateOfDeath(deathDate);
            }
            System.out.println(familyTree.getPerson(personName));
        }
    }

    public void personEnvironment (FamilyTree familyTree){
        String personName;

        System.out.println("Введите имя(без пробелов) человека для изменения данных об его окружени\n");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName(familyTree, personName)){
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));

            System.out.println("Выберите какую информацию вы желаете добавить");
            System.out.println("1 - Отец");
            System.out.println("2 - Мать");
            System.out.println("3 - Ребенок \n");
            String token = scanner1.next();
            switch (token){
                case ("1") :{
                    addFather(familyTree, personName);
                    break;
                }
                case ("2") :{
                    addMother(familyTree, personName);
                    break;
                }
                case ("3") : {
                    addChild(familyTree, personName);
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + token);
            }
            System.out.println(familyTree.getPerson(personName));
        }
        else{
            System.out.println("такого человека нет в базе даных \n");
        }
    }

    public void searchPerson(FamilyTree familyTree, String personName){
        if (checkName(familyTree, personName)){
            System.out.println(familyTree.getPerson(personName));
        }
        else {
            System.out.println("Человек с таким именем не найден");
        }
    }


    public void sortByName(FamilyTree familyTree) {
        familyTree.sortByName();
        System.out.println("сортировка по имени работает");
    }

    public void sortByBirthDate(FamilyTree familyTree) {
        familyTree.sortByBirth();
        System.out.println("сортировка по году рождения работает");
    }
    public void addMother(FamilyTree familyTree, String personName){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите имя матери(без пробелов) или 'unknown'\n");
        String motherName = scanner1.next();
        if (!motherName.equals("unknown")){
            if (checkName(familyTree, motherName)) {
                familyTree.getPerson(personName).setMother(motherName);
                familyTree.getPerson(motherName).addChild(personName);
            }
            else{
                familyTree.getPerson(personName).setMother(motherName);
                familyTree.setPerson(new Person(motherName,"female", 0, 0));
                familyTree.getPerson(motherName).addChild(personName);
            }
        }
    }
    public void addFather (FamilyTree familyTree, String personName){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите имя отца(без пробелов) или 'unknown'\n");
        String fatherName = scanner1.next();
        if (!fatherName.equals("unknown")){
            if (checkName(familyTree, fatherName)) {
                familyTree.getPerson(personName).setFather(fatherName);
                familyTree.getPerson(fatherName).addChild(personName);
            }
            else{
                familyTree.getPerson(personName).setFather(fatherName);
                familyTree.setPerson(new Person(fatherName,"male", 0, 0));
                familyTree.getPerson(fatherName).addChild(personName);
            }
        }
    }
    public void addChild (FamilyTree familyTree, String personName){

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите имя ребенка(без пробелов) или 'unknown'\n");
        String childName = scanner1.next();

        if (!childName.equals("unknown")){
            if (checkName(familyTree, childName)) {
            }
            else{
                System.out.println("Введите пол ребенка\n");
                String childSex = scanner1.next();
                familyTree.setPerson(new Person(childName,childSex, 0, 0));

            }
            familyTree.getPerson(personName).addChild(childName);
            if (familyTree.getPerson(personName).getSex().equals("male")){
                familyTree.getPerson(childName).setFather(personName);
            }else{
                familyTree.getPerson(childName).setMother(personName);
            }
        }
    }
}
