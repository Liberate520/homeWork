package HWGT.model.commands;

import HWGT.model.FamilyTree;
import HWGT.model.Person;

import java.util.Scanner;

public class PersonEnvironment {
    private FamilyTree familyTree;
//    private AddFather addFather;

    public PersonEnvironment(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void updateData (FamilyTree familyTree){
        CheckName checkName = new CheckName(familyTree);
        AddFather addFather = new AddFather(familyTree);
        AddMother addMother = new AddMother(familyTree);
        AddChild addChild = new AddChild(familyTree);
        String personName;

        System.out.println("Введите имя(без пробелов) человека для изменения данных об его окружени\n");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName.getCheck(familyTree, personName)){
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));

            System.out.println("Выберите какую информацию вы желаете добавить");
            System.out.println("1 - Отец");
            System.out.println("2 - Мать");
            System.out.println("3 - Ребенок \n");
            String token = scanner1.next();
            switch (token){
                case ("1") :{
                    addFather.add(familyTree,personName);
                    break;
                }
                case ("2") :{
                    addMother.add(familyTree,personName);
                    break;
                }
                case ("3") : {
                    addChild.add(familyTree, personName);
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
}