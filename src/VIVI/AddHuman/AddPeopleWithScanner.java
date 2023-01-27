package VIVI.AddHuman;

import Homework_6.Designer_Human;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class AddPeopleWithScanner implements IAddHuman{

    private List<Designer_Human> designer_human;
    private void addHumans(String name, String sex, int date) {
        Designer_Human HH = new Designer_Human(name, sex, date);
        designer_human.add(HH);
    }
    @Override
    public void addHuman(Designer_Human human) {
        Scanner scanner = new Scanner(in);
        String end = "Готово";
        for (; ; ) {
            String newFio = scanner.nextLine();
            if (newFio.equals(end)) ;
            {
                System.out.println(human);
                String newSex = scanner.nextLine();
                if (newSex.equals(end)) ;
                {
                    System.out.println(human);

                    Integer newDate = scanner.nextInt();
                    if (newDate != null && newDate.equals(end)) //Пытался сделать по разному только так сработало
                    //Нужен вывод типа boolean
                    {
                        System.out.println(human);
                        continue;

                    }
//                    human.Designer_Human.addHumansimple();
                    addHumans(newFio, newSex, newDate);
                }
                this.designer_human.add(human);
            }
        }
    }
}
