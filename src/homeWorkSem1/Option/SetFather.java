package homeWorkSem1.Option;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class SetFather<T extends Human> implements Serializable, Option {

    Scanner iScanner = new Scanner(System.in);
    
    @Override
    public void execute(FamilyTree<Human> tree) {
        System.out.println("Enter Name of human: ");
        String getName = iScanner.nextLine();
        List<Human> res = tree.getHumanbyName(getName);
        System.out.println("Enter Father's name: ");
        String nameFather = iScanner.nextLine();
        List<Human> res2 = tree.getHumanbyName(nameFather);
        iScanner.close(); 
        for (Human human : res) {
            for (Human hum : res2) {
                human.setFather(hum);
                hum.setChildren(res); //одновременно отцу добавится ребенок
            }      
        }
        for (Human element : res) {
            for (Human el : res2) {
                System.out.printf("%s добавились дети: \n%s", el.getName(), el.getChildren());
                System.out.printf("\n%s добавился отец: \n%s", element.getName(), element.getFather());
            }    
        }  
        
    }

    @Override
    public String description() {
        return String.format("Set Father of Human");
    }
    
}
