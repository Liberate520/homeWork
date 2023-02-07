package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class GetGrands<T extends Human> implements Serializable, Option {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String description() {
        return String.format("Get Grands of Human");
    }

    @Override
    public void exucute(FamilyTree<Human> tree) {
        System.out.printf("Введите имя человека ");
        String findByName = scanner.nextLine();
        List<Human> list = new ArrayList<>();
        List<Human> humans = tree.getHumans();
        try {
            for (Human human : humans ) {
                if (findByName.equals(human.getName())) {
                    list.add(human.getFather().getFather());
                    list.add(human.getFather().getMother());
                    list.add(human.getMother().getFather());
                    list.add(human.getMother().getMother());
                    if (human.getFather().getFather() == null) {
                        System.out.printf("дедушки по папиной линии нет");
                    }
                    else if (human.getFather().getMother() == null) {
                        System.out.printf("бабушки по папиной линии нет");
                    }
                    else if (human.getMother().getFather() == null) {
                        System.out.printf("дедушки по маминой линии нет");
                    }
                    else if (human.getMother().getMother() == null) {
                        System.out.printf("бабушки по маминой линии нет");
                    }
                
                }
            }
        }
        catch (Exception e) {
            System.out.println("ошибка");
        }
        System.out.printf("Grands are: "+ list);          
    }    
}
