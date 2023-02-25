package HW01;

import HW01.model.FamilyTree;
import HW01.model.Repo;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Presenter {
//    private FamilyTree familyTree;
    public void Interface () throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        Methods methods = new Methods(familyTree);
        View view = new View();

        String str = "";
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        while (!str.equals("0")){
            view.showMenu();

            str = scanner1.next();

            switch (str){
                case ("1"):{
                    // создаем объект дерево содержащий соответствия - имя человека - его ближаейшее окружение
                    methods.fillAllPersons (familyTree);
                    System.out.println("база тестовых данных загружена \n");
                    break;
                }
                case ("2"):{
                    familyTree = null;
//                    читаем ранее записаные списки людей и их связей
                    Repo repo1 = new Repo();
                    familyTree = (FamilyTree) repo1.read("familyTree.out");
                    System.out.println("база данных загружена \n");
                    break;
                }
                case ("3"): {
//                    3 - ввести данные о новом человеке"
                    methods.addNewPerson(familyTree);
                    break;
                }
                case ("4"): {
//                    4 - ввести изменения в запись"
                    methods.updatePerson(familyTree);
                    break;
                }
                case ("5"): {
//                    4 - ввести данные об окруженнии человека"
                    methods.addPersonEnvironment(familyTree);
                    break;
                }
                case ("6"): {
                    // выводим список всех людей в базе данных
                    for(Object pers:familyTree){
                        System.out.println(pers);
                    }
                    break;
                }
                case ("7"): {
//                    введите имя человека для поиска
                    methods.searchPerson(familyTree);
                }
                case ("8"):{
//                    записываем списки людей и их связей
                    Repo repo1 = new Repo();
                    repo1.save((Serializable) familyTree, "familyTree.out");
                    System.out.println("база данных сохранена \n");
                    break;
                }
                case ("9"):{
//                    сортировка по имени
                    familyTree.sortByName();
                    for(Object pers:familyTree){
                        System.out.println(pers);
                    }
                    break;
                }
                case ("10"):{
//                    сортировка по имени
                    familyTree.sortByBirth();
                    for(Object pers:familyTree){
                        System.out.println(pers);
                    }
                    break;
                }
                default:{
                    if (!str.equals("0")) {
                        System.out.println("неверный ключ");
                    }
                    break;
                }
            }
        }
        scanner1.close();
        System.out.println("До новых встреч! \n");
    }
}

