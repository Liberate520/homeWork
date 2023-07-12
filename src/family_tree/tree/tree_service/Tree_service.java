package family_tree.tree.tree_service;
import family_tree.model.infrastucture.My_Scanner;
import family_tree.tree.FamilyTree;

import java.util.Scanner;


public class Tree_service implements My_Scanner {
    Scanner sc = My_Scanner.sc;

     public Boolean clearFamilyTree(){
        System.out.print("Семейное древо будет очищено.\n" +
                "Для подтверждения введите \"Yes\": ");
        String str2 = sc.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            System.out.println("Семейное древо успешно очищено");
            return true;
        } else {
            System.out.println("Действие отменено.");
            return false;
        }
    }

    public FamilyTree sortById(FamilyTree family_tree){
        family_tree.sortById();
        return  family_tree;
    }
    public FamilyTree sortByName(FamilyTree family_tree){
         family_tree.sortByName();
         return  family_tree;
    }

    public FamilyTree sortByAge(FamilyTree family_tree){
         family_tree.sortByAge();
        return  family_tree;
    }
}
