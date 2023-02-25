package HW01;

import HW01.model.FamilyTree;
import HW01.model.Person;

import java.util.List;
import java.util.Scanner;

public class Methods {

    private FamilyTree familyTree;

    public Methods(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void fillAllPersons (FamilyTree familyTree) {

        familyTree.setPerson(new Person("Ivan1","male", 1000, 1030,"Unknown", "Unknown", List.of()));
        familyTree.setPerson(new Person("Ivan2","male", 1021, 1040, "Unknown", "Ivan1", List.of()));
        familyTree.setPerson(new Person("Vasiliy1","male", 1036, 1055, "Unknown", "Ivan2", List.of()));
        familyTree.setPerson(new Person("Fedor1","male", 1031, 1060, "Unknown", "Ivan2", List.of()));
        familyTree.setPerson(new Person("Sofia1","female", 1035, 1069, "Unknown", "Ivan2", List.of()));

        familyTree.getPerson("Ivan1").addChild("Ivan2");
        familyTree.getPerson("Ivan2").addChild("Vasiliy1");
        familyTree.getPerson("Ivan2").addChild("Fedor1");
        familyTree.getPerson("Ivan2").addChild("Sofia1");

    }

    public boolean checkName(FamilyTree familyTree, String name) {
//        если имя найдено в базе то true иначе false
        return (familyTree.getPerson(name) != null);
    }
    public void searchPerson(FamilyTree familyTree){
        String nameForSearch="";
        System.out.println("введите имя человека для поиска \n");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        nameForSearch = scanner1.next();
//        scanner1.close();
        if (checkName(familyTree,nameForSearch))
        {
            System.out.println(familyTree.getPerson(nameForSearch));
        }
        else{
            System.out.println("человек с таким именем не найден");
        }
    }

    public void addNewPerson (FamilyTree familyTree){
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

    public void updatePerson (FamilyTree familyTree){
        String personName;
        Integer birthDate;
        Integer deathDate;

        System.out.println("Выберите человека для изменения данных об его окружени\n");
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
        }
    }

    public void addPersonEnvironment(FamilyTree familyTree){
        String personName;
        String personSex;
        String fatherName;
        String motherName;
        Integer birthData;
        Integer deathData;
        Integer childName;

        System.out.println("Выберите человека для изменения данных об его окружени\n");
        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName(familyTree, personName)){
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));
            System.out.println("Введите имя отца(без пробелов) или 'unknown'\n");
            fatherName = scanner1.next();
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
            System.out.println("Введите имя матери(без пробелов) или 'unknown'\n");
            motherName = scanner1.next();
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
        else{
            System.out.println("такого человека нет в базе даных \n");
        }
    }
}
