package homeWorkSem1.View;

import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Service.Gender;

public class View {
    Scanner in = new Scanner(System.in);

    Gender gend;

    Gender res;


    /**Получаем выбор пользователя */
    public int getValue(String title) {
        System.out.printf("%s ", title);
        return in.nextInt();
    }

    public String getInfo(String title) {
        System.out.printf("%s ", title);
        return in.nextLine();
    }

    public Gender getGender(String title) {
        System.out.printf("%s ", title);
        String g = in.next();
        
        for (Gender gender : Gender.values()) {
            if (gender.getGender1() == g) {
                gend = Gender.Female;
            }
            else gend = Gender.Male;
        }
        return res;
    }

    public void answer(String title) {
        System.out.printf("%s", title);
    }

    public void showTree(FamilyTree<Human> tree) {
        System.out.println(tree);
    }


    // /**Демонстрация меню пользователю */
    // public void getMenu(List<Option> commandList) {
    //     for (int index = 0; index < commandList.size(); index++) {
    //         System.out.println(index+1 + ": " + commandList.get(index).description());
    //     }
    // }

}
