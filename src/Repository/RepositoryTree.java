package Repository;

import Human.Human;
import Human.IWorkTreeFamily;
import Human.WorkTreeFamily;
import View.View;
import View.ConsoleUI;

public class RepositoryTree {
    IWorkTreeFamily iThree = new WorkTreeFamily();
    View uI = new ConsoleUI();
    public void get(int num){
        switch (num){
            case 1:
                // Просмотр всех записей
                iThree.allHuman();
                uI.start();
            case 2:
                // Создание человека
                Human human = new Human(null,0);
                human.setName(uI.scanString("Введите имя: "));
                human.setAge(uI.scanInt("Введите возраст: "));
                iThree.addTreeFamily(human);
                System.out.println("Человек создан");
                uI.start();
            case 3:
                // Просмотр определенного человека
                iThree.loopHuman(uI.scanString("Введите имя: "));
                uI.start();
            case 4:
                // Создание связи
                Human baby = iThree.loopHuman(uI.scanString("Введите имя ребенка: "));
                Human parent1 = iThree.loopHuman(uI.scanString("Введите имя 1 родителя: "));
                Human parent2 = iThree.loopHuman(uI.scanString("Введите имя 2 родителя: "));
                iThree.addChildren(baby,parent1,parent2);
                System.out.println("Связь создана");
                uI.start();
            default:
                System.out.println("Такой опции еще не существует");


        }
    }


}

