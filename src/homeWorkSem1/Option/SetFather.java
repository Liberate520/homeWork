package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class SetFather<T extends Human> implements Serializable, Option {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String description() {
        return String.format("Set Father of Human");
    }

    @Override
    public void exucute(FamilyTree<Human> tree) {
        System.out.printf("Введите имя человека ");
        String getName = scanner.nextLine();
        List<Human> res = tree.getHumanbyName(getName);
        System.out.printf("Enter Father's name: ");
        String nameFather = scanner.nextLine();
        List<Human> res2 = tree.getHumanbyName(nameFather); 
        for (Human human : res) {
            for (Human hum : res2) {
                human.setFather(hum);
                hum.setChildren(res); //одновременно отцу добавится ребенок
            }      
        }
        for (Human element : res) {
            for (Human el : res2) {
                System.out.printf("добавились дети: " + el.getChildren());
                System.out.printf("добавился отец: " + element.getFather());
            }    
        } 
        
    }
}
