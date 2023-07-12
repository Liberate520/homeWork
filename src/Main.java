import Classes.FamilyTree;
import Classes.Human;
import Classes.TestInput;

import java.time.LocalDate;

import static Classes.Gender.female;
import static Classes.Gender.male;

public class Main {


    public static void main(String[] args){

        FamilyTree tree =new FamilyTree();
         TestInput.TestInput(tree);//Тестовый вариант заполнения списка
        System.out.println(tree.humanList.size());
        System.out.println(tree.getInfo());

    }



}
